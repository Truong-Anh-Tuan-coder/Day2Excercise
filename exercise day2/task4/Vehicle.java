public class Vehicle {
    String model;
    double fuelEfficiency;
    double distance;
    double maxSpeed;
    String typeFuel;
    int year;
    int speed;
    String type;

    public Vehicle(){

    }
    public void getData(){
        System.out.println(this.type+ " model: " + this.model);
        System.out.println("Fuel efficiency: " + this.fuelEfficiency + " mpg");
        System.out.println("Distance Traveled: " + this.distance + " miles");
        System.out.println("Max speed: " + this.maxSpeed + " mph");
    }
    public void speedUp(){
        System.out.println("Bicycle speed: " + speed);
    }
}


// Vehicle vehicle = new Car();