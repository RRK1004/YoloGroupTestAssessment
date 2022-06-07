Feature: Navigate to Selenium HQ page in chrome browser in android device
  
  Scenario: I want to go to the 'www.seleniumhq.org'  On a Chrome browser of an android device
  Given  Open a Chrome browser of an android device in browserstack
  When I go to 'https://www.google.com/'
  And I type 'Seleniumhq' in the searchbox
  And I press enter in the searchbox
  And I click on 'Selenium' link
  Then I am on Selenium HQ Page