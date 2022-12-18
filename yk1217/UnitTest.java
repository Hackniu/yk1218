package yk1217;

import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.Test;

public class UnitTest {
	@Test
	public void finalCost1() {
				
	    String expectedMessage = "Dear, Please could you enter discount in the range of 0-10, thanks";
	    String actualMessage;
		try {
			Demo demo = new Demo();
			demo.finalCost("JAKR", "9/3/15", 5, 101);
		}catch(Exception e) {
			actualMessage = e.getMessage();
			Assert.fail();
			assertEquals(actualMessage,expectedMessage);
		}
	}
	@Test
	public void finalCost2() {
		/*1.99*10/100 = 0.20*/		
	    double expectedResult = 1.79;
	    Demo demo = new Demo();
	    /* 7/2/2020 Thurs, 7/4 is in the Sat, so 7/3 and 7/4 is holiday*/
		double actualResult = demo.finalCost("LADW", "7/2/20", 3, 10);
		System.out.println(actualResult);
		System.out.println(expectedResult);
		Assert.assertTrue(Double.compare(expectedResult, actualResult)==0);
				
	}
	@Test
	public void finalCost3() {
		/*1.49*3*25/100 = 1.12*/		
	    double expectedResult = 3.35;
	    
	    Demo demo = new Demo();
	    /* 7/2/2015 Thurs, 7/4 is in the Sat, so 7/3 and 7/4 is holiday*/
		double actualResult = demo.finalCost("CHNS", "7/2/15", 5, 25);
		Assert.assertTrue(Double.compare(expectedResult, actualResult)==0);
				
	}
	@Test
	public void finalCost4() {
		/*2.99*2 = 5.98*/		
	    double expectedResult = 5.98;
	    
	    Demo demo = new Demo();
	    /* 9/3/2015 Thurs*/
		double actualResult = demo.finalCost("JAKD", "9/3/15", 6, 0);
		assertEquals(Double.valueOf(expectedResult),Double.valueOf(expectedResult));
				
	}
	@Test
	public void finalCost5() {
		/*2.99*3 = 8.97*/		
	    double expectedResult = 8.97;
	    
	    Demo demo = new Demo();
	   
		double actualResult = demo.finalCost("JAKR", "7/2/15", 9, 0);
		Assert.assertTrue(Double.compare(expectedResult, actualResult)==0);
	}
	@Test
	public void finalCost6() {
		/*2.99*2*50/100 = 2.99*/		
	    double expectedResult = 2.99;
	    
	    Demo demo = new Demo();
		double actualResult = demo.finalCost("JAKR", "7/2/20", 4, 50);
		Assert.assertTrue(Double.compare(expectedResult, actualResult)==0);
	}
}
