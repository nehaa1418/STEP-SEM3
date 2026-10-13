public class ShoppingCart {
    private double[] prices;
    private int itemCount;
    private final int cartId;

    public ShoppingCart(int cartId, int maxItems) {
        this.cartId = cartId;
        prices = new double[maxItems];
        itemCount = 0;
    }

    public void addItem(double price) {
        if (price > 0 && itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        } else {
            System.out.println("Invalid price or cart is full.");
        }
    }

    public double getTotal() {
        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }

        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(101, 5);

        cart.addItem(250.50);
        cart.addItem(100);
        cart.addItem(75.50);

        System.out.println("Number of items: " + cart.getItemCount());
        System.out.println("Total price: Rs. " + cart.getTotal());
    }
}