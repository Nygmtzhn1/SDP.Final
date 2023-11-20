public class RealThirdPartyTicketSystem implements ThirdPartyTicketSystem {
    @Override
    public void orderTickets(int numTickets) {
        // Здесь будет реальная логика заказа билетов в сторонней системе
        System.out.println("Ordering " + numTickets + " tickets from the real third-party system...");
    }
}