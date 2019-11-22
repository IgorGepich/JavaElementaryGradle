package lesson21;

import java.io.*;

public class CopyFile implements Runnable{
	private String filePath = "	../binder3.pdf";
	private String filePathOut = "~/binder3Copy.pdf";

	@Override
	public void run() {
		try (InputStream inputStream = new FileInputStream(filePath);
			 OutputStream outputStream = new FileOutputStream(filePathOut)) {
			byte[] chunk = new byte[4096];
			while (inputStream.available() > 0) {
				int readFile = inputStream.read(chunk);
				if (readFile <= 0) {
					break;
				}
				outputStream.write(chunk);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
