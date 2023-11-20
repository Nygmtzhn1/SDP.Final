public class RegularTicketFactory implements TicketFactory {
    @Override
    public Ticket createTicket() {
        return new RegularTicket();
    }
}