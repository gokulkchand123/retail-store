retail-store-discounts
#################################################

As per the requirement ,Bill Amount for a Retail Store system

 * Technology Assessment
 * 
 * 
 * 1. If the user is an employee of the store, he gets a 30% discount 
 * 2. If the user is an affiliate of the store, he gets a 10% discount 
 * 3. If the user has been a customer for over 2 years, he gets a 5% discount. 
 * 4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45 	  as a discount). 
 * 5. The percentage based discounts do not apply on groceries. 
 * 6. A user can get only one of the percentage based discounts on a bill.  
 
 * Finds the net payable amount.
 
For retail store following these scenarios are covered,

1) We have created this using maven build and can import as maven project.
2) we have covered Cobertura for quality check.
3) We can run this application using java 1.8 or above.
4) we have implemented for test cases from Junit.

To build the application follow the below steps:
----------------------------------------------
1) mvn clean install -Dmaven.test.skip=false

To run the cobertura report
----------------------------------------------
2) mvn clean cobertura:cobertura -Pqualitycheck

To run the test case follow the below steps:
----------------------------------------------
 mvn clean test -Dtest=com.retail.billingsystem.services.BillCalculatorServiceImplTest
 mvn clean test -Dtest=com.retail.billingsystem.services.ItemTest
 mvn clean test -Dtest=com.retail.billingsystem.services.ConsumerTest

 
 
 