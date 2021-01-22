package com.jpetstore.tests;

import com.github.javafaker.Faker;
import com.jpetstore.steps.serenity.PetStoreSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

@RunWith(SerenityRunner.class)
public class AccountsPageTest {
	
	@Managed
	WebDriver driver;
	
	@Steps
	PetStoreSteps shopper;
	
	
	@Test
	@Title("Add a new user to store & verify if the new user can login")
	public void addNewUserToStoreAndVerify() throws InterruptedException {
		
		Faker faker = new Faker();
		
		String userName = "test" + faker.number().randomNumber(10, false);
		String password = faker.internet().password();
		String repeatPassword = password;
		String firstName = faker.name().firstName();
		String lastName =  faker.name().lastName();
		String email =  faker.internet().emailAddress();
		String phoneNumber = faker.phoneNumber().cellPhone();
		String addr1 = faker.address().buildingNumber();
		String addr2 = faker.address().streetAddress();
		String city = faker.address().city();
		String state = faker.address().state();
		String zipCode = faker.address().zipCode();
		String country = faker.address().country();
		
		shopper.navigateToLoginPage();
		
		shopper.navigateToRegistrationPage();
		
		shopper.addNewUserInformation(userName, password, repeatPassword);
		
		shopper.addAccountInformation(firstName, lastName, email, phoneNumber, addr1, 
				addr2, city, state, zipCode, country);
		
		shopper.addProfileInformation("english", "DOGS", true, true);
			
		shopper.clickSaveAccountInformation();
		
		shopper.doLogin(userName, password);
		
		String greetingMessage =  shopper.getGreetingMessage();
		
		assertEquals("Welcome " + firstName + "!", greetingMessage);
		
	}

}
