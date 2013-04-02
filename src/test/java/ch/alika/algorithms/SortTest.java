package ch.alika.algorithms;


import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

public class SortTest {
	private Comparator<Integer> direction = new AscendingComparator();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testInsertionSort() {
		Integer a[] = {4,8,7,8,9, 20, 1, -1, -50, 90, 100};
		Integer expected[] = expected(a, direction);
		Sort.insertionSort(a, direction);
		assertArrayEquals(expected, a);
	}

	@Test
	public void testMergeSort() {
		Integer a[] = {8,8,7,8,9, 20, 1, -1, -50};
		Integer expected[] = expected(a, direction);
		Sort.mergeSort(a, direction);
		assertArrayEquals(expected, a);
	}

	private static Integer[] expected(Integer[] a, Comparator<Integer> direction) {
		Integer expected[] = Arrays.copyOf(a, a.length);
		Arrays.sort(expected,direction);
		return expected;
	}
	
	private static final class AscendingComparator implements
	Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			if (o1 == o2)
				return 0;
			
			if (o2 > o1)
				return 1;
			
			return -1;
		}
	}
}
