// POM vs. PageFactory
	// Page Object Model (POM)
		// Page Object Model is a test design pattern
		// Define locators using ‘By’
		// POM is not optimal as it does not provide lazy initialization
			// In plain page object model, you need to initialize every page object individually
	// Page Factory
		// PageFactory is a class which cn be used in implementing PageObject Model
		// Define locators using ‘FindBy’
		// All page objects are initialized (Lazily) by using initElements() method

// @CacheLookup
	// @CacheLookup is a PageFactory annotation
	// CacheLookup attribute is be used to instruct the InitElements() method to cache the element once its located
		// so that it will not be searched over and over again.
	// Example
		/*
			@FindBy(how = How.NAME, using = "q")
			@CacheLookup
			private WebElement searchBox;
		*/

