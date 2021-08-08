# TelephoneDirectory
<html>
	<b>Background</b>	<br/>																																																																																																
We are a Telecom operator. In our database, we are starting to store phone numbers associated to customers (1 customer: N phone numbers) and the code provide interfaces to manage them.			<br/>	<br/>																																																																																					
<b>Below are the capabilities:</b><br/>
•	get all phone numbers<br/>
•	get all phone numbers of a single customer<br/>
•	activate a phone number<br/><br/>	
	
<b>Prerequisites for executing the code:</b><br/>
•	Java 8<br/>
•	Maven 3<br/>

<b>Ouput:</b><br/>Run below maven command to generate executable jar <b>TelephoneDirectory-1.0-SNAPSHOT-jar-with-dependencies.jar</b><br/>
•	mvn clean compile assembly:single

<b>Execution:</b><br/>Run below command to execute jar.<br/>
•	java -jar TelephoneDirectory-1.0-SNAPSHOT-jar-with-dependencies.jar
	
<b>Assumptions:</b><br/>
The phone numbers as a static data structure that is initialised when program runs.<b> DAO layer has not been implemented due to this assumption. However Springboot's H2 database can also be used to mock the database implementation.<b/><br/>

<b>Interface Specifications:</b><br/>
![image](https://user-images.githubusercontent.com/88463824/128631490-46613abb-e46d-4c9d-b7b7-96335e9ef713.png)
   
<b>Data Structure</b>	<br/>
![image](https://user-images.githubusercontent.com/88463824/128631635-5137b6c9-33e4-4c10-bd0a-64599f4d73b3.png)
![image](https://user-images.githubusercontent.com/88463824/128631619-02b6bd55-5c5f-43ae-92f9-260804b12d71.png)

<b>Static Data:</b><br/>
![image](https://user-images.githubusercontent.com/88463824/128631528-3179c0de-b5f7-4aeb-ad0f-8afa3edf9583.png)


</html>
