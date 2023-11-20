public class SeatSelectionDecorator implements Ticket {
    private Ticket ticket;
    private double seatSelectionPrice;

    public SeatSelectionDecorator(Ticket ticket) {
        this.ticket = ticket;
        this.seatSelectionPrice = 8.0; // Цена выбора места
    }

    @Override
    public void book() {
        ticket.book();
        System.out.println("Seat selection added!");
    }

    @Override
    public double getPrice() {
        return ticket.getPrice() + seatSelectionPrice;
    }
}