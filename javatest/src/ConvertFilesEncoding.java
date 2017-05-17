import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;


public class ConvertFilesEncoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "encodingtest.java";
		System.out.println(path);
		File file = new File(path);
		if(file.exists()){
			try {
	            String s = FileUtils.readFileToString(file, "GBK");
	            System.out.println("convert " + file.getPath());
	            FileUtils.writeStringToFile(file, s, "UTF-8");
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		}else{
			System.out.println("File not exist. " + path);
		}
	}

}
