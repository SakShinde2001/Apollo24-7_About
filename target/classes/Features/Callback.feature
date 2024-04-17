@runall
Feature: To test About Feature functionality of Apollo Website

Background: 
Given User is on Apollo homepage 

@callback
Scenario: To validate callback functionality 

When user clicks on health queries option
And clicks on Request a callback button 
And enters patient name, email id and mobile number
|Sakshi Shinde|sakshishinde2909@gmail.com|8369749585|
And clicks on sumbit button
Then it should give the success message

@comment 
Scenario: To validate post comment functionality 

When user clicks on blogs option
And searches any article
|cataract|
And choose any option from the suggested articles
And post a comment on the article using credentials 
And submit the comment
Then it should increase the count 


@bookdoctor
Scenario: To validate book doctor functionality 

When user clicks on hospitals and clinics option
And chooses filters for type and location
And clicks on view details for any option from the list
And chooses any of the specialty 
Then it should show the list of speciality doctors  

@location
Scenario: To validate location functionality 

When user clicks on diagnostics centre option
And chooses dropdowns of location
And clicks on website of the result location
And get the direction of the location
And click on book now
Then it should redirect to the book function

@calories
Scenario: To validate calculate calories required functionality 

When user clicks on Blogs option
And clicks on Health tools option 
And clicks on calculate calories button 
And enters age, gender, height, weight, activity level
And clicks on calculate button
Then it should give the result
