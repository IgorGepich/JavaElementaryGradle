package lesson21;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class Fibonacci implements Callable<BigInteger> {

	private int length;
	private State state;

	Fibonacci(int length, State state) {
		this.length = length;
		this.state = state;
		System.out.println("Start State: " + state.previousNumber + ", " + state.currentNumber);
	}

	State getState() {
		return state;
	}

	@Override
	public BigInteger call() {
		BigInteger sumFibonacci;
		for (int i = 1; i <= length; i++) {
			if (!Thread.currentThread().isInterrupted()) {
				System.out.printf("Fibonacci step: %d\n", i);
				sumFibonacci = state.previousNumber.add(state.currentNumber);
				state.previousNumber = state.currentNumber;
				state.currentNumber = sumFibonacci;
				System.out.printf("Fibonacci pair: %d and %d\n", state.previousNumber, state.currentNumber);
			}
			else {
				break;
			}
		}
		return state.currentNumber;
	}
}

