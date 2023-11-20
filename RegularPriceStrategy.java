public class RegularPriceStrategy implements TicketPriceStrategy {
    private static final double REGULAR_PRICE = 10.0;

    @Override
    public double calculatePrice(int numTickets) {
        return REGULAR_PRICE * numTickets;
    }
}