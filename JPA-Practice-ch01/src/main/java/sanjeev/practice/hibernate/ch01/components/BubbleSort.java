package sanjeev.practice.hibernate.ch01.components;

import org.springframework.stereotype.Component;

import sanjeev.practice.hibernate.ch01.interfaces.SortingAlgo;

@Component
public class BubbleSort implements SortingAlgo {

	@Override
	public int[] sort(int[] numbers) {
		// TODO Auto-generated method stub
		System.out.println("BubbleSort Algo in action!!!");
		// some sorting algo
		return numbers;
	}

}
