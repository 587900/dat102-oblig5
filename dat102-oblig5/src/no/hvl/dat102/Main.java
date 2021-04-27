package no.hvl.dat102;

import java.util.Arrays;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Running program 3d)");
		program3d();
		System.out.println("Finished program 3d)\n\n");
		
		System.out.println("Running program 3e)");
		program3e();
		System.out.println("Finished program 3e)\n\n");
	}

	public static void program3d() {
		Student a = new Student(10, "Ole");
		Student b = new Student(10, "Ole");
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
	}
	
	private static void program3e() {
		int[] originalNumbers = pseudoRandomNumbers(100000);	//100k element, from 0 - 999999
		Timer timer = new Timer();
		
		timer.start();
		int[] sortedNumbers = new int[originalNumbers.length];
		System.arraycopy(originalNumbers, 0, sortedNumbers, 0, sortedNumbers.length);
		Arrays.sort(sortedNumbers);
		timer.end();
		System.out.println("Create and sort array took: " + timer.getTime());
		
		timer.start();
		HashSet<Integer> hashset = new HashSet<>();
		for (int i : originalNumbers) hashset.add(i);
		timer.end();
		System.out.println("Create and insert hashset: " + timer.getTime());
		
		
		timer.start();
		for (int i : originalNumbers) Arrays.binarySearch(sortedNumbers, i);
		timer.end();
		System.out.println("Searching through sorted array for all elements took: " + timer.getTime());
		
		timer.start();
		for (int i : originalNumbers) hashset.contains(i);
		timer.end();
		System.out.println("Searching through hashset for all elements took: " + timer.getTime());
		
		
		//til testing (HashSet ser ut til å vere best i alle tilfelle)
		int[] searchFor = mathrandomNumbers(10000);			//tilfeldig antall treff i tabell
		//int[] searchFor = pseudoRandomNumbers(10000, 0);	//0 treff i tabell
		//int[] searchFor = pseudoRandomNumbers(10000);		//10k treff i tabell
		
		int antall = 0;
		timer.start();
		for (int i : searchFor) if(Arrays.binarySearch(sortedNumbers, i) >= 0) ++antall;
		timer.end();
		System.out.println("Searching through sorted array, found " + antall + " elements, took: " + timer.getTime());
		
		antall = 0;
		timer.start();
		for (int i : searchFor) if (hashset.contains(i)) ++antall;
		timer.end();
		System.out.println("Searching through hashset, found " + antall + " elements, took: " + timer.getTime());
	}
	
	private static int[] pseudoRandomNumbers(int size) { return pseudoRandomNumbers(size, 376); }
	private static int[] pseudoRandomNumbers(int size, int seed) {
		int[] arr = new int[size];
		for (int i = 0; i < arr.length; ++i) {
			seed += 45713;
			seed %= 1000000;
			arr[i] = seed;
		}
		
		return arr;
	}
	
	//from 0 - 999.999
	private static int[] mathrandomNumbers(int size) {
		int[] arr = new int[size];
		for (int i = 0; i < size; ++i) {
			arr[i] = (int)(Math.random() * 1000000);
		}
		return arr;
	}
	
}
