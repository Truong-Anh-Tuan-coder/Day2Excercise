public class Car extends Vehicle{
    int speed = 60;

    public Car(){
        this.model = "Virtus";
        this.type = "Car";
        this.fuelEfficiency= 2.355;
        this.distance= 14.419665;
        this.maxSpeed= 120.0;
    }
    @Override
    public void speedUp(){
        System.out.println("Car speed: " + speed);
    }
    public Car(String model,double fuelEfficiency, double distance, double maxSpeed, String type) {

        this.model = model;
        this.type = type;
        this.fuelEfficiency = fuelEfficiency;
        this.distance = distance;
        this.maxSpeed = maxSpeed;
    }

    public void speeddown(){
        System.out.println("Car speed: " + speed);
    }
}
