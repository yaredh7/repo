import java.util.Scanner;

public class MovieDriverTask1 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Movie movie = new Movie();
		
		//First Question
		System.out.println("Enter the name of a movie:");
		
		String title = input.nextLine();
		movie.setTitle(title);
		
		//Second Question
		System.out.println("Enter the rating of the movie:");
		
		String rating = input.nextLine();
		movie.setRating(rating);
		
		//Third Question
		System.out.println("Enter the number of tickets sold for this movie:");
		
		int tickets = input.nextInt();
		movie.setSoldTickets(tickets);
		
		
		System.out.println(movie.toString());

		input.close();
	}

}
