/**
 * 
 */
package iotest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/**
 * @author Qing
 * @date 2011-6-17
 * 
 */
public class ReadAndWriteFile {

	File inFile = new File("D:/zip/2.0.zip");
	public static final int BufferSize = 2048;

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ReadAndWriteFile o = new ReadAndWriteFile();
		o.rw1();
		o.useChannel();
	}

	public void rw1() throws Exception {
		long start = System.currentTimeMillis();
		FileInputStream in = new FileInputStream(inFile);
		File outFile = getOutFile();
		FileOutputStream out = new FileOutputStream(outFile);
		byte[] buffer = new byte[BufferSize];
		while (true) {
			int ins = in.read(buffer);
			if (ins == -1) {
				in.close();
				out.flush();
				out.close();
				break;
			} else{
				for (int i = 0; i < 10; i++) {
					out.write(buffer, 0, ins);
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start) + "ms");
		outFile.delete();
	}

	public void useChannel() throws Exception {
		long start = System.currentTimeMillis();
		int length = 2097152;
		FileInputStream in = new FileInputStream(inFile);
		File outFile = getOutFile();
		FileOutputStream out = new FileOutputStream(outFile);
		FileChannel inC = in.getChannel();
		FileChannel outC = out.getChannel();
		int i = 0;
		while (true) {
			if (inC.position() == inC.size()) {
				inC.close();
				outC.close();
				break;
			}
			if ((inC.size() - inC.position()) < 20971520)
				length = (int) (inC.size() - inC.position());
			else
				length = 20971520;
			inC.transferTo(inC.position(), length, outC);
			inC.position(inC.position() + length);
			i++;
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start) + "ms");
		outFile.delete();
	}

	public File getOutFile() {
		File file = new File("D:/zip/copy/" + Math.random() * 65536);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		return file;
	}

}
