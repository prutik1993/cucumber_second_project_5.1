# How my framework works

For this priject I created BDD Framework (Behavior Driven Development). 
I used Java as a programming language and Maven as a build tool. Maven comes with easy folder stracture that help keep all my classes organized. Also Maven has pom.xml file, where I stored all plugins, goals, dependencies, profiles, versions. Maven also provide Target folder that stores all reports. I integrated Maven-Surefire-Plugin in order to execute the specific suites with tags using Maven commands (mvn clean test -Dcucumber.options="--tags @Smoke", mvn clean test -Dcucumber.options="--tags @Regression") and generate reports that will be store under Target folder that I mantion before.
My framework integrated with JUnit for the Annotations to control test flow, Assertions for verification and reports. 

<img width="801" alt="Screenshot 2023-02-26 at 10 24 41 PM" src="https://user-images.githubusercontent.com/116601185/221475940-dabf46ac-98df-42ee-981a-21963908bb3e.png">
<img width="766" alt="Screenshot 2023-02-26 at 10 37 21 PM" src="https://user-images.githubusercontent.com/116601185/221475942-e39d894b-8f07-45d1-8fb6-d839071d2484.png">
<img width="830" alt="Screenshot 2023-02-26 at 10 39 12 PM" src="https://user-images.githubusercontent.com/116601185/221475945-d0080565-c1d9-4aa4-ae2a-f77f0b51b356.png">
