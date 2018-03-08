public class StockAndCart {

    private Products stock;
    private Products cart;

    public StockAndCart(Products stock, Products cart) {
        this.stock = stock;
        this.cart = cart;
    }

    public Products getStock() {
        return stock;
    }

    public Products getCart() {
        return cart;
    }
}
