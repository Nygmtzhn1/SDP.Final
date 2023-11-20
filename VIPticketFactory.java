public class VIPticketFactory implements TicketFactory {
    @Override
    public Ticket createTicket() {
        return new VIPTicket();
    }
}