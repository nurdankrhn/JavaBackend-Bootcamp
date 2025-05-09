abstract class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract void applyDiscount(double discountPercentage);

    public String getInfo() {
        return "Product Name: " + name + ", Price: " + price;
    }

    public double getPrice() {
        return price;
    }
}