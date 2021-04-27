package no.hvl.dat102;

public class Student {
	private int snr;
	private String namn;
	
	public Student(int snr, String namn) {
		this.snr = snr;
		this.namn = namn;
	}
	
	@Override
	public int hashCode() {
		return namn.hashCode() + snr * 31;	// Primtall
	}

}
