package excercise;

public class Product {
    static final String storeName = "ABC Store";
    int     productId;
    String  productName;
    double  price;
    public Product(int productID, String productName, double price){
        this.productId= productID;
        this.productName = productName;
        this.price = price;
    }
}
