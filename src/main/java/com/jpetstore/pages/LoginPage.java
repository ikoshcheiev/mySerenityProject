package com.jpetstore.pages;

public class LoginPage extends BasePage {

	private static final String USER_NAME_INPUT = "//*[@id='Catalog']//input[@name='username']";

	private static final String PASSWORD_INPUT = "//*[@id='Catalog']//input[@name='password']";

	private static final String LOGIN_BUTTON = "//*[@id='Catalog']//input[contains(@value,'Login')]";

	private static final String REGISTER_NOW_LINK = "//*[@id='Catalog']//a[contains(text(),'Register Now!')]";

	private static final String INVALID_LOGIN_LABEL = "//*[@id='Content']/ul/li";

	/**
	 * Method used to login to the store
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public DashBoardPage doLogin(String userName, String password) {

		waitForTextToAppear("Please enter your username and password.");

		waitForTextToAppear("Need a user name and password?");

		waitFor(USER_NAME_INPUT).$(USER_NAME_INPUT).type(userName);

		waitFor(PASSWORD_INPUT).$(PASSWORD_INPUT).type(password);

		waitFor(LOGIN_BUTTON).$(LOGIN_BUTTON).click();

		return this.switchToPage(DashBoardPage.class);

	}
	
	/**
	 * Method to navigate to the Regisration Page
	 * @return
	 */
	public AccountsPage navigateToRegistrationPage() {

		waitForTextToAppear("Please enter your username and password.");

		waitForTextToAppear("Need a user name and password?");
		
		waitFor(REGISTER_NOW_LINK).$(REGISTER_NOW_LINK).click();

		return this.switchToPage(AccountsPage.class);

	}
	
	/**
	 * Method to return invalid login message
	 * 
	 * @return
	 */
	public String getMessageOnInvalidLogin() {
		
		return waitFor(INVALID_LOGIN_LABEL).$(INVALID_LOGIN_LABEL).getText();
	}
}
