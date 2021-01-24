package com.jpetstore.cucumber.tests;

import com.jpetstore.cucumber.steps.serenity.PetStoreSteps;
import io.restassured.filter.session.SessionFilter;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

@RunWith(SerenityRunner.class)
public class LoginPageTest {
	
	@Managed
	WebDriver driver;
	
	@Steps
	PetStoreSteps shopper;
	
	private static SessionFilter filter = new SessionFilter();

	@Test
	@Title("Verify if a user can login successfully to the store with valid credentials")
	public void verifyIfLoginIsSuccessful() {

		shopper.navigateToLoginPage();

		shopper.doLogin("test", "test_1234");

		String greetingMessage = shopper.getGreetingMessage();

		assertEquals("Welcome Ivan!", greetingMessage);
	}
	
	@Test
	@Title("Verify if the user can signout successfully")
	public void verifyIfUserCanLogoutSuccesfully() {
		
		shopper.navigateToLoginPage();
		
		shopper.doLogin("test", "test");
		
		shopper.signOut();
		
	}
	
	@Test
	@Title("Verify if message <b><i> 'Invalid username or password. Signon failed'.</i></b> is displayed for "
			+ " invalid credentials")
	public void verifyIfMessageIsDisplayedFOrInValidLogin() {
		
		shopper.navigateToLoginPage();
		
		shopper.doLogin("test", "testjsjdjd");
		
		String message = shopper.getMessageOnInvalidLogin();
		
		assertEquals("Invalid username or password. Signon failed.", message);
	}
}
