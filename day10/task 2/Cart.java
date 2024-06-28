package excercise;

import java.util.ArrayList;

public class Cart {
    private static ArrayList<Product> products = new ArrayList<Product>();

    public Cart(){
        products.add(new Product(1,"Product 1" ,2000));
        products.add(new Product(2,"Product 2" ,2000));
        products.add(new Product(3,"Product 3" ,2000));
        products.add(new Product(4,"Product 4" ,2000));
    }
    void addToCart(Product aProduct) {
        products.add(aProduct);
    }

    void totalPrice() {
        double result = 0;
        for( var item: products) {

            result += item.price;
        }
        System.out.println("total price: " + result);
    }

    // get print list of product
    void getProduct() {
        if (!products.isEmpty()) {
            for (var item : products) {
                System.out.println(this.getProduct(item));
            }
        }
    }

    //to string product
    String getProduct(Product product){

        return "productID: " + product.productId +
                " product name: " + product.productName + " price: " +
                product.price + " storeName" + Product.storeName;
    }

}


