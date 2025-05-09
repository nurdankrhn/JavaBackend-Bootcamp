public class Main {
    public static void main(String[] args) {
        // creating products
        ElectronicProduct phone = new ElectronicProduct("iPhone 13", 12000, "Apple");
        Book book = new Book("Java Programming", 100, "Smart Lady");
        Clothing tshirt = new Clothing("T-Shirt", 150, "S");

        // creating order
        Order order1 = new Order("Nurdan Krhn", "İstanbul, Türkiye");
        order1.addProduct(phone);
        order1.addProduct(book);
        order1.addProduct(tshirt);

        // apply discount
        order1.applyDiscountToAll(10);

        // getting details of the order
        System.out.println(order1.getOrderDetails());

        // shipping management
        Shipping shipping = new Shipping(order1);
        System.out.println(shipping.trackOrder());  // state:preparing
        shipping.updateShippingStatus("On the way...");
        System.out.println(shipping.trackOrder());  // state: on the way
        shipping.updateShippingStatus("Delivered:)(:");
        System.out.println(shipping.trackOrder());  // stated: delivered
    }
}