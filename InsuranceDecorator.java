public class InsuranceDecorator implements Ticket {
    private Ticket ticket;
    private double insurancePrice;

    public InsuranceDecorator(Ticket ticket) {
        this.ticket = ticket;
        this.insurancePrice = 5.0; // Цена страховки
    }

    @Override
    public void book() {
        ticket.book();
        System.out.println("Insurance added!");
    }

    @Override
    public double getPrice() {
        return ticket.getPrice() + insurancePrice;
    }
}