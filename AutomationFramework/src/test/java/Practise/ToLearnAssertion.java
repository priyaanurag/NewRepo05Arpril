package Practise;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtility.BaseClass;

public class ToLearnAssertion  {
	
	
	@Test
	public void LearnAssertion()
	{
		
		System.out.println("==========step 1==========");
		System.out.println("==========step 2==========");
		
		
		//Assert.assertEquals(false, false);// both is true all output is print
		//Assert.assertEquals(false, true);// if any one true then output is false ,then rest steps will fail.
		
		SoftAssert sa =new SoftAssert();
		sa.assertEquals(false, true);// if condition is not true then also all tc will pass 
		
		
		System.out.println("==========step 3==========");
		System.out.println("==========step 4==========");
	}
	
	
	
	

}
