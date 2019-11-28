package lesson21.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class SecondCounter implements Callable<Integer>, IObserved {
	private List<IObserver> observers = new ArrayList<>();

	private int second = 0;

	private int getSecond() {
		return second;
	}

	@Override
	public Integer call() throws Exception {
		while (!Thread.currentThread().isInterrupted()){
			Thread.sleep(1000);
			System.out.println("Seconds: " + +second);
			notifyObservers();
			second++;
		}
		return second;
	}

	@Override
	public void addObserver(IObserver o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(IObserver o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for(IObserver o : observers){
			o.onHandleEvent(getSecond());
		}
	}

	@Override
	public String toString() {
		return "SecondCounter{" +
				"second=" + second +
				'}';
	}
}
