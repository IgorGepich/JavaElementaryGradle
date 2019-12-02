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
			int readChunk;
			while ((readChunk = inputStream.read()) != -1 && !Thread.currentThread().isInterrupted()) {
				outputStream.write(chunk, 0, readChunk);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
