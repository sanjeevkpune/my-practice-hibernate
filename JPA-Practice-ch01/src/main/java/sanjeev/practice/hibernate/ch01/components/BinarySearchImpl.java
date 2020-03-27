package sanjeev.practice.hibernate.ch01.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sanjeev.practice.hibernate.ch01.interfaces.SortingAlgo;

@Component
public class BinarySearchImpl {
	@Autowired
	private SortingAlgo algo;
	
	public int binarySearch(int[] numbers, int numberToSearch) {
		algo.sort(numbers);
		// some search logic
		return 0;
	}

}
