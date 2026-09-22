/*
 * Class: CMSC203 
 * Instructor: Professor Agyun
 * Description: Stores and manages info about medical procedure.
 * Due: 09/28/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
  independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Yared Hailegebriel
*/


public class Procedure {

	//Variables 
	
	private String procedureName;
	private String date;
	private String practitionerName;
	private double charges;
	
	// Constructor 1

	public Procedure() {
	}
	
	//Constructor 2
	
	/*
	 * Procedure object with some of procedure information.
	 */
	
	public Procedure(String procedureName, String date) {
		this.procedureName = procedureName;
	    this.date = date;
	}
	
	//Constructor 3
	
	/*
	 * Procedure object with all procedure information.
	 */
	
	public Procedure(String procedureName, 
					 String date, 
					 String practitionerName, 
					 double charges) {

	this.procedureName = procedureName;
	this.date = date;
	this.practitionerName = practitionerName;
	this.charges = charges;
	}
	
	
	// Setters
	
	/*
	 * Sets procedure name
	 */
	public void setProcedureName(String procedureName) {
	    this.procedureName = procedureName;
	}

	/*
	 * Sets procedure date
	 */
	public void setDate(String date) {
	    this.date = date;
	}

	/*
	 * Sets practitioners name
	 */
	public void setPractitionerName(String practitionerName) {
	    this.practitionerName = practitionerName;
	}

	/*
	 * Sets procedure charge
	 */
	public void setCharges(double charges) {
	    this.charges = charges;
	}


	// Getters

	/*
	 * Returns procedure name
	 */
	public String getProcedureName() {
	    return procedureName;
	}

	/*
	 * Returns procedure date
	 */
	public String getDate() {
	    return date;
	}

	/*
	 * Returns practitioners name
	 */
	public String getPractitionerName() {
	    return practitionerName;
	}

	/*
	 * Returns procedure charge
	 */
	public double getCharges() {
	    return charges;
	}
	
	//Other Methods
	
	/*
	 * Returns procedure info as formatted String
	 */
	@Override
	public String toString() {
	    return "Procedure Name: " + procedureName +
	           "\nDate: " + date +
	           "\nPractitioner: " + practitionerName +
	           "\nCharge: " + getFormattedCharge();
	}


	/*
	 * Check procedure charge is $1000 or more
	 */
	public boolean isExpensiveProcedure() {
	    return charges >= 1000.00;
	}

	/*
	 * Applies discount to procedure charge if percent is valid
	 */
	public void applyDiscount(double percent) {
	    if (percent >= 0 && percent <= 100) {
	        double discount = charges * (percent / 100);
	        charges = charges - discount;
	    }
	}

	/*
	 * Return procedure charge category as Low, Medium, or High
	 */
	public String getChargeCategory() {
	    if (charges < 500) {
	        return "Low";
	    }
	    else if (charges < 1000) {
	        return "Medium";
	    }
	    else {
	        return "High";
	    }
	}

	/*
	 * Check if procedure was performed by the given practitioner
	 */
	public boolean isPerformedBy(String practitionerName) {
	    return this.practitionerName.equals(practitionerName);
	}

	/*
	 * Return procedure charge with correct money formatting
	 */
	public String getFormattedCharge() {
	    return String.format("$%,.2f", charges);
	}
	
}
