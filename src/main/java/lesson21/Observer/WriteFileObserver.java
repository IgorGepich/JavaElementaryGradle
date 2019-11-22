package lesson21.Observer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class WriteFileObserver implements IObserver {
	private List<String> seconds = new ArrayList<>();
	@Override
	public void onHandleEvent(int second) {
		seconds.add("\nSecond: " + second);
		try (PrintWriter writer = new PrintWriter(
				new FileOutputStream("seconds.txt"))){
			writer.println(seconds);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
