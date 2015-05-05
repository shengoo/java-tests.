package appContext;

import java.net.URL;

public class GetFileDir {

	public GetFileDir() {
		// ��ȡ��ǰ���ļ����ڰ��ĸ�Ŀ¼
		System.out.println(System.getProperty("user.dir").replace("\\", "/"));
		// ��ȡ��ǰ���ļ����ڵ�Ŀ¼
		System.out.println(this.getClass().getResource("").getPath()
				.replaceAll("%20", " "));
		java.net.URL u = this.getClass().getResource("GetFileDir.class");
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

		path = path.replace("%20", " ");

		return path.substring(1, path.length());

	}

}
