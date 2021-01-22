package com.jpetstore.pages;

import com.jpetstore.utils.PetCategories;

public class DashBoardPage extends BasePage {

	private static final String GREETING_MSG = "//*[@id='WelcomeContent']";

	// Product Quick Links for sidebar display
	private static final String SIDEBAR_FISH_LINK = "//*[@id='SidebarContent']/a[contains(@href , 'FISH')]";

	private static final String SIDEBAR_DOGS_LINK = "//*[@id='SidebarContent']/a[contains(@href , 'DOGS')]";

	private static final String SIDEBAR_REPTILES_LINK = "//*[@id='SidebarContent']/a[contains(@href , 'REPTILES')]";

	private static final String SIDEBAR_CATS_LINK = "//*[@id='SidebarContent']/a[contains(@href , 'CATS')]";

	private static final String SIDEBAR_BIRDS_LINK = "//*[@id='SidebarContent']/a[contains(@href , 'BIRDS')]";

	// Product Quick Links for Center display
	private static final String CENTER_IMAGE = "div[id='MainImageContent'] area[href$='BIRDS']:nth-child(1)";

	private static final String FISH_IMAGE = "div[id='MainImageContent'] area[href$='FISH']";

	private static final String DOGS_IMAGE = "div[id='MainImageContent'] area[href$='DOGS']";

	private static final String REPTILES_IMAGE = "div[id='MainImageContent'] area[href$='REPTILES']";

	private static final String CATS_IMAGE = "div[id='MainImageContent'] area[href$='CATS']";

	private static final String BIRDS_IMAGE = "div[id='MainImageContent'] area[href$='CATS']+area[href$='BIRDS']";

	/**
	 * Get the greeting message
	 * 
	 * @return
	 */
	public String getGreetingMessage() {

		return waitFor(GREETING_MSG).$(GREETING_MSG).getText();
	}

	/**
	 * Select a petcategory from the sidebar
	 * 
	 * @param petCategories
	 * @return
	 */
	public ProductsPage selectProductFromSideBarDisplay(PetCategories petCategories) {

		switch (petCategories) {

		case FISH:
			$(SIDEBAR_FISH_LINK).click();

			return this.switchToPage(ProductsPage.class);

		case DOGS:
			$(SIDEBAR_DOGS_LINK).click();

			return this.switchToPage(ProductsPage.class);

		case CATS:
			$(SIDEBAR_CATS_LINK).click();

			return this.switchToPage(ProductsPage.class);

		case BIRDS:
			$(SIDEBAR_BIRDS_LINK).click();

			return this.switchToPage(ProductsPage.class);

		case REPTILES:
			$(SIDEBAR_REPTILES_LINK).click();

			return this.switchToPage(ProductsPage.class);

		default:
			break;
		}
		return null;

	}
	
	/**
	 * Select product category from Images displayed on dashboard
	 * 
	 * @param petCategories
	 * @return
	 */
	public ProductsPage selectProductFromCenterDisplay(PetCategories petCategories) {

		switch (petCategories) {

		case FISH:
			
			$(FISH_IMAGE).click();

			return this.switchToPage(ProductsPage.class);

		case DOGS:
			
			withAction().moveToElement( $(DOGS_IMAGE) ).click().build().perform();

			return this.switchToPage(ProductsPage.class);

		case CATS:
			
			$(CATS_IMAGE).click();

			return this.switchToPage(ProductsPage.class);

		case BIRDS:
			
			$(BIRDS_IMAGE).click();

			return this.switchToPage(ProductsPage.class);

		case REPTILES:
			
			$(REPTILES_IMAGE).click();

			return this.switchToPage(ProductsPage.class);

		default:
			break;
		}
		return null;

	}
}
