# SurveyWebsite_JSF2
Website that uses the Java Server Faces 2 Framework
This uses an MVC-based Web application using JSF2 framework. 
The application allows prospective students to fill out a survey form to provide feedback about their campus visit.
It also allows users to view all surveys recorded to date. 
The application starts with a welcome homepage, which in essence has two links: 
1) Student Survey, which allows a prospective student to fill out a survey form, and 
2) List All Surveys, which allows a user to view all surveys done to date.
An additional text box called Raffle is provided. 
The user will be asked to enter at least ten comma separated numbers ranging from 1 through 100 in the Raffle field.
This information will be used to announce whether the student wins a free movie ticket by computing the standard deviation.
The information is stored on Oracle 10g running on the George Mason servers.
This application is a dynamic web project and is deployed on Tomcat.
The Amazon EC2 with a Tomcat application server was used to deploy the war file.

URL : http://ec2-54-174-153-59.compute-1.amazonaws.com:8080/SWE 645_HW2/
