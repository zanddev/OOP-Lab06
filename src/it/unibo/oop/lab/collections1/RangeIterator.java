package it.unibo.oop.lab.collections1;

import java.util.Iterator;

public class RangeIterator implements Iterable<Integer> {

	private final int startingPoint;
	private final int endingPoint;

	public RangeIterator(int startingPoint, int endingPoint) {
		this.startingPoint = startingPoint;
		this.endingPoint = endingPoint;
	}

	private class ListIterator implements Iterator<Integer> {
	
		private int actualPoint = startingPoint;
	
		public boolean hasNext() {
			return actualPoint < endingPoint;
		}
	
		public Integer next() {
			
			return (this.actualPoint ++);
		}
	}
	
	public Iterator<Integer> iterator() {
		return new RangeIterator.ListIterator();
	}
}
