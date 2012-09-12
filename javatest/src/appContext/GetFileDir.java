package appContext;

import java.net.URL;

public class GetFileDir {

	
	public GetFileDir(){
		//获取当前类文件所在包的根目录  
		System.out.println(System.getProperty("user.dir").replace("\\", "/"));  
		//获取当前类文件所在的目录  
		System.out.println(this.getClass().getResource("").getPath().replaceAll("%20", " "));  
        java.net.URL  u= this.getClass().getResource("GetFileDir.class"); 
        System.out.println(u.getPath());
        System.out.println(getResourcePath());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new GetFileDir();
		
		
	}
	private static String getResourcePath() {
		
		        String className = GetFileDir.class.getName();
		
		        String classNamePath = className.replace(".", "/") + ".class";
		
		        URL is = GetFileDir.class.getClassLoader().getResource(classNamePath);
		
		        String path = is.getFile();
		
		        path = path.replace( "%20", " ");
		
		 
		
		        return path.substring(1, path.length());
		
		    }


}
