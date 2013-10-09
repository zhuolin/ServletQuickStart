package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	public static void main(String[] args){
		Result result = JUnitCore.runClasses(productTest.class);
		for(Failure failure: result.getFailures()){
			System.out.println(failure.toString());
		}
		System.out.println("product test is:" + (result.wasSuccessful()?"passed":"failed"));
		
		result = JUnitCore.runClasses(OrderTest.class);
		for(Failure failure: result.getFailures()){
			System.out.println(failure.toString());
		}
		System.out.println("order test is:" + (result.wasSuccessful()?"passed":"failed"));
	}
}
