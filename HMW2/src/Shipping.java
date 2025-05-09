class Shipping {
    private Order order;

    public Shipping(Order order) {
        this.order = order;
    }

    public void updateShippingStatus(String newStatus) {
        order.changeStatus(newStatus);
    }

    public String trackOrder() {
        return "Order Status: " + order.getOrderDetails();
    }
}
