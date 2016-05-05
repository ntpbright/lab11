package tasktimer;

import static java.lang.System.out;
import java.util.Scanner;
import java.io.*;
import java.util.function.IntConsumer;
import java.util.function.Consumer;
import java.util.concurrent.atomic.*; // hack, using AtomicInteger as accumulator

/**
 * Time how long it takes to perform some tasks using different programming
 * constructs.
 * 
 * TODO Improve this code by restructuring it to eliminate duplicate code.
 */
public class TaskTimer {
	private static String DICTIONARY = "wordlist.txt";
	// initialize: open the words file as InputStream
	static Scanner in = new Scanner(Dictionary.getWordsAsSteam());
	//Limit number of words read. Otherwise, the next task could be very
	// sloooow.
	static final int MAXCOUNT = 50_000;
	/**
	 * Define a customer Consumer class that computes <b>both</b> the average
	 * and count of values. An IntConsumer is a special Consumer interface the
	 * has an 'int' parameter in accept().
	 */
	static class IntCounter implements IntConsumer {
		// count the values
		public int count = 0;
		// total of the values
		private long total = 0;

		/**
		 * accept consumes an int. In this method, count the value and add it to
		 * total.
		 */
		public void accept(int value) {
			count++;
			total += value;
		}

		/** Get the average of all the values consumed. */
		public double average() {
			return (count > 0) ? ((double) total) / count : 0.0;
		}

		public int getCount() {
			return count;
		}
	}


	/** Run all the tasks. */
	public static void main(String[] args) {
		execAndPrint(new task1());
		execAndPrint(new task2());
		execAndPrint(new task3());
		execAndPrint(new task4());
		execAndPrint(new task5());
		execAndPrint(new task6());
	}
	public static void execAndPrint(Runnable task){
		System.out.println(task.toString());
		StopWatch watch = new StopWatch();
		watch.start();
		task.run();
		watch.stop();
		out.printf("Elapsed time is %f sec\n",watch.getElapsed());
	}

}
