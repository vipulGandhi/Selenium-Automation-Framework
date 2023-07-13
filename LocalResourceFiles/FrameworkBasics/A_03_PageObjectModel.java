// Page Object Model
	// A design pattern
	// Create a seperate java class for each web page
		// The class file contains
			// Private By locators of the web elements present on the web page [Encapsulation]
			// Public page action methods for the actions to be performed on those web elements
		// Test scripts then call these methods to perform different actions on the webpage
		// For nested page:
			// http://makeseleniumeasy.com/2018/09/23/object-repository-in-selenium-using-page-factory-with-inner-class-handling-a-page-which-has-many-webelements/

	// Page Library - Collection of all page classes
	// Every object needs to be initialized
	// POM has a default cache storage
	// POM is not optimal as it does not provide lazy initialization
		// In plain page object model, you need to initialize every page object individually

	// Best Practices
		// Do not write assertions in page classes
		// Webdriver API's should not be written in test classes

// Page Factory
	// Page Factory is a class which can be used in implementing Page Object Model
	// @FindBy annotation
		// @FindBy(id="elementId") WebElement element;
	// initElements()
		// initElements is a static method in Page Factory class
		// Initialize all the web elements located by @FindBy annotation
		// Webelements are not needed to be initialized one by one as in POM
		// All page objects are initialized (Lazily) by using initElements() method
			// All page objects(Web elements) of Page Object class are initialized
			// Webdriver has not located and store any of the webelement
				// Webdriver will locate element only when page object(Web element) is being used
	// @CacheLookUp
		// It keeps the WebElement in the cache memory after the first time it’s run
		// Used to instruct the InitElements() method to cache the element once its located
			// so that it will not be searched over and over again.
		// Example
			/*
				@FindBy(how = How.NAME, using = "q")
				@CacheLookup
				private WebElement searchBox;
			 */
	// @FindBys
		// AND condition is used to identify the web elements based on the various criteria
	// @FindAll
		// AND condition is used to identify the web elements based on the various criteria
	// It doesn’t have a default cache storage
	/* public classConstructor(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	 */
