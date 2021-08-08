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
public interface TelephoneDirectory {

    /*
     * The method returns list of all phone numbers
     */
    public List<String> getAllPhoneNumbers();

    /*
     * The method returns list of all phone numbers for a given customer
     */
    public List<String> getAllPhoneNumbers(int customerId);

    /*
     * The method activates phonenumber for a given customer
     */
    public void activatePhoneNumber(int customerId, String phoneNumber);

}

</html>
