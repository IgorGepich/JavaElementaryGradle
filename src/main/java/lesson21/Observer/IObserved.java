package lesson21.Observer;

public interface IObserved {
	void addObserver(IObserver o);
	void removeObserver(IObserver o);
	void notifyObservers();
}
