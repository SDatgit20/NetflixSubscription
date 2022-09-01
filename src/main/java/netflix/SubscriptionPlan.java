package netflix;

//DO NOT CHANGE
public enum SubscriptionPlan {
    MONTHLY(300),
    YEARLY(1000);

    private final double price;

    SubscriptionPlan(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
