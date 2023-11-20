import java.util.ArrayList;
import java.util.List;
public class TicketBookingSystem implements Subject{
    private static TicketBookingSystem instance;
    private int availableTickets = 10;
    private final List<Observer> observers = new ArrayList<>();
    private TicketPriceStrategy priceStrategy;

    // Private constructor to prevent instantiation from outside
    private TicketBookingSystem() {
        priceStrategy = new RegularPriceStrategy();
    }

    // Method to get the instance of the TicketBookingSystem
    public static synchronized TicketBookingSystem getInstance() {
        if (instance == null) {
            instance = new TicketBookingSystem();
        }
        return instance;
    }
    public void setPriceStrategy(TicketPriceStrategy strategy) {
        this.priceStrategy = strategy;
    }

    // Method to book tickets
    public synchronized void bookTickets(Ticket regularTicket, int numTickets) {
        if (availableTickets >= numTickets) {
            double totalPrice = priceStrategy.calculatePrice(numTickets);
            availableTickets -= numTickets;
            System.out.println(numTickets + " tickets booked successfully! Total Price: $" + totalPrice);
        } else {
            System.out.println("Sorry, insufficient tickets available.");
        }
    }

    // Method to get the number of available tickets
    public synchronized int getAvailableTickets() {
        return availableTickets;
    }
        public void bookTicketsWithInsurance(int numTickets) {
            Ticket basicTicket = new BasicTicket(10.0); // Создание базового билета
            Ticket ticketWithInsurance = new InsuranceDecorator(basicTicket); // Добавление страховки

            bookTicketInternal(ticketWithInsurance, numTickets);
        }

        public void bookTicketsWithSeatSelection(int numTickets) {
            Ticket basicTicket = new BasicTicket(10.0); // Создание базового билета
            Ticket ticketWithSeatSelection = new SeatSelectionDecorator(basicTicket); // Добавление выбора места

            bookTicketInternal(ticketWithSeatSelection, numTickets);
        }

        private synchronized void bookTicketInternal(Ticket ticket, int numTickets) {
            if (availableTickets >= numTickets) {
                double totalPrice = ticket.getPrice() * numTickets;
                availableTickets -= numTickets;
                System.out.println(numTickets + " tickets booked successfully! Total Price: $" + totalPrice);
            } else {
                System.out.println("Sorry, insufficient tickets available.");
            }
        }
        public void bookTicketsWithThirdPartySystem(int numTickets) {
            ThirdPartyTicketSystem thirdPartySystem = new RealThirdPartyTicketSystem();
            Ticket adapter = new ThirdPartyTicketSystemAdapter(thirdPartySystem);
            bookTicketInternal(adapter, numTickets);
        }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(availableTickets);
        }
    }
    public void bookTickets(int numTickets, TicketFactory factory) {
        Ticket ticket = factory.createTicket();
        bookTicketInternal(ticket, numTickets);
    }
    }

