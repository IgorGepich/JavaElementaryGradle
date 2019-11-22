package lesson21;

import lesson21.Observer.ConsoleObserver;
import lesson21.Observer.Mqtt.PublisherClient;
import lesson21.Observer.SecondCounter;
import lesson21.Observer.WriteFileObserver;

import java.math.BigInteger;
import java.util.Properties;
import java.util.concurrent.*;

/**
 * Test
 */
public class MainLesson21 {
	public static void main(String[] args){
		Callable<BigInteger> factorialTask = new Factorial(5);
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<BigInteger> bigIntegerFuture = executorService.submit(factorialTask);
		try{
			BigInteger factorial = bigIntegerFuture.get(20, TimeUnit.SECONDS);
			System.out.println("Factorial: " + factorial);
		} catch (InterruptedException e){
			bigIntegerFuture.cancel(true);
			System.out.println("Cancelled");
		} catch (ExecutionException | TimeoutException e){
			System.out.println("After timeout, before cancelled.");
			bigIntegerFuture.cancel(true);
			System.out.println("Operation was cancelled.");
		}
		finally {
			executorService.shutdown();
		}

		/**
		 * Fibonacci
		 */
//
//		State state = new State();
//		Fibonacci fibonacci = new Fibonacci(10, state);
//		ExecutorService executorFibonacci = Executors.newFixedThreadPool(2);
//		Future<BigInteger> futureFibonacci = executorFibonacci.submit(fibonacci);
//		try {
//			futureFibonacci.get(500, TimeUnit.MILLISECONDS);
//		} catch (InterruptedException e) {
//			System.out.println("Cancelled");
//			futureFibonacci.cancel(true);
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			System.err.println(e.getMessage());
//		} catch (TimeoutException e) {
//			System.out.println("After timeout before cancel:");
//			futureFibonacci.cancel(true);
//			System.out.println("Time out.");
//		} finally {
//			state = fibonacci.getState();
//			shutdownAndAwaitTermination(executorFibonacci);
//		}

		/**
		 * After Cancel
		 */

//		fibonacci = new Fibonacci(10, state);
//		ExecutorService executorFibonacci1 = Executors.newFixedThreadPool(2);
//		futureFibonacci = executorFibonacci1.submit(fibonacci);
//		try {
//			futureFibonacci.get(50, TimeUnit.MILLISECONDS);
//		} catch (InterruptedException e) {
//			System.out.println("Cancelled");
//			futureFibonacci.cancel(true);
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			System.err.println(e.getMessage());
//		} catch (TimeoutException e) {
//			System.out.println("After timeout before cancel:");
//			futureFibonacci.cancel(true);
//			System.out.println("Time out.");
//		} finally {
//			shutdownAndAwaitTermination(executorFibonacci1);
//		}

		/**
		 * Seconds counter
		 */

//		SecondCounter secondCounter = new SecondCounter();
//		secondCounter.addObserver(new ConsoleObserver());
//		secondCounter.addObserver(new WriteFileObserver());
//		secondCounter.addObserver(new PublisherClient());
//		ExecutorService executorService1 = Executors.newSingleThreadExecutor();
//		Future<Integer> seconds = executorService1.submit(secondCounter);
//		try{
//			seconds.get(100, TimeUnit.SECONDS);
//		} catch (TimeoutException e) {
//			seconds.cancel(true);
//			System.out.println("Stopwatch stopped by timeout.");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			shutdownAndAwaitTermination(executorService1);
//		}

		/**
		 * 04 Task Copy File Treads
		 */

		CopyFile copyFile = new CopyFile();
		ExecutorService executorService2 = Executors.newCachedThreadPool();
		Future<?> copy = executorService2.submit(copyFile);
		try {
			copy.get(2, TimeUnit.SECONDS);
			System.out.println("Start coping file");
		} catch (Exception e) {
			copy.cancel(true);
			System.out.println("Copy file cancelled");
		} finally {
			shutdownAndAwaitTermination(executorService);
		}
	}

	/**
	 * Shutdown
	 */

	static private void shutdownAndAwaitTermination(ExecutorService pool) {
		pool.shutdown();
		// Disable new tasks from being submitted
		try {
			// Wait a while for existing tasks to terminate
			if (!pool.awaitTermination(5, TimeUnit.SECONDS)) {
				pool.shutdownNow(); // Cancel currently executing tasks
				// Wait a while for tasks to respond to being cancelled
				if (!pool.awaitTermination(3, TimeUnit.SECONDS))
					System.err.println("Pool did not terminate");
			}
		} catch (InterruptedException ie) {
			// (Re-)Cancel if current thread also interrupted
			pool.shutdownNow();
			// Preserve interrupt status
			Thread.currentThread().interrupt();
		}
	}



}
