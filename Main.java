import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        TicketBookingSystem ticketSystem = TicketBookingSystem.getInstance();

        Observer userObserver = new UserObserver();
        ticketSystem.registerObserver(userObserver);

        TicketFactory regularFactory = new RegularTicketFactory();
        TicketFactory vipFactory = new VIPticketFactory();

        Ticket regularTicket = regularFactory.createTicket();
        Ticket vipTicket = vipFactory.createTicket();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you have our discount card?");
        System.out.println("1. No");
        System.out.println("2. Yes");
        System.out.println("Enter your choice: ");
        int priceChoice = scanner.nextInt();

        switch (priceChoice) {
            case 1 -> ticketSystem.setPriceStrategy(new RegularPriceStrategy());
            case 2 -> ticketSystem.setPriceStrategy(new DiscountPriceStrategy());
            default -> System.out.println("Invalid choice. We consider it is No.");
        }
        int choice = 0;
        while (choice != 5) {
            System.out.println("\nMenu:");
            System.out.println("1. View available tickets");
            System.out.println("2. Book tickets without anything");
            System.out.println("2. Book tickets with Insurance");
            System.out.println("3. Book tickets with Seat Selection");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Available tickets: " + ticketSystem.getAvailableTickets());
                    break;
                case 2:
                    System.out.print("Enter the number of tickets to book: ");
                    int numTickets = scanner.nextInt();
                    ticketSystem.bookTickets(regularTicket, numTickets);
                    System.out.print("Regular or VIP tickets?");
                    System.out.print("1. VIP");
                    System.out.print("2. Regular");
                    System.out.println("Enter your choice: ");
                    int FactoryChoice = scanner.nextInt();
                    switch (FactoryChoice) {
                        case 1 -> ticketSystem.bookTickets(regularTicket, 5);
                        case 2 ->  ticketSystem.bookTickets(2, vipFactory);
                        default -> System.out.println("Invalid choice. Regular ticker is ordered.");
                    }
                case 3:
                    System.out.print("Enter the number of tickets to book with Insurance: ");
                    int numTicketsWithInsurance = scanner.nextInt();
                    ticketSystem.bookTicketsWithInsurance(numTicketsWithInsurance);
                    System.out.print("Regular or VIP tickets?");
                    System.out.print("1. VIP");
                    System.out.print("2. Regular");
                    System.out.println("Enter your choice: ");
                    int Factory1Choice = scanner.nextInt();
                    switch (Factory1Choice) {
                        case 1 -> ticketSystem.bookTickets(regularTicket, 5);
                        case 2 ->  ticketSystem.bookTickets(2, vipFactory);
                        default -> System.out.println("Invalid choice. Regular ticker is ordered.");
                    }
                    break;
              case 4:
                    System.out.print("Enter the number of tickets to book with Seat Selection: ");
                    int numTicketsWithSeatSelection = scanner.nextInt();
                    ticketSystem.bookTicketsWithSeatSelection(numTicketsWithSeatSelection);
                  System.out.print("Regular or VIP tickets?");
                  System.out.print("1. VIP");
                  System.out.print("2. Regular");
                  System.out.println("Enter your choice: ");
                  int Factory2Choice = scanner.nextInt();
                  switch (Factory2Choice) {
                      case 1 -> ticketSystem.bookTickets(regularTicket, 5);
                      case 2 ->  ticketSystem.bookTickets(2, vipFactory);
                      default -> System.out.println("Invalid choice. Regular ticker is ordered.");
                  }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
        scanner.close();
    }
}
