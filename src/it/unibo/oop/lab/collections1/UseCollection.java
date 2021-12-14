package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
//import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

	private UseCollection() {
	}

	/**
	 * @param s
	 *            unused
	 */
	public static void main(final String... s) {
		/*
		 * 1 - Creates a new ArrayList<Integer>, and populate it with the numbers
		 *       from 1000 (included) to 2000 (excluded).
		 */
		List<Integer> list = new ArrayList<Integer>();

		// Sol 1.1
		/*
		final int START = 1000;
		final int END = 2000;
		for(int i = START; i < END; i++) {
			list.add(i);
		}*/
	
		// Sol 1.2
		//UseCollection.rangePopulator(list, 1000, 2000);
	
		// Sol 1.3
		for(int i : new RangeIterator(1000, 2000)) {
			list.add(i);
		}
	
		System.out.println("list: " + list.toString());

		/*
		 * 2) Create a new LinkedList<Integer> and, in a single line of code
		 * without using any looping construct (for, while), populate it with
		 * the same contents of the list of point 1.
		 */
		List<Integer> lList = new LinkedList<Integer>(list);

		/*
		 * 3) Using "set" and "get" and "size" methods, swap the first and last
		 * element of the first list. You can not use any "magic number".
		 * (Suggestion: use a temporary variable)
		 */
		/*int temp = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.set(list.size() - 1, temp);
		*/
		int temp = list.get(list.size() - 1);
		list.set(list.size() - 1, list.get(0));
		list.set(0, temp);

		/*
		 * 4) Using a single for-each, print the contents of the arraylist.
		 */
		//System.out.println("list: " + list.toString());
		System.out.print("[");
		for(int elem : list) {
			System.out.print(elem + ", ");
		}
		System.out.println("]");

		list.clear();
		lList.clear();

		/*
		 * 5) Measure the performance of inserting new elements in the head of
		 * the collection: measure the time required to add 100.000 elements as
		 * first element of the collection for both ArrayList and LinkedList,
		 * using the previous lists. In order to measure times, use as example
		 * TestPerformance.java.
		 */
		UseCollection.performanceInserter(list);
		UseCollection.performanceInserter(lList);

		/*
		 * 6) Measure the performance of reading 1000 times an element whose
		 * position is in the middle of the collection for both ArrayList and
		 * LinkedList, using the collections of point 5. In order to measure
		 * times, use as example TestPerformance.java.
		 */
		UseCollection.performanceReader(list);
		UseCollection.performanceReader(lList);

		/*
		 * 7) Build a new Map that associates to each continent's name its
		 * population:
		 * 
		 * Africa -> 1,110,635,000
		 * 
		 * Americas -> 972,005,000
		 * 
		 * Antarctica -> 0
		 * 
		 * Asia -> 4,298,723,000
		 * 
		 * Europe -> 742,452,000
		 * 
		 * Oceania -> 38,304,000
		 */
		Map<String, Long> world = new HashMap<>();
		world.put("Africa", 1_110_635_000L);
		world.put("Americas", 972_005_000L);
		world.put("Antarctica", 0L);
		world.put("Asia", 4_298_723_000L);
		world.put("Europe", 742_452_000L);
		world.put("Oceania", 38_304_000L);

		/*
		 * 8) Compute the population of the world
		 */
		long population = 0L;
		/*
		// Sol 8.1
		for(Long continentPopulation : world.values()) {
			population += continentPopulation;
		}
		*/
		// Sol 8.2
		for(Map.Entry<String, Long> entry : world.entrySet()) {
			population += entry.getValue();
		}
		System.out.println("World's population: " + population);
	}

	/**
	 * Example performance measuring. Use this class as working example of how to
	 * measure the time necessary to perform operations on data structures.
	 */
	private static void performanceInserter(final Collection<Integer> list) {
		final int ELEMS = 100_000;
		final int TO_MS = 1_000_000;

		/*
		 * Prepare a variable for measuring time
		 */
		long time = System.nanoTime();
		/*
		 * Run the benchmark
		 */
		for (int i = 1; i <= ELEMS; i++) {
			list.add(i);
		}
		/*
		 * Compute the time and print result
		 */
		time = System.nanoTime() - time;
		System.out.println("Inserting " + ELEMS
				+ " int elements in a Collection took " + time
				+ "ns (" + time / TO_MS + "ms)");
		//System.out.println(list);
	}

	/**
	 * Example performance measuring. Use this class as working example of how to
	 * measure the time necessary to perform operations on data structures.
	 */
	private static void performanceReader(final List<Integer> list) {
		final int TIMES = 1_000;
		final int TO_MS = 1_000_000;
	
		final int medianPosition = list.size() / 2;
	
		/*
		 * Prepare a variable for measuring time
		 */
		long time = System.nanoTime();
		/*
		 * Run the benchmark
		 */
		for (int i = 1; i <= TIMES; i++) {
			list.get(medianPosition);
		}
		/*
		 * Compute the time and print result
		 */
		time = System.nanoTime() - time;
		System.out.println("Reading " + TIMES
				+ " times the median element of the List took " + time
				+ "ns (" + time / TO_MS + "ms)");
		//System.out.println(list);
	}

	/*
	private static void rangePopulator(List<Integer> list, int startingPoint, int endingPoint) {
		for(int i = startingPoint; i < endingPoint; i++) {
			list.add(i);
		}
		return;
	}*/
}
