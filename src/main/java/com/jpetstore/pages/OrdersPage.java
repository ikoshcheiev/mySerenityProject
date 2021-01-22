package com.jpetstore.pages;

public class OrdersPage extends BasePage {
	

	private static final String FIRST_NAME_INPUT = "//*[@id='Catalog']//input[@name='order.billToFirstName']";
	
	private static final String LAST_NAME_INPUT = "//*[@id='Catalog']//input[@name='order.billToLastName']";
	
	private static final String ADDR1_INPUT = "//*[@id='Catalog']//input[@name='order.billAddress1']";
		
	private static final String ADDR2_INPUT = "//*[@id='Catalog']//input[@name='order.billAddress2']";

	private static final String CITY_INPUT = "//*[@id='Catalog']//input[@name='order.billCity']";
		
	private static final String STATE_INPUT = "//*[@id='Catalog']//input[@name='order.billState']";
	
	private static final String ZIP_INPUT = "//*[@id='Catalog']//input[@name='order.billZip']";

	private static final String COUNTRY_INPUT = "//*[@id='Catalog']//input[@name='order.billCountry']";
		
	private static final String CONTINUE_BUTTON = "//*[@id='Catalog']//input[@value='Continue']";
	
	private static final String CARDTYPE_INPUT = "//*[@id='Catalog']//select[@name='order.cardType']";
	
	private static final String CARD_NUMBER_INPUT = "//*[@id='Catalog']//input[@name='order.creditCard']";
		
	private static final String EXPIRY_DATE_INPUT = "//*[@id='Catalog']//input[@name='order.expiryDate']";
	
	private static final String SHIP_TO_DIFF_ADDRESSS = "//input[@name='shippingAddressRequired']";
	
	
	//Shipping Page locators
	
	private static final String SHIP_FIRST_NAME_INPUT = "//*[@id='Catalog']//input[@name='order.shipToFirstName']";
	
	private static final String SHIP_LAST_NAME_INPUT = "//*[@id='Catalog']//input[@name='order.shipToLastName']";
	
	private static final String SHIP_ADDR1_INPUT = "//*[@id='Catalog']//input[@name='order.shipAddress1']";
	
	private static final String SHIP_ADDR2_INPUT = "//*[@id='Catalog']//input[@name='order.shipAddress2']";
	
	private static final String SHIP_CITY_INPUT = "//*[@id='Catalog']//input[@name='order.shipCity']";
	
	private static final String SHIP_STATE_INPUT = "//*[@id='Catalog']//input[@name='order.shipState']";
	
	private static final String SHIP_ZIP_INPUT = "//*[@id='Catalog']//input[@name='order.shipZip']";
	
	private static final String SHIP_COUNTRY_INPUT = "//*[@id='Catalog']//input[@name='order.shipCountry']";
	

	private static final String CONFIRM_BUTTON = "div[id='Catalog'] a[href*='confirmed']";
	
	private static final String ORDER_CONFIRMATION_LABEL = "#Content > ul > li";
	
	
	/**
	 * Enter information & place order
	 * 
	 * 
	 * @param cardType :Visa, MasterCard, American Express
	 * @param cardNumber :16digit faake number
	 * @param expiryDate :MM/YYYY format	 
	 * @param firstname
	 * @param lastname
	 * @param addr1
	 * @param addr2
	 * @param city
	 * @param state
	 * @param zip
	 * @param country
	 * @return
	 */
	public OrdersPage enterPaymentAndBillingDetails(String cardType,
												String cardNumber,
												String expiryDate,
												String firstname,
												String lastname,
												String addr1,
												String addr2,
												String city,
												String state,
												String zip,
												String country){
		
		waitForAnyTextToAppear("Payment Details" , "Billing Address");
		
		$(CARDTYPE_INPUT).selectByVisibleText(cardType);
		$(CARD_NUMBER_INPUT).type(cardNumber);
		$(EXPIRY_DATE_INPUT).type(expiryDate);
		$(FIRST_NAME_INPUT).type(firstname);
		$(LAST_NAME_INPUT).type(lastname);
		$(ADDR1_INPUT).type(addr1);
		$(ADDR2_INPUT).type(addr2);
		$(CITY_INPUT).type(city);
		$(STATE_INPUT).type(state);
		$(ZIP_INPUT).type(zip);
		$(COUNTRY_INPUT).type(country);
		
		return this;

	}
	
	
	/**
	 * Use this to select the ship to different address
	 * checkBox
	 * 
	 * @return
	 */
	public OrdersPage clickShipToDifferentAddress(){
		
		waitForTextToAppear("Ship to different address...");
		
		$(SHIP_TO_DIFF_ADDRESSS).click();
		
		return this;
	}
	
	/**
	 * Click on the Continue button
	 * @return
	 */
	public OrdersPage clickOnContinueBtn(){
		
		waitFor(CONTINUE_BUTTON).$(CONTINUE_BUTTON).click();
		return this;
	}
	
	
	/**
	 * Method used to enter shipping information
	 * 
	 * @param firstName
	 * @param lastName
	 * @param addr1
	 * @param addr2
	 * @param city
	 * @param state
	 * @param zip
	 * @param Country
	 * @return
	 */
	public OrdersPage enterShippingInfo(String firstName , String lastName , String addr1
			,String addr2,String city ,String state , String zip, String country){
		
		waitForTextToAppear("Shipping Address");
		
		$(SHIP_FIRST_NAME_INPUT).type(firstName);
		$(SHIP_LAST_NAME_INPUT).type(lastName);
		$(SHIP_ADDR1_INPUT).type(addr1);
		$(SHIP_ADDR2_INPUT).type(addr2);
		$(SHIP_CITY_INPUT).type(city);
		$(SHIP_STATE_INPUT).type(state);
		$(SHIP_ZIP_INPUT).type(zip);
		$(SHIP_COUNTRY_INPUT).type(country);
		
		return this;
	}
	
	/**
	 * Click on the Confirm button
	 * @return
	 */
	public OrdersPage clickOnConfirmBtn(){
		
		waitForTextToAppear("Please confirm the information below and then press continue...");
		
		waitFor(CONFIRM_BUTTON).$(CONFIRM_BUTTON).click();
		return this;
	}
	
	/**
	 * Method to  check if order has been placed
	 */
	public void verifyIfOrderSubmitted(){
		waitFor(ORDER_CONFIRMATION_LABEL).shouldContainText("Thank you, your order has been submitted.");
	}
	
	

}
