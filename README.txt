# OrangeHRM-Automation with Selenium/Java

1) It is maven based project that can handle all the pom.xml dependency.
2) I used for POM based Structure to maintain all locators in webPage.
3) I used selenium for automation with java language. 
4) I used Test engine(TestNG) for run command to verify testcase in perticular Test.
5) I used apache log4j to manage all log.
6) All configuration of project I maintained in separate congfiguration folder.

#Here I have included all test case details so it can make easy to understand.

Url: http://opensource.demo.orangehrmlive.com/
 
Login: Admin
Pwd: admin
 
Step 1: Navigate to “PIM à Add Employee”. Assert the header “Add Employee”.
Step 2: Fill name details, Employee Id and check “Create Login Details”.
Step 3: After Checking “Create Login Details”. Fill in all details and click save.
Step 4: Navigate to Leave à Entitlements à Add Entitlements. Fill the above created employee in “Employee” field, “Leave Type” as “Vacation US” & “Entitlement” as 10.00. Click save.
Step 5: Logout from the Application and Login again as created in Step 03.
Step 6: Navigate to “Leave à Apply”. Assert the header “Apply Leave”. Select “Leave Type”, “From Date” and “To Date” as today and click Apply.
Step 7: Logout from the Application and Login again as “Admin”.
Step 8: Navigate to Leave à Leave List. Scroll below to find the employee created and from Actions column Select as “Approve” and click save.
Step 9: Logout from the Application and Login again as created in Step 03.
Step 10: Navigate to Leave à My Leave. Scroll below to find the Leave that you applied and Assert the status column as “Scheduled(1.00)”.
sdsd