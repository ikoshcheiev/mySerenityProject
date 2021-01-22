package com.jpetstore.tests;

import com.jpetstore.steps.serenity.PetStoreSteps;
import com.jpetstore.utils.PetCategories;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class Sample {

	@Managed
	WebDriver driver;
	
	@Steps
	PetStoreSteps shopper;
	
	
	//@Ignore
	@Test
	@Title("Testing methods")
	public void navigateToSignOnPage() throws InterruptedException {
		
		shopper.navigateToLoginPage();
		shopper.doLogin("test", "test_1234");
		shopper.navigateToProductCategory(PetCategories.DOGS);
		shopper.selectPetByName(PetCategories.DOGS, "Dalmation");
		shopper.addToCartSpecificProduct("Spotted Adult Female Dalmation");
		shopper.clickOnProceedToCheckout();
		
	}
}
