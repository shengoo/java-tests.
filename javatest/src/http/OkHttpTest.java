package http;

import java.io.File;
import java.io.IOException;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class OkHttpTest {
	
	OkHttpClient client = new OkHttpClient();
	Cache cache;
	
	public OkHttpTest(){
		
	  File cacheDir = new File(System.getProperty("java.io.tmpdir"), "retrofit");
	  cache = new Cache(cacheDir,Integer.MAX_VALUE);
	  client.setCache(cache);
		
	}

	  String run(String url) throws IOException {
	    Request request = new Request.Builder()
//	    .cacheControl(new CacheControl.Builder()
//        .onlyIfCached()
//        .build())
	        .url(url)
	        .build();

	    Response response = client.newCall(request).execute();
	    System.out.println(cache.getNetworkCount());
	    return response.body().string();
	  }

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		OkHttpTest example = new OkHttpTest();
	    String response = example.run("http://10.35.24.186/TestServer/api/test/GetNewsList");
	    System.out.println(response);
	    String response2 = example.run("http://10.35.24.186/TestServer/api/test/GetNewsList");
	    System.out.println(response2);
	}

}
