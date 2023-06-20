import java.util.Scanner;

public class MovieTicketBookingSystem2 {
    static String[] movieNames = {"John Wick", "Avengers", "Paathan"};
    static int[] ticketsAvailable = {10, 20, 30};
    static int[] ticketPrices = {100, 150, 200};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 4) {
            System.out.println("1. Show Movie Details");
            System.out.println("2. Book Tickets");
            System.out.println("3. Show Available Tickets");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showMovieDetails();
                    break;
                case 2:
                    bookTickets();
                    break;
                case 3:
                    showAvailableTickets();
                    break;
                case 4:
                    System.out.println("Thank you for using the Movie Ticket Booking System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void showMovieDetails() {
        System.out.println("Movie Details:");
        for (int i = 0; i < movieNames.length; i++) {
            System.out.println((i + 1) + ". " + movieNames[i] + " - " + ticketPrices[i] + " INR");
        }
    }

    public static void bookTickets() {
        Scanner input = new Scanner(System.in);
		String[][] seats = new String[10][10];
        int row, col;
        String seat;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                seats[i][j] = "O";
            }
        }

        while (true) {
            System.out.println("Enter 1 to book a seat, 2 to cancel a seat, or 3 to exit:");
            int choice = input.nextInt();

            if (choice == 1) {
                System.out.println("Enter the row number (1-10):");
                row = input.nextInt() - 1;
                System.out.println("Enter the column letter (A-J):");
                seat = input.next();
                col = seat.charAt(0) - 'A';

                if (seats[row][col].equals("O")) {
                    seats[row][col] = "X";
                    System.out.println("Seat " + (row + 1) + seat + " has been booked.");
                } else {
                    System.out.println("Seat " + (row + 1) + seat + " is already booked.");
                }
            } else if (choice == 2) {
                System.out.println("Enter the row number (1-10):");
                row = input.nextInt() - 1;
                System.out.println("Enter the column letter (A-J):");
                seat = input.next();
                col = seat.charAt(0) - 'A';

                if (seats[row][col].equals("X")) {
                    seats[row][col] = "O";
                    System.out.println("Seat " + (row + 1) + seat + " has been cancelled.");
                } else {
                    System.out.println("Seat " + (row + 1) + seat + " is not booked.");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
	}

    public static void showAvailableTickets() {
        System.out.println("Available Tickets:");
        for (int i = 0; i < movieNames.length; i++) {
            System.out.println(movieNames[i] + " - " + ticketsAvailable[i] + " tickets available");}}}