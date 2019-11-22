package lesson21.Observer;

public class ConsoleObserver implements IObserver {

	@Override
	public void onHandleEvent(int second) {
		System.out.println("Observer receive time: " + second);
	}
}
