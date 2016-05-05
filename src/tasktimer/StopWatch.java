package tasktimer;

public class StopWatch {
	private long starttime;
	private long stoptime;
	public void start(){
		starttime = System.nanoTime();
	}
	public void stop(){
		stoptime = System.nanoTime();
	}
	public double getElapsed(){
		return (stoptime - starttime) * 1.0E-9;
	}
}
