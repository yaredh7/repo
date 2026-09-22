/*
 * Class: CMSC203 
 * Instructor: Professor Agyun
 * Description: Stores and manages patient as well as emergency contact information.
 * Due: 09/28/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
  independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Yared Hailegebriel
*/


public class Patient {

	//Variables
	
	private String firstName = "";
	private String middleName = "";
	private String lastName = "";
	
	private String streetAddress = "";
	private String city = "";
	private String state = "";
	private String zipcode = "";
	
	private String phoneNumber = "";
	private String emergencyContactName = "";
	private String emergencyContactPhone = "";
	
	//Constructor 1
	
	public Patient() {
	}
	
	//Constructor 2
	
	/*
	 * Patient object with name of patient
	 */
	public Patient(String firstName, String middleName, String lastName) {
		
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	
	
	//Constructor 3
	
	/*
	 * Patient object with all of the patients information
	 */
	
	public Patient(String firstName, 
				   String middleName, 
				   String lastName, 
				   String streetAddress, 
				   String city, 
				   String state,
				   String zipcode,
				   String phoneNumber,
				   String emergencyContactName,
				   String emergencyContactPhone) {
		
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		
		this.phoneNumber = phoneNumber;
		this.emergencyContactName = emergencyContactName;
		this.emergencyContactPhone = emergencyContactPhone;
		
	}
	
	//Setters
	
	/*
	 * Sets the patients first name
	 */
	public void setFirstName(String firstName) {
	    this.firstName = firstName;
	}
	
	/*
	 * Sets the patients middle name
	 */
	public void setMiddleName(String middleName) {
	    this.middleName = middleName;
	}
	
	/*
	 * Sets the patients last name
	 */
	public void setLastName(String lastName) {
	    this.lastName = lastName;
	}
	
	/*
	 * Sets the patients address
	 */
	public void setStreetAddress(String streetAddress) {
	    this.streetAddress = streetAddress;
	}
	
	/*
	 * Sets the patients city
	 */
	public void setCity(String city) {
	    this.city = city;
	}
	
	/*
	 * Sets the patients state
	 */
	public void setState(String state) {
	    this.state = state;
	}
	
	/*
	 * Sets the patients zipcode
	 */
	public void setZipcode(String zipcode) {
	    this.zipcode = zipcode;
	}
	
	/*
	 * Sets the patients phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
	    this.phoneNumber = phoneNumber;
	}
	
	/*
	 * Sets the patients emergency contact name
	 */
	public void setEmergencyContactName(String emergencyContactName) {
	    this.emergencyContactName = emergencyContactName;
	}
	
	/*
	 * Sets the patients emergency contact phone number
	 */
	public void setEmergencyContactPhone(String emergencyContactPhone) {
	    this.emergencyContactPhone = emergencyContactPhone;
	}
	
	//Getters
	
	/*
	 * Returns the patients first name
	 */
	public String getFirstName() {
	    return firstName;
	}
	
	/*
	 * Returns the patients middle name
	 */
	public String getMiddleName() {
	    return middleName;
	}
	
	/*
	 * Returns the patients last name
	 */
	public String getLastName() {
	    return lastName;
	}
	
	/*
	 * Returns the patients address
	 */
	public String getStreetAddress() {
	    return streetAddress;
	}
	
	/*
	 * Returns the patients city
	 */
	public String getCity() {
	    return city;
	}
	
	/*
	 * Returns the patients state
	 */
	public String getState() {
	    return state;
	}
	
	/*
	 * Returns the patients zipcode
	 */
	public String getZipcode() {
	    return zipcode;
	}
	
	/*
	 * Returns the patients phone number
	 */
	public String getPhoneNumber() {
	    return phoneNumber;
	}
	
	/*
	 * Returns the patients emergency contact name
	 */
	public String getEmergencyContactName() {
	    return emergencyContactName;
	}
	
	/*
	 * Returns the patients emergency contact phone number
	 */
	public String getEmergencyContactPhone() {
	    return emergencyContactPhone;
	}
	
	//Other Methods
	
	/*
	 * Puts together and returns the patients first, middle, and last name
	 */
	public String buildFullName() {
	    return firstName + " " + middleName + " " + lastName;
	}
	
	/*
	 * Puts together and returns the patients complete address
	 */
	public String buildAddress() {
	    return streetAddress + " " + city + " " + state + " " + zipcode;
	}
	
	/*
	 * Puts together and returns the emergency contact's name and phone number.
	 */
	public String buildEmergencyContact() {
	    return emergencyContactName + " " + emergencyContactPhone;
	}
	
	/*
	 * Returns patients info as formatted String
	 */
	@Override
	public String toString() {
	    return "Name: " + buildFullName() +
	           "\nAddress: " + buildAddress() +
	           "\nPhone Number: " + phoneNumber +
	           "\nEmergency Contact: " + buildEmergencyContact();
	}
	
	/*
	 * Check if patients phone number uses correct formating
	 */
	public boolean isValidPhoneNumber() {
	    return phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}");
	}

	/*
	 * Check if emergency contact phone number uses correct formatting
	 */
	public boolean isValidEmergencyPhoneNumber() {
	    return emergencyContactPhone.matches("\\d{3}-\\d{3}-\\d{4}");
	}
	
	/*
	 * Returns patients name in Last, First Middle formating
	 */
	public String getLastFirstMiddle() {
	    return lastName + ", " + firstName + " " + middleName;
	}
	
	/*
	 * Check if patient has the same city and state as the given values
	 */
	public boolean hasSameCityState(String city, String state) {
	    return this.city.equals(city) && this.state.equals(state);
	}
	
	/*
	 * Updates patients street, city, state, and ZIP code
	 */
	public void updateAddress(String street, 
							  String city, 
							  String state, 
							  String zip) {

	streetAddress = street;
	this.city = city;
	this.state = state;
	zipcode = zip;
	}
	
	/*
	 * Returns summary of patients phone and emergency contact information.
	 */
	public String getContactSummary() {
	    return "Patient: " + buildFullName()
	            + "\nPhone: " + phoneNumber
	            + "\nEmergency Contact: " + buildEmergencyContact();
	}
}
