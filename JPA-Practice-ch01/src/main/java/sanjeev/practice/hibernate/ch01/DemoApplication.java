package sanjeev.practice.hibernate.ch01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import sanjeev.practice.hibernate.ch01.components.BinarySearchImpl;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		BinarySearchImpl searchImpl = ctx.getBean(BinarySearchImpl.class);
		
		searchImpl.binarySearch(new int[] {34,23,56}, 45);
	}

}
