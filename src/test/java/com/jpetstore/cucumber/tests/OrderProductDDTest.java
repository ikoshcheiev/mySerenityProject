package com.jpetstore.tests;

import com.jpetstore.steps.serenity.PetStoreSteps;
import com.jpetstore.utils.PetCategories;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("order-products/orders.csv")
public class OrderProductDDTest {

	private String userName;
	private String password;
	private String productCategory;
	private String productName;
	private String specificProductName;
	private String cardType;
	private String cardNumber;
	private String expiryDate;
	private String firstName;
	private String lastName;
	private String addr1;
	private String addr2;
	private String city;
	private String state;
	private String zip;
	private String country;

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public void setSpecificProductName(String specificProductName) {
		this.specificProductName = specificProductName;
	}


	public void setCardType(String cardType) {
		this.cardType = cardType;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}


	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public void setState(String state) {
		this.state = state;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	public void setShopper(PetStoreSteps shopper) {
		this.shopper = shopper;
	}


	@Managed
	WebDriver driver;
	
	@Steps
	PetStoreSteps shopper;
	
	
	@Test
	@Title("Order pets & verify purchase")
	public void verifyIfLoginIsSuccessful() {
	
		shopper.navigateToLoginPage();
		
		shopper.doLogin(userName, password);
		
		shopper.navigateToProductCategory(PetCategories.valueOf( productCategory ));
		
		shopper.selectPetByName(PetCategories.valueOf( productCategory ), productName );
		
		shopper.addToCartSpecificProduct(specificProductName);
		
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
											  zip, 
											  country);
		
		shopper.clickOnContinueBtn();
		
		shopper.clickOnConfirmBtn();
		
		shopper.verifyIfOrderSubmitted();	
	}
	
}
