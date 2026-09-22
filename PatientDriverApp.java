/*
 * Class: CMSC203 
 * Instructor: Professor Agyun
 * Description: Gathers patient info and displays procedure and charge information.
 * Due: 09/28/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
  independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Yared Hailegebriel
*/


import java.util.Scanner;

public class PatientDriverApp {

	//Main Method
	
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        Patient patient = inputPatient(input);
        
        Procedure procedure1 = createProcedure1();
        Procedure procedure2 = createProcedure2(); 
        Procedure procedure3 = createProcedure3();
        
        //Display info
        displayPatient(patient);
        
        displayProcedure(procedure1);
        displayProcedure(procedure2);
        displayProcedure(procedure3);
        
        
        //Display table
        displayProcedureTable(procedure1, procedure2, procedure3);

        //Display calculations
        displaySummary(procedure1, procedure2, procedure3);

        
        System.out.println("\nThe program was developed by a Student: "
                + "Yared Hailegebriel 09/18/26");

        input.close();
        
        
    }
    //==============================================================================
    //								Other Methods
    //==============================================================================
    
    public static Patient inputPatient(Scanner input) {

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter middle name: ");
        String middleName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter street address: ");
        String streetAddress = input.nextLine();

        System.out.print("Enter city: ");
        String city = input.nextLine();

        System.out.print("Enter state: ");
        String state = input.nextLine();

        System.out.print("Enter ZIP code: ");
        String zipCode = input.nextLine();

        System.out.print("Enter phone number (###-###-####): ");
        String phoneNumber = input.nextLine();

        System.out.print("Enter emergency contact name: ");
        String emergencyContactName = input.nextLine();

        System.out.print("Enter emergency contact phone (###-###-####): ");
        String emergencyContactPhone = input.nextLine();

        Patient patient = new Patient(firstName, middleName, lastName,
                streetAddress, city, state, zipCode,
                phoneNumber, emergencyContactName, emergencyContactPhone);

        return patient;
    }
    
    
    /*
     * Create first Procedure object using Constructor 1
     */
    public static Procedure createProcedure1() {
    	Procedure procedure = new Procedure();

        procedure.setProcedureName("Physical Exam");
        procedure.setDate("07/20/2026");
        procedure.setPractitionerName("Dr Irvine");
        procedure.setCharges(250.00);

        return procedure;
    }
    
    /*
     * Create second Procedure object using Constructor 2
     */
    public static Procedure createProcedure2() {
    	Procedure procedure = new Procedure("X-ray", "07/20/2026");

        procedure.setPractitionerName("Dr Jamison");
        procedure.setCharges(550.43);

        return procedure;
    }
    
    /*
     * Create third Procedure object using Constructor 3
     */
    public static Procedure createProcedure3() {
        Procedure procedure = new Procedure("Blood Test",
							        		"07/20/2026",
							                "Dr Smith",
							                1400.75);

        return procedure;
    }
    
    //======================================================================
    /*
     * Display patients information and phone validation
     */
    public static void displayPatient(Patient patient) {

        System.out.println("\nPatient Information:");
        System.out.println(patient);

        System.out.println("Phone Valid: " + patient.isValidPhoneNumber());

        System.out.println("Emergency Phone Valid: " + patient.isValidEmergencyPhoneNumber());
    }
    
    
    //======================================================================
    
    /*
     * Display information for a Procedure object
     */
    public static void displayProcedure(Procedure procedure) {
        System.out.println(procedure);
    }
    
    //======================================================================
    
    /*
     * Display procedure information in a table
     */
    public static void displayProcedureTable(
            Procedure p1, Procedure p2, Procedure p3) {

        System.out.println("\nProcedure Information:");

        System.out.printf("%-20s %-15s %-20s %12s %-10s%n", 
        		"Procedure", 
        		"Date", 
        		"Practitioner", 
        		"Charge", 
        		"Category");

        System.out.printf("%-20s %-15s %-20s %12s %-10s%n",
                p1.getProcedureName(),
                p1.getDate(),
                p1.getPractitionerName(),
                p1.getFormattedCharge(),
                p1.getChargeCategory());

        System.out.printf("%-20s %-15s %-20s %12s %-10s%n",
                p2.getProcedureName(),
                p2.getDate(),
                p2.getPractitionerName(),
                p2.getFormattedCharge(),
                p2.getChargeCategory());

        System.out.printf("%-20s %-15s %-20s %12s %-10s%n",
                p3.getProcedureName(),
                p3.getDate(),
                p3.getPractitionerName(),
                p3.getFormattedCharge(),
                p3.getChargeCategory());
    }
    
    //======================================================================
    
    /*
     * Calculate and return total charge of all procedures
     */
    public static double calculateTotalCharges(
            Procedure p1, Procedure p2, Procedure p3) {

        double total = p1.getCharges()
                     + p2.getCharges()
                     + p3.getCharges();

        return total;
    }
    
    //======================================================================
    
    /*
     * Calculate and return average charge of all procedures
     */
    public static double calculateAverageCharge(
            Procedure p1, Procedure p2, Procedure p3) {

        double total = calculateTotalCharges(p1, p2, p3);

        return total / 3;
    }
    
    //======================================================================
    
    /*
     * Find and return procedure with the highest charge
     */
    public static Procedure findHighestChargeProcedure(
            Procedure p1, Procedure p2, Procedure p3) {

        Procedure highest = p1;

        if (p2.getCharges() > highest.getCharges()) {
            highest = p2;
        }

        if (p3.getCharges() > highest.getCharges()) {
            highest = p3;
        }

        return highest;
    }
    
    //======================================================================
    
    /*
     * Count and return number of expensive procedures
     */
    public static int countExpensiveProcedures(
            Procedure p1, Procedure p2, Procedure p3) {

        int count = 0;

        if (p1.isExpensiveProcedure()) {
            count++;
        }

        if (p2.isExpensiveProcedure()) {
            count++;
        }

        if (p3.isExpensiveProcedure()) {
            count++;
        }

        return count;
    }
    
    //======================================================================
    
    /*
     * Display total, average, highest charge, and number of expensive procedures
     */
    public static void displaySummary(
            Procedure p1, Procedure p2, Procedure p3) {

        double total = calculateTotalCharges(p1, p2, p3);
        double average = calculateAverageCharge(p1, p2, p3);

        Procedure highest = findHighestChargeProcedure(p1, p2, p3);

        int expensiveCount = countExpensiveProcedures(p1, p2, p3);

        System.out.printf("%nTotal Charges: $%,.2f%n", total);
        System.out.printf("Average Charge: $%,.2f%n", average);

        System.out.println("Highest Charge Procedure: " + highest.getProcedureName());

        System.out.println("Number of Expensive Procedures: " + expensiveCount);
    }
}