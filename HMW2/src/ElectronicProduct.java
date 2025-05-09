
class ElectronicProduct extends Product {
    private String brand;

    public ElectronicProduct(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }

    @Override
    public void applyDiscount(double discountPercentage) {
        price -= (price * discountPercentage / 100);
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Brand: " + brand;
    }
}
