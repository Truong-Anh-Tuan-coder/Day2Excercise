package excercise;

public class ShoppingApp {
    public static void main(String[] args){
        //constructor of cart will insert sample data into list.
        Cart cart = new Cart();
        cart.getProduct();
        cart.totalPrice();

        cart.addToCart( new Product(5,"Product 5", 1000));

        cart.getProduct();
        cart.totalPrice();
    }
}
