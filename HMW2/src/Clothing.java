class Clothing extends Product {
    private String size;

    public Clothing(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }

    @Override
    public void applyDiscount(double discountPercentage) {
        price -= (price * discountPercentage / 100);
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Size: " + size;
    }
}
