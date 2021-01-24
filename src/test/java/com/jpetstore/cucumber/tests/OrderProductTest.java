package com.jpetstore.cucumber.tests;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import com.jpetstore.cucumber.steps.serenity.PetStoreSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class OrderProductTest {
	
	@Managed
	WebDriver driver;
	
	@Steps
	PetStoreSteps shopper;
	
	Faker faker = new Faker();
	
	
	@Test
	@Title("Order a pet bulldog from the petstore")
	public void verifyIfLoginIsSuccessful() {
		
		String cardType =  "Visa";
		String cardNumber = faker.finance().creditCard(CreditCardType.VISA);
		String expiryDate = "12/2026";
		
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String addr1 = faker.address().buildingNumber();
		String addr2 = faker.address().streetAddress();
		String city = faker.address().city();
		String state = faker.address().state();
		String zipCode = faker.address().zipCode();
		String country = faker.address().country();
		
		shopper.navigateToLoginPage();
		
		shopper.doLogin("test", "test");
		
		shopper.searchForProduct("Bulldog");
		
		shopper.selectProductFromSearchTable("Bulldog");
		
		shopper.addToCartByViewingItemDetails("Female Puppy Bulldog", "Friendly dog from England",
				"Female Puppy Bulldog" , "Bulldog");
		
		shopper.clickOnProceedToCheckout();
		
		shopper.enterPaymentAndBillingDetails(cardType, 
											  cardNumber, 
											  expiryDate, 
											  firstName, 
											  lastName, 
											  addr1, 
											  addr2, 
											  city, 
											  state, 
											  zipCode, 
											  country);
		
		shopper.clickShipToDifferentAddress();
		
		String addr3 = faker.address().buildingNumber();
		String addr4 = faker.address().streetAddress();
		
		shopper.clickOnContinueBtn();
		
		shopper.enterShippingInfo(firstName, lastName, addr3, addr4, city, state, zipCode, country);
		
		shopper.clickOnContinueBtn();
		
		shopper.clickOnConfirmBtn();
		
		shopper.verifyIfOrderSubmitted();
	}
	
}
