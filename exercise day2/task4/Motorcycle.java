public class Motorcycle extends Vehicle{
    public Motorcycle(){
        this.model = "Warrior200";
        this.type = "Motorcycle";
        this.fuelEfficiency= 2.1;
        this.distance= 4.41;
        this.maxSpeed= 80.0;

    }
    public Motorcycle(String model,double fuelEfficiency, double distance, double maxSpeed, String type) {

        this.model = model;
        this.type = type;
        this.fuelEfficiency = fuelEfficiency;
        this.distance = distance;
        this.maxSpeed = maxSpeed;
    }
}
