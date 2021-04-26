package no.hvl.dat102;

public class Hashcode {
	public static void main(String[] args) {
		String a = "ab";
		String b = "123";
	
		char k = 'a';
		char k1= 'b';
		
		System.out.println("Verdien til a: " + (int) k);
		System.out.println("Verdien til b: " + (int) k1);
		
		System.out.println("Hashcode til 'ab': " + a.hashCode());
		System.out.println("Hashcode til '123': " + b.hashCode());
		
	}

}
