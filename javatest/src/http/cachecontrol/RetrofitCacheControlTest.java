package http.cachecontrol;

import http.CacheTest.News;
import http.CacheTest.NewsService;

import java.io.File;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.http.GET;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

public class RetrofitCacheControlTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OkHttpClient okHttpClient = new OkHttpClient();
	    File cacheDir = new File(System.getProperty("java.io.tmpdir"), "retrofit");
	    System.out.println(cacheDir.getAbsolutePath());
	    Cache cache = new Cache(cacheDir, Integer.MAX_VALUE);
	    okHttpClient.setCache(cache);
	    
	    
	    Executor executor = Executors.newCachedThreadPool();
	    RestAdapter restAdapter = new RestAdapter.Builder()
        .setExecutors(executor, executor)
        .setClient(new OkClient(okHttpClient))
        .setEndpoint("http://10.35.24.186/TestServer")
        .build();
	    
	    NewsService service = restAdapter.create(NewsService.class);
	    List<News> newsList = service.news();
        System.out.println(newsList);
        List<News> newsList2 = service.news();
        System.out.println(newsList2);
        
        System.out.println(cache.getRequestCount());
	}
	
	public static class News {
        public final String title;
        public final String image;

        public News(String title, String image) {
            this.title = title;
            this.image = image;
        }
    }

    public interface NewsService {
        @GET("/api/test/GetNewsList2")
        List<News> news();
    }

}
