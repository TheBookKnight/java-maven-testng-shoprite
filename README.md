# Shoprite Survey Test Framework

- Using Java Maven TestNG Selenium

## Step 0: Setup
1. Add Selenium and TestNG dependencies to the [*pom.xml*](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)
2. Add the TestNG Eclipse Plugin
3. Run a test to see if it's working. I checked if it navigates to [Shoprite's Survey page](https://www.myshopriteexperience.com/)

## Step 1: Soft Asserts, Select, and Explicit Waits
0. I created a static Java file for my user inputs for Shoprite. But, kept it hidden from GitHUb for my data privacy.
1. Implement [Soft Asserts](https://www.softwaretestingmaterial.com/soft-assert/) so you can check multiple items.
2. Implement [Explicit Waits](https://www.selenium.dev/documentation/en/webdriver/waits/) with Expected Conditions and WebDriverWaits. 
	- This will ensure that you will start testing once the elements or properties display after loading.
3. Implement [Select](https://stackoverflow.com/questions/12940592/how-to-select-an-item-from-a-dropdown-list-using-selenium-webdriver-with-java) for inputting and checking Dropdown values
	- This specifically helps for checking dropdown items.