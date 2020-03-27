package sanjeev.practice.hibernate.ch01.components;

import java.util.Arrays;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import sanjeev.practice.hibernate.ch01.interfaces.SortingAlgo;

@Component
@Primary
public class QuickSort implements SortingAlgo {

	@Override
	public int[] sort(int[] numbers) {
		// TODO Auto-generated method stub
		System.out.println("Qucik Sort Algo in action");
		Arrays.sort(numbers);
		return numbers;
	}

}
