class Book extends Product {
    private String author;

    public Book(String name, double price, String author) {
        super(name, price);
        this.author = author;
    }

    @Override
    public void applyDiscount(double discountPercentage) {
        price -= (price * discountPercentage / 100);
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Author: " + author;
    }
}