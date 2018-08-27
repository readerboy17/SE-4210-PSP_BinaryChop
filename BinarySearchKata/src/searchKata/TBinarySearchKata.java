package searchKata;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TBinarySearchKata {
	int[] first = new int[] {};
	int[] second = new int[] {1};
	int[] third = new int[] {1, 3, 5};
	int[] fourth = new int[] {1, 3, 5, 7};
	
	@DisplayName("LinearBinarySearch Test")
	@Test
	void testBinarySearchLinear() {
		

		assertEquals(-1, chop(3, first));

		assertEquals(-1, chop(3, second));
		assertEquals(0,  chop(1, second));
		
		assertEquals(0,  chop(1, third));
		assertEquals(1,  chop(3, third));
		assertEquals(2,  chop(5, third));
		assertEquals(-1, chop(0, third));
		assertEquals(-1, chop(2, third));
		assertEquals(-1, chop(4, third));
		assertEquals(-1, chop(6, third));
		
		assertEquals(0,  chop(1, fourth));
		assertEquals(1,  chop(3, fourth));
		assertEquals(2,  chop(5, fourth));
		assertEquals(3,  chop(7, fourth));
		assertEquals(-1, chop(0, fourth));
		assertEquals(-1, chop(2, fourth));
		assertEquals(-1, chop(4, fourth));
		assertEquals(-1, chop(6, fourth));
		assertEquals(-1, chop(8, fourth));
		/**/
	}
	
	@DisplayName("RecursiveBinarySearch Test")
	@Test
	void testBinarySearchRecursive() {
		
		assertEquals(-1, chopper(first, 3, 0, first.length));

		assertEquals(-1, chopper(second, 3, 0, second.length));
		assertEquals(0,  chopper(second, 1, 0, second.length));
		
		assertEquals(0,  chopper(third, 1, 0, third.length));
		assertEquals(1,  chopper(third, 3, 0, third.length));
		assertEquals(2,  chopper(third, 5, 0, third.length));
		assertEquals(-1, chopper(third, 0, 0, third.length));
		assertEquals(-1, chopper(third, 2, 0, third.length));
		assertEquals(-1, chopper(third, 4, 0, third.length));
		assertEquals(-1, chopper(third, 6, 0, third.length));
		
		assertEquals(0,  chopper(fourth, 1, 0, fourth.length));
		assertEquals(1,  chopper(fourth, 3, 0, fourth.length));
		assertEquals(2,  chopper(fourth, 5, 0, fourth.length));
		assertEquals(3,  chopper(fourth, 7, 0, fourth.length));
		assertEquals(-1, chopper(fourth, 0, 0, fourth.length));
		assertEquals(-1, chopper(fourth, 2, 0, fourth.length));
		assertEquals(-1, chopper(fourth, 4, 0, fourth.length));
		assertEquals(-1, chopper(fourth, 6, 0, fourth.length));
		assertEquals(-1, chopper(fourth, 8, 0, fourth.length));
		/**/
	}

	@DisplayName("ThreadBinarySearch Test")
	@Test
	void testBinarySearchThread() {

		assertEquals(-1, chop_thread(3, first));


		assertEquals(-1, chop_thread(3, second));
		assertEquals(0,  chop_thread(1, second));
		
		assertEquals(0,  chop_thread(1, third));
		assertEquals(1,  chop_thread(3, third));
		assertEquals(2,  chop_thread(5, third));
		assertEquals(-1, chop_thread(0, third));
		assertEquals(-1, chop_thread(2, third));
		assertEquals(-1, chop_thread(4, third));
		assertEquals(-1, chop_thread(6, third));
		
		assertEquals(0,  chop_thread(1, fourth));
		assertEquals(1,  chop_thread(3, fourth));
		assertEquals(2,  chop_thread(5, fourth));
		assertEquals(3,  chop_thread(7, fourth));
		assertEquals(-1, chop_thread(0, fourth));
		assertEquals(-1, chop_thread(2, fourth));
		assertEquals(-1, chop_thread(4, fourth));
		assertEquals(-1, chop_thread(6, fourth));
		assertEquals(-1, chop_thread(8, fourth));

	}
	private static int chop(int expectedVal, int[] search)
	{
		if (search.length > 0)
		{
			int start = 0, end = search.length - 1;
			while (start <= end)
			{
				int middle = (start + end) / 2;
				
				if (expectedVal < search[middle])
					end = middle - 1;
				else if (expectedVal > search[middle])
					start = middle + 1;
				else
					return middle;
					
			}
		}
		return -1;
		
	}
	private static int chopper(int[] search, int expectedVal, int start, int end)
	{
		
		if (search.length > 0 && start < end)
		{
			int middle = (end+start)/2;

			if(expectedVal < search[middle])
				return chopper(search, expectedVal, start, middle);
			else if (expectedVal > search[middle])
				return chopper(search, expectedVal, middle + 1, end);
			return middle;
		}

		return -1;
	}
	private static int chop_thread(int expectedVal, int[] search)
	{
		if (search.length > 0)
		{
			int start = 0, end = search.length - 1;
			do
			{
				int middle = (start + end) / 2;
				
				if (expectedVal < search[middle])
					end = middle - 1;
				else if (expectedVal > search[middle])
					start = middle + 1;
				else
					return middle;
					
			}while (start <= end);
		}
		return -1;
	}
}
