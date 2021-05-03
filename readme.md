## Cars.com UI Test
The UI tests for Cars.com was built using Java, TestNG and Selenium WebDriver. It was built using the Page Object Model design.

## How to run the UI tests
1. Download the ChromeDriver from https://chromedriver.storage.googleapis.com/index.html?path=90.0.4430.24/
2. For Windows:
    1. Unzip to C:\chromedriver\chromedriver_90.0.4430.24.exe.
3. If other OS type, unzip anywhere and replace the value in the DriverFactory.java class on line 16: System.setProperty("webdriver.chrome.driver","CHROME_DRIVER_FILE_PATH_HERE"); with the unzipped file path.
4. Install TestNG plugin for your IDE if your IDE does not have it. 
    - **Eclipse**: Eclipse is only limited to certain versions of TestNG plugin. Please see Eclipse Marketplace page for more details on the supported version and installation instructions. https://marketplace.eclipse.org/content/testng-eclipse
    - **Intellij**: Intellij has TestNG built in. No installation required.
    - ***Visual Studio Code***: Install the Java Test Runner from marketplace: https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-test
5. Select a method or class under the test directory and right click and run as TestNG test.

## Challenges in UI Testing on Cars.com
1. Test browser drivers like ChromeDriver is getting blocked after the search is submitted. The next page returns a 503 error.
2. Most of the UI elements I was interacting with did not have an id tag associated with it. This made is harder to select the right UI element to interact with as certain css selector values would return more than one. I'd prefer custom tags such as data-* that is set just for testing purposes. This will prevent it from being change in the future.
3. Making sure the element is visible on the screen when you have to scroll the page to get to the UI element.
4. Interacting with a UI element before it is fully loaded. If you interact before it is visible, the test fails.
5. The was no clean identifier to get the currently set search criterias. This made it difficult to validate the text and it's positions.
