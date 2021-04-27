package no.hvl.dat102;

public class Timer {

	private long start;
	private long end;
	
	public void start() {
		start = System.currentTimeMillis();
	}
	
	public void end() {
		end = System.currentTimeMillis();
	}
	
	public String getTime() {
		long diff = end - start;
		return diff + "ms";
	}
	
}
