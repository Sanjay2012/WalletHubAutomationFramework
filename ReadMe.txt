#Git repository link
https://github.com/Sanjay2012/WalletHubAutomationFramework.git

- clone repository and check the code
- $ git clone https://github.com/Sanjay2012/WalletHubAutomationFramework.git


# To run test in different browser
- Change the value of the parameter in testng.xml file

# To run test without rendering UI (headless)
- use the browser options --headless 
- options.addArguments("--headless");

====Run test using Maven commands in command Line=====
Steps
1. Go to project location
2. open cmd
3. To clean project use====> $ mvn clean
4. For Test phase use===> $ mvn clean test
4. To create package use with test skip===> $ mvn clean package -Dmaven.test.skip=true   or
                                            $ mvn clean package -DskipTests
    