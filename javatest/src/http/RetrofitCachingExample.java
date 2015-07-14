package http;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.http.GET;
import retrofit.http.Path;

public class RetrofitCachingExample {

	interface SodaService {
	    @GET("/{brand}") Object cola(@Path("brand") String brand);
	  }
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// Create a web server. MockWebServer is good. Use it.
	    MockWebServer mockWebServer = new MockWebServer();
	    mockWebServer.play();
	 
	    // Create an HTTP client that uses a cache on the file system. Android applications should use
	    // their Context to get a cache directory.
	    OkHttpClient okHttpClient = new OkHttpClient();
	    File cacheDir = new File(System.getProperty("java.io.tmpdir"), "retrofit");
//	    File cacheDir = new File("C:\temp");
	    System.out.println(cacheDir.getAbsolutePath());
	    Cache cache = new Cache(cacheDir, 1024);
	    okHttpClient.setCache(cache);
	 
	    // Create a Retrofit RestAdapter for our SodaService interface.
	    Executor executor = Executors.newCachedThreadPool();
	    RestAdapter restAdapter = new RestAdapter.Builder()
	        .setExecutors(executor, executor)
	        .setClient(new OkClient(okHttpClient))
	        .setEndpoint(mockWebServer.getUrl("/").toString())
	        .build();
	    SodaService sodaService = restAdapter.create(SodaService.class);
	 
	    // /pepsi hits the web server and returns a response that will be fully cached for 60 seconds.
	    mockWebServer.enqueue(new MockResponse()
	        .addHeader("Cache-Control: max-age=60")
	        .setBody("\"You got the right one, baby\""));
	    System.out.println(sodaService.cola("pepsi"));
//	    assertThat(sodaService.cola("pepsi")).isEqualTo("You got the right one, baby");
//	    assertThat(cache.getRequestCount()).isEqualTo(1);
//	    assertThat(cache.getNetworkCount()).isEqualTo(1);
//	    assertThat(cache.getHitCount()).isEqualTo(0);
	 
	    // /coke hits the web server and returns a response that will be conditionally cached.
	    mockWebServer.enqueue(new MockResponse()
	        .addHeader("ETag: v1")
	        .setBody("\"Always Coca-Cola\""));
	    System.out.println(sodaService.cola("coke"));
//	    assertThat(sodaService.cola("coke")).isEqualTo("Always Coca-Cola");
//	    assertThat(cache.getRequestCount()).isEqualTo(2);
//	    assertThat(cache.getNetworkCount()).isEqualTo(2);
//	    assertThat(cache.getHitCount()).isEqualTo(0);
	 
	    // /pepsi returns a response from the cache.
//	    assertThat(sodaService.cola("pepsi")).isEqualTo("You got the right one, baby");
//	    assertThat(cache.getRequestCount()).isEqualTo(3);
//	    assertThat(cache.getNetworkCount()).isEqualTo(2);
//	    assertThat(cache.getHitCount()).isEqualTo(1);
	 
	    // /coke validates the cached response. The server says the cached version is still good.
	    mockWebServer.enqueue(new MockResponse()
	        .setResponseCode(304));
	    System.out.println(sodaService.cola("coke"));
//	    assertThat(sodaService.cola("coke")).isEqualTo("Always Coca-Cola");
//	    assertThat(cache.getRequestCount()).isEqualTo(4);
//	    assertThat(cache.getNetworkCount()).isEqualTo(3);
//	    assertThat(cache.getHitCount()).isEqualTo(2);
	    mockWebServer.shutdown();
	}

}
