package iotest.ziptest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Unzip2 {

	static final int BUFFER = 2048;
	
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String fileName = "D:/zip/noen.zip";
		String password = "123456";
		String extractDir = "D:/zip/unzip/" + Math.random() * 65536
				+ File.separator;

    	long start = System.currentTimeMillis();
    	new File(extractDir).mkdirs();
    	
		FileInputStream fin = new FileInputStream(fileName);
		ZipInputStream zin = new ZipInputStream(fin);
		ZipEntry ze = null;
		while ((ze = zin.getNextEntry()) != null) {
			if (ze.isDirectory()) {
				System.out.println("Create directory:" + extractDir + ze.getName());
				new File(extractDir + ze.getName()).mkdirs();
				continue;
			}
			System.out.println("Unzipping " + ze.getName());
			FileOutputStream fout = new FileOutputStream(extractDir + ze.getName());
//			for (int c = zin.read(); c != -1; c = zin.read()) {
//				fout.write(c);
//			}
			byte[] data = new byte[BUFFER];
			int count;
			while((count = zin.read(data, 0, BUFFER)) != -1){
				fout.write(data, 0, count);
			}
			zin.closeEntry();
			fout.close();
		}
		zin.close();
		
		long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");//10684ms
	}
}
