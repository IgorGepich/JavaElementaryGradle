package lesson21;

import java.math.BigInteger;
import java.util.concurrent.Callable;

class Factorial implements Callable<BigInteger> {
	private int value;

	Factorial(int value) {
		this.value = value;
	}

	@Override
	public BigInteger call() {
		BigInteger bigInteger = BigInteger.valueOf(1);
		for (int i = 1; i <= value; i++) {
			if(!Thread.currentThread().isInterrupted()){
				System.out.println("Factorial step: " + i);
				bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
//				System.out.println("Result factorial: " + bigInteger);
			}
			else {
				break;
			}
		}
		return bigInteger;
	}
}
