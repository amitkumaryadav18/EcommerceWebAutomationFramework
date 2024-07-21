
# Ecommerce Web Automation




## Goals
The goal for this project is to build a Web/ UI test automation framework using Selenium + Maven + TestNG. While using clean code practices and integrate it with CI framework (Jenkins).
## Technologies/Tools used in building the framework
- Selenium
- Java, TestNG
- Allure Reports
- Hamcrest
- Lombok
- GitHub & Jenkins
## Installation

Install and run test locally follow these steps
- Install maven
- Install java 11+
- Download, extract this repo and run these commands to build project
```bash
cd EcommerceAutomationPractice

mvn clean test 
```
    
## Automated Tests


As per scope, decided to automate BuyAndOrder flows, register/ login flows, Cart and other pages flows.

## Results

We have a framework which is highly Scalable and extensible.

Some of the highlights for the clean code in this framework are -
- Developed Page Object Model framework from scratch which is modular, readable, maintainable and scalable
- Implemented parallel execution using testNG, maven and JUnit
- Singleton Design Pattern is used for Loading Config files only once and use forever. 
- Factory design pattern (using interface and abstract class) 
- Robust reporting and logging using Allure. Specifically, using various annotations to filter the reports and Step annotation of testNG to print request/ response payload for debugging.
- Automated webDriver management and multi-browser compatibility. (just pass a cmd parameter for which browser to use)
- Integration with Jenkins and gitHub. Also, using Git hooks whenever there is a commit, regression is triggered on jenkins.
