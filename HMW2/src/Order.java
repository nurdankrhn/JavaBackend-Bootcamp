import java.util.ArrayList;

class Order {
    private String customerName;
    private String shippingAddress;
    private ArrayList<Product> products;
    private String status;

    public Order(String customerName, String shippingAddress) {
        this.customerName = customerName;
        this.shippingAddress = shippingAddress;
        this.products = new ArrayList<>();
        this.status = "Preparing...";
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void applyDiscountToAll(double discountPercentage) {
        for (Product product : products) {
            product.applyDiscount(discountPercentage);
        }
    }

    public String getOrderDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Name: ").append(customerName)
                .append(", Address: ").append(shippingAddress)
                .append(", Satete: ").append(status)
                .append("\nProducts: ");

        for (Product product : products) {
            details.append(product.getInfo()).append("; ");
        }

        return details.toString();
    }

    public void changeStatus(String newStatus) {
        status = newStatus;
    }
}