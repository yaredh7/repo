import java.util.Scanner;
import java.io.*;


public class GradeCalculator {
	
	public static void main(String[] args) throws IOException {
		String fileName = "gradeconfig.txt";
		
		
		// First Variables
		boolean defaultUsed = false;
		
		String courseName;
		int numberOfCategories;

		String category1 = "";
		int weight1 = 0;

		String category2 = "";
		int weight2 = 0;

		String category3 = "";
		int weight3 = 0;
		
		
		
		
		
		
		
		
		//Checking for existence of File
		
		if(!new File(fileName).exists()) {
			
			//Default configuration if file doesn't exist
			defaultUsed = true;
			
			System.out.println("File Doesn't Exist: Default configuration used");			

			courseName = "CMSC203 Computer Science I";
			numberOfCategories = 3;
			
			category1 = "Projects";
			weight1 = 40;
			
			category2 = "Quizzes";
			weight2 = 30;
			
			category3 = "Exams";
			weight3 = 30;
		} else {
		
			//Read and input values from the file
			Scanner input = new Scanner(new File(fileName));
			
			
			courseName = input.nextLine();
			numberOfCategories = input.nextInt();
			
			for(int i = 1; i <= numberOfCategories; i++) {
					
				if (i == 1) {
					
					category1 = input.next();
					weight1 = input.nextInt();
				} else if (i == 2) {	
					
					category2 = input.next();
					weight2 = input.nextInt();
				} else if (i == 3) {
					
					category3 = input.next();
					weight3 = input.nextInt();
				}
			}
			
			
			//Close
			input.close();
		}
			
			
			
			
			
			
		//Validating the weights and total weight of the assignments
			
		if(weight1 + weight2 + weight3 != 100 || weight1 < 0 || weight2 < 0 || weight3 < 0) {
			
			defaultUsed = true;
				
			System.out.println("Invalid Input(s): Default configuration used");
				
			courseName = "CMSC203 Computer Science I";
			numberOfCategories = 3;
				
			category1 = "Projects";
			weight1 = 40;
				
			category2 = "Quizzes";
			weight2 = 30;
				
			category3 = "Exams";
			weight3 = 30;
		}
			
		
		
		
		//Second Variables
		String inputFileName = "grades_input.txt";
		
		String firstName;
		String lastName;
		
		String categoryInput1;
		int numOfCategory1;
		String categoryInput2;
		int numOfCategory2;
		String categoryInput3;
		int numOfCategory3;
		
		double total1 = 0;
		double score1;
		double average1 = 0;
		
		double total2 = 0;
		double score2;
		double average2 = 0;
		
		double total3 = 0;
		double score3;
		double average3 = 0;
		
		
		
		
		
		//Checking for existence of File
		
		if (!new File(inputFileName).exists()) {
			
		    System.out.println("grades_input.txt does not exist.");
		    
		} else {
			//Read and input values from the file
			Scanner scoreInput = new Scanner(new File(inputFileName));
			firstName = scoreInput.next();
			lastName = scoreInput.next();
			
			
			//Get Category 1 and Validate it 
			
			categoryInput1 = scoreInput.next();
			numOfCategory1 = scoreInput.nextInt();
			
			if(categoryInput1.equals(category1)) {				
				
				for (int i = 1; i <= numOfCategory1; i++) {
					
			    	score1 = scoreInput.nextDouble();
			    	total1 += score1;
				}
				
				average1 = total1 / numOfCategory1;
			}else {
				
				System.out.println("Category does not match: " + categoryInput1);
				
				for (int i = 1; i <= numOfCategory1; i++) {
			        scoreInput.nextDouble();
			    }
			}
			
			
			//Get Category 2 and Validate it 			
			
			categoryInput2 = scoreInput.next();
			numOfCategory2 = scoreInput.nextInt();
			
			if(categoryInput2.equals(category2)) {				
				
				for (int i = 1; i <= numOfCategory2; i++) {
					
			    	score2 = scoreInput.nextDouble();
			    	total2 += score2;
				}
				
				average2 = total2 / numOfCategory2;
			}else {
				
				System.out.println("Category does not match: " + categoryInput2);
				
				for (int i = 1; i <= numOfCategory2; i++) {
			        scoreInput.nextDouble();
			    }
			}
			
			
			
			//Get Category 3 and Validate it 
			
			categoryInput3 = scoreInput.next();
			numOfCategory3 = scoreInput.nextInt();
			
			if(categoryInput3.equals(category3)) {
				
				for (int i = 1; i <= numOfCategory3; i++) {
					
			    	score3 = scoreInput.nextDouble();
			    	total3 += score3;
				}
				
				average3 = total3 / numOfCategory3;
			}else {
				
				System.out.println("Category does not match: " + categoryInput3);
				
				for (int i = 1; i <= numOfCategory3; i++) {
			        scoreInput.nextDouble();
			    }
			}
			
			
			//Third Variables
			double overall;
			String letterGrade;
			String plusMinus;
			
			//Finding percentage grade
			overall = (average1 * (weight1/ 100.0)) 
					+ (average2 * (weight2/ 100.0)) 
					+ (average3 * (weight3/ 100.0));
			
			
			// Getting letter grade
			
			if(overall >= 90.0) {
				
				letterGrade = "A";
			} else if(overall >= 80.0) {
				
				letterGrade = "B";
			} else if(overall >= 70.0) {
				
				letterGrade = "C";
			} else if(overall >= 60.0) {
				
				letterGrade = "D";
			} else {
				
				letterGrade = "F";
			}
			
			//Close
			scoreInput.close();
			
			
			
			//Ask if want +/- grades
		
			Scanner keyboard = new Scanner(System.in);
			
			System.out.println("Apply +/- grading? (Y/N): ");
			
			do {
				plusMinus = keyboard.next();
				
				switch(plusMinus) {
				
				case "Y", "y":
					if(overall >= 97.0) {
						
						letterGrade = "A+";
					} else if(overall >= 93.01) {
						
						letterGrade = "A";
					} else if(overall >= 90.0) {
						
						letterGrade = "A-";
					} else if(overall >= 87.0) {
						
						letterGrade = "B+";
					} else if(overall >= 83.01) {
						
						letterGrade = "B";
					} else if(overall >= 80.0) {
						
						letterGrade = "B-";
					} else if(overall >= 77.0) {
						
						letterGrade = "C+";
					} else if(overall >= 73.01) {
						
						letterGrade = "C";
					} else if(overall >= 70.0) {
						
						letterGrade = "C-";
					} else if(overall >= 67.0) {
						
						letterGrade = "D+";
					} else if(overall >= 63.01) {
						
						letterGrade = "D";
					} else if(overall >= 60.0) {
						
						letterGrade = "D-";
					} else if(overall >= 57.0) {
						
						letterGrade = "F+";
					} else if(overall >= 53.01) {
						
						letterGrade = "F";
					} else {
						
						letterGrade = "F-";
					}
					
					break;
					
				case "N", "n":
					break;
				}
			} while (!plusMinus.equals("Y") && !plusMinus.equals("y")
			        && !plusMinus.equals("N") && !plusMinus.equals("n"));
			
			
			//Close
			keyboard.close();
			
			
			
			
			//Printing
			String printFileName = "grades_report.txt"; 
			
			PrintWriter output = new PrintWriter(printFileName);
			
			output.println(courseName);
			output.println("" + firstName + " " + lastName);
			
			
			output.print(category1);
			output.printf(": %.2f", average1);
			output.print(" (" + weight1 + "%)\n");
			
			
			output.print(category2);
			output.printf(": %.2f", average2);
			output.print(" (" + weight2 + "%)\n");
			
			
			output.print(category3);
			output.printf(": %.2f", average3);
			output.print(" (" + weight3 + "%)\n");
			
			
			output.printf("Percent Grade: %.2f\n", overall);
			output.println("Final Letter Grade: " + letterGrade);
			output.println("Default Configuration Used: " + defaultUsed);
			
			
			
			//Close
			output.close();
			
			System.out.println(courseName);
			System.out.println("" + firstName + " " + lastName);
			
			
			System.out.print(category1);
			System.out.printf(": %.2f", average1);
			System.out.print(" (" + weight1 + "%)\n");
			
			
			System.out.print(category2);
			System.out.printf(": %.2f", average2);
			System.out.print(" (" + weight2 + "%)\n");
			
			
			System.out.print(category3);
			System.out.printf(": %.2f", average3);
			System.out.print(" (" + weight3 + "%)\n");
			
			
			System.out.printf("Percent Grade: %.2f\n", overall);
			System.out.println("Final Letter Grade: " + letterGrade);
			System.out.println("Default Configuration Used: " + defaultUsed);
		}
		
		
	}

}
