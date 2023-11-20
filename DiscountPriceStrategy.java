public class DiscountPriceStrategy implements TicketPriceStrategy {
    private static final double DISCOUNTED_PRICE = 8.0;

    @Override
    public double calculatePrice(int numTickets) {
        return DISCOUNTED_PRICE * numTickets;
    }
}