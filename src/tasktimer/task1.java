package tasktimer;

import static java.lang.System.out;

public class task1 implements Runnable{

	public void run() {
		long starttime = System.nanoTime();
		// perform the task
		int count = 0;
		long totalsize = 0;
		while (TaskTimer.in.hasNext()) {
			String word = TaskTimer.in.next();
			totalsize += word.length();
			count++;
		}
		double averageLength = ((double) totalsize) / (count > 0 ? count : 1);
		long stoptime = System.nanoTime();
		out.printf("Average length of %,d words is %.2f\n", count, averageLength);
	}
	public String toString(){
		return "Starting task: read words using Scanner and a while loop";
	}
}
