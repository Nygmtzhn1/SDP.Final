public class UserObserver implements Observer {
    @Override
    public void update(int availableTickets) {
        System.out.println("Notification: Available tickets updated. Available tickets now: " + availableTickets);
    }
}