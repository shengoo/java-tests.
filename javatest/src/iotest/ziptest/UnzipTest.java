package iotest.ziptest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipTest {

	/**
	 * @param args
	 */
	
	
	static final int BUFFER = 20480;
	static String unzipDir = "D:/temp/unzip/";
	static File zipFile = new File("D:/temp/book.zip");
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "D:/zip/noen.zip";
		String password = "123456";
		String extractDir = "D:/zip/unzip/" + Math.random() * 65536
				+ File.separator;

		long start = System.currentTimeMillis();
		
		try {
			BufferedOutputStream dest = null;
			FileInputStream fis = new FileInputStream(fileName);
			ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
			ZipEntry entry;
			while((entry = zis.getNextEntry()) != null){
				File file = new File(extractDir + entry.getName());
				if(entry.isDirectory())
				{
					if(!file.exists())
						file.mkdirs();
					System.out.println("Create directory: " + file.getAbsolutePath());
					continue;
				}
				System.out.print("Extracting:" + entry);
				int count;
				byte data[] = new byte[BUFFER];
				System.out.println(" to " + file.getAbsolutePath());

				FileOutputStream fos = new FileOutputStream(file);
				dest = new BufferedOutputStream(fos,BUFFER);
				while((count = zis.read(data, 0, BUFFER)) != -1){
					dest.write(data, 0, count);
				}
				dest.flush();
				dest.close();
			}
			zis.close();
			long end = System.currentTimeMillis();
	        System.out.println(end - start + "ms");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
