package com.jpetstore.cucumber.steps.serenity;

import com.jpetstore.pages.*;
import com.jpetstore.utils.PetCategories;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class PetStoreSteps extends ScenarioSteps {

	BasePage basePage;
	LoginPage loginPage;
	AccountsPage accountPage;
	DashBoardPage dashBoardPage;
	ProductsPage productsPage;
	OrdersPage ordersPage;

	/************************************************************************************************
	 * **********************************************************************************************
	 * 
	 * BASE PAGE STEPS
	 * 
	 *************************************************************************************************
	 *************************************************************************************************/
	
	
	@Step("Signing out from the store")
	public DashBoardPage signOut() {

		return basePage.signOut();
	}
	
	@Step("Navigating to Login Page")
	public LoginPage navigateToLoginPage() {

		return basePage.navigateToSignOnPage();
	}

	@Step("Navigating to products page by cliking on : {0} link on header")
	public ProductsPage navigateToProductCategory(PetCategories productCategory) {
		
		return basePage.navigateToProductCategory(productCategory);
	}

	@Step("Navigating to Products Page by clicking on shopping cart")
	public ProductsPage navigateToShoppingCartPage() {

		return basePage.navigateToShoppingCart();
	}

	@Step("Navigating to Help Page")
	public HelpPage navigateToHelpPage() {

		return basePage.navigateToHelpPage();
	}

	@Step("Clicking on Company Logo & navigating to the DashBoard")
	public DashBoardPage navigateToDashBoard() {
		
		return basePage.navigateToDashBoard();
	}

	@Step("Navigating to Accounts Page")
	public AccountsPage navigateToMyAccountsPage() {

		return basePage.navigateToAccountPage();
	}

	@Step("Searching for product: {0}")
	public ProductsPage searchForProduct(String productName) {

		return basePage.searchForProduct(productName);
	}
	
	
	/************************************************************************************************
	 * **********************************************************************************************
	 * 
	 * LOGIN PAGE STEPS
	 * 
	 *************************************************************************************************
	 *************************************************************************************************/
	
	@Step("Getting Invalid Login Message")
	public String getMessageOnInvalidLogin() {
		
		return loginPage.getMessageOnInvalidLogin();
	}
	
	@Step("Navigating to user registration page")
	public AccountsPage navigateToRegistrationPage() {
		
		return loginPage.navigateToRegistrationPage();
	}
	
	@Step("Logging into the application with userName: {0} & passsword: {1}")
	public DashBoardPage doLogin(String userName, String password) {
		
		basePage.clickSignOnLink();
		return loginPage.doLogin(userName, password);
	}
	
	
	/************************************************************************************************
	 * **********************************************************************************************
	 * 
	 * ACCOUNT PAGE STEPS
	 * 
	 *************************************************************************************************
	 *************************************************************************************************/
	
	
	@Step("Adding new user information with userName: {0} ,password: {1} , repeatPassword: {2}")
	public AccountsPage addNewUserInformation(String userName , String password 
			, String repeatPassword) {
		
		return accountPage.addNewUserInformation(userName, password, repeatPassword);
	}
	
	
	@Step("Adding account information- firstname:{0} , lastName:{1}," +
		 " email:{2}, phone:{3}, addr1:{4}, addr2: {5}, city:{6}, "  +
		 "state:{7}, zip:{8}, country:{9} ")
	public AccountsPage addAccountInformation(String firstName , 
											  String lastName , 
											  String email ,
											  String phone ,
											  String addr1 , 
											  String addr2 ,
											  String city ,
											  String state , 
											  String zip ,
											  String country) {
		
		
		return accountPage.addAccountInformation(firstName,
												 lastName, 
												 email, 
												 phone, 
												 addr1, 
												 addr2, 
												 city, 
												 state, 
												 zip, 
												 country);
	}
	
	@Step("Adding profile information - language:{0} ,category: {1} ,myList: {2} ,myBanner:{3}")
	public AccountsPage addProfileInformation(String language, 
											  String category , 
											  boolean myList , 
											  boolean myBanner) {
		
		return accountPage.addProfileInformation(language, 
												 category, 
												 myList, 
												 myBanner);	
	}
	
	@Step("Saving account information")
	public DashBoardPage clickSaveAccountInformation() {
		
		return accountPage.clickSaveAccountInformation();
		
	}
	
	
	/************************************************************************************************
	 * **********************************************************************************************
	 * 
	 * DASHBOARD PAGE STEPS
	 * 
	 *************************************************************************************************
	 *************************************************************************************************/
	
	@Step("Getting the greeting message")
	public String getGreetingMessage() {
		
		return dashBoardPage.getGreetingMessage();
	}
	
	@Step("Selecting {0} petcatgory form center display")
	public ProductsPage selectProductFromCenterDisplay(PetCategories petCategories) {
		
		return dashBoardPage.selectProductFromCenterDisplay(petCategories);
	}
	
	@Step("Selecting {0} petcatgory form side bar")
	public ProductsPage selectProductFromSideBar(PetCategories petCategories) {
		
		return dashBoardPage.selectProductFromSideBarDisplay(petCategories);
	}
	
	
	/************************************************************************************************
	 * **********************************************************************************************
	 * 
	 * PRODUCTS PAGE STEPS
	 * 
	 *************************************************************************************************
	 *************************************************************************************************/
	
	@Step("Selecting a pet with petcategory:{0} , and petName:{1}")
	public ProductsPage selectPetByName( PetCategories petcategory , String petName) {
		
		return productsPage.selectPetByName(petcategory, petName);
	}
	
	@Step("Adding {0} to the shopping cart")
	public ProductsPage addToCartSpecificProduct(String specificProductName) {
		
		return productsPage.addToCartSpecificProduct(specificProductName);
	}
	
	
	@Step("Selecting pet {0} by viewing details and adding it to cart")
	public ProductsPage addToCartByViewingItemDetails( String specificProduct ,
			String...details ) {
		
		return productsPage.addToCartByViewingItemDetails(specificProduct, details);
	}
	
	@Step("Selecting {0} from the search results")
	public ProductsPage selectProductFromSearchTable( String productName) {
		
		return productsPage.selectProductFromSearchTable(productName);
	}
	
	@Step("Interacting with the shopping cart")
	public ProductsPage shoppingCart( String productDescription ,  int quantity) {
	
		return productsPage.shoppingCart(productDescription, quantity);
	}
	
	@Step("Remove item {0} from shopping cart")
	public boolean removeItemFromCart(String productName ) {
		
		return productsPage.removeItemFromCart(productName);
	}
	
	@Step("Click on Proceed to checkout")
	public OrdersPage clickOnProceedToCheckout() {
		
		return productsPage.clickOnProceedToCheckout();
	}
	
	
	/************************************************************************************************
	 * **********************************************************************************************
	 * 	
	 * ORDERS PAGE STEPS
	 * 
	 *************************************************************************************************
	 *************************************************************************************************/
	@Step("Entering purchase information & placing order")
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
		
		
		return ordersPage.enterPaymentAndBillingDetails(cardType, 
												   		  cardNumber, 
												   		  expiryDate, 
												   		  firstname, 
												   		  lastname, 
												   		  addr1, 
												   		  addr2, 
												   		  city, 
												   		  state, 
												   		  zip, 
												   		  country);
				
	}

	
	
	@Step("Clicking on Ship to different checkbox" )
	public OrdersPage clickShipToDifferentAddress() {
		
		return ordersPage.clickShipToDifferentAddress();
	}
	
	@Step("Entering Shipping information")
	public OrdersPage enterShippingInfo(String firstName , String lastName , String addr1
			,String addr2,String city ,String state , String zip, String country){
		
		return ordersPage.enterShippingInfo(firstName, lastName, addr1, addr2, city, 
				state, zip, country);
	}
	
	@Step("Clicking on Continue Button")
	public OrdersPage clickOnContinueBtn(){
		
		return ordersPage.clickOnContinueBtn();
	}
	
	@Step("Clicking on Confirm button")
	public OrdersPage clickOnConfirmBtn(){
		
		return ordersPage.clickOnConfirmBtn();
	}
	
	@Step("Verify iof order has been placed")
	public void verifyIfOrderSubmitted(){
		
		ordersPage.verifyIfOrderSubmitted();
	}
}
