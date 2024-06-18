public class Bicycle extends Vehicle{
    int speed = 20;

    @Override
    public void speedUp(){
        System.out.println("Bicycle speed: " + speed);
    }
}
