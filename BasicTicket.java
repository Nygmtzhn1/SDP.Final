public class BasicTicket implements Ticket {
    private double basePrice;

    public BasicTicket(double basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public void book() {
        System.out.println("Basic ticket booked!");
    }

    @Override
    public double getPrice() {
        return basePrice;
    }
}