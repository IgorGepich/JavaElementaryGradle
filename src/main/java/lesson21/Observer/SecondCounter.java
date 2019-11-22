package lesson21.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class SecondCounter implements Callable<Integer>, IObserved {
	private List<IObserver> IObservers = new ArrayList<>();

	private int second = 0;

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
		IObservers.add(o);
	}

	@Override
	public void removeObserver(IObserver o) {
		IObservers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for(IObserver o : IObservers){
			o.onHandleEvent(second);
		}
	}

	@Override
	public String toString() {
		return "SecondCounter{" +
				"second=" + second +
				'}';
	}

	public int getSecond() {
		return second;
	}
}
