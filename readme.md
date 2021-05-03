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
