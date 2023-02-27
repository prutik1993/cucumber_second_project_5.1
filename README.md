# How my framework works

For this project I created BDD Framework (Behavior Driven Development). 
I used Java as a programming language and Maven as a build tool. Maven comes with easy folder stracture that help keep all my classes organized. Also Maven has pom.xml file, where I stored all plugins, goals, dependencies, profiles, versions. Maven also provide Target folder where all reports are stored. I integrated Maven-Surefire-Plugin in order to execute the specific suites with tags, using Maven commands (mvn clean test -Dcucumber.options="--tags @Smoke", mvn clean test -Dcucumber.options="--tags @Regression") and generated reports  will be stored under Target folder that I mantion before.
My framework integrated with JUnit for the Annotations to control test flow, Assertions for verification, and reports. 
I used SeleniumWebDriver and WebDriverManager to automate my web browser testing. 
I also implemented POM ans Singleton design paterns and used OOP principles. I centralized all web elements and page related methods in object repositories using PageFactory Class. Singleton allowed me to create a single driver instance  across my framework.
I have a Hooks Class where I keep my @After annotation to quit my driver that run after each scenario.
I have a Runner class that I linked with my feature file and their step implementation, in order to run scenarios. On top of each scenario I can put a @ -> tag that will defind my test suits. I can easily run my test suit in the Runner class, I can specify which tag (and so as the scenario(s)) I want to execute.

In my framework I have 2 suits:  
- @Smoke
- @Regression

I can easily execute them with maven commands:
- mvn clean test -Dcucumber.options="--tags @Smoke"
- mvn clean test -Dcucumber.options="--tags @Regression"

This command will first visit the pom.xml goal and then the Runner class. If runner class have a different tag, it will be updated with a given suit tag, now it will go to feature file and will start execute all the scenarios that have the same tag. Scenario steps will be executed with their linked implementation in the "steps" package. After execution is done reports will be generated and stored under the target folder.
                         


<img width="801" alt="Screenshot 2023-02-26 at 10 24 41 PM" src="https://user-images.githubusercontent.com/116601185/221475940-dabf46ac-98df-42ee-981a-21963908bb3e.png">
<img width="766" alt="Screenshot 2023-02-26 at 10 37 21 PM" src="https://user-images.githubusercontent.com/116601185/221475942-e39d894b-8f07-45d1-8fb6-d839071d2484.png">
<img width="830" alt="Screenshot 2023-02-26 at 10 39 12 PM" src="https://user-images.githubusercontent.com/116601185/221475945-d0080565-c1d9-4aa4-ae2a-f77f0b51b356.png">
