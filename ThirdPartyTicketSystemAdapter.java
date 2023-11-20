public class ThirdPartyTicketSystemAdapter implements Ticket {
    private ThirdPartyTicketSystem thirdPartySystem;

    public ThirdPartyTicketSystemAdapter(ThirdPartyTicketSystem thirdPartySystem) {
        this.thirdPartySystem = thirdPartySystem;
    }

    @Override
    public void book() {
        System.out.println("Booking through third-party system...");
        // Адаптер вызывает метод orderTickets() сторонней системы
        thirdPartySystem.orderTickets(1);
        System.out.println("Tickets booked through third-party system!");
    }

    @Override
    public double getPrice() {
        return 15.0;
    }
}