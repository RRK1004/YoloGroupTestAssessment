# YoloGroupTestAssessment

Short info about implementaions :

Programming language : **Selenium with Java** 

Mobile Web Test : 
*)I have used **Maven project with BDD cucumber framework** . our test cases written in Feature file and code implemenation in step definition file.
*)To run test cases in mobile devices , **integrated with browser stack and configured the android device with chrome browser**.



### Mobile web test
---------------------------------------------------
- On a Chrome browser of an android device
- Given I want to go to the 'www.seleniumhq.org' Page
- When I go to 'www.google.com'
	- and I type 'Seleniumhq' in the searchbox
	- and I press 'ENTER' in the searchbox
	- and I click on 'Selenium HQ' link
- Then I´m on Selenium HQ Page
--------------------------------------------------- 

Precondition : Working  browser stack access key and username should be provided in the code

Steps to execute : 

1) Download the YoloGroupTestAssessment repo into your local
2) Open Eclipse IDE and import the Yolo Test Maven project
3) Run the runner file in the src/test/java/RunnerClass.java file
4) Check the execution logs go to Browser stack or under target folder, cucumber report 


