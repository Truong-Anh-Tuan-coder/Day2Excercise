public class Truck extends Vehicle{
    public Truck(){
        this.model = "Tatra 810 4x4 ";
        this.type = "Truck";
        this.fuelEfficiency= 8.075659532105526;
        this.distance= 65.50975012444003;
        this.maxSpeed= 80.0;
    }
    public Truck(String model,double fuelEfficiency, double distance, double maxSpeed, String type){

        this.model = model;
        this.type = type;
        this.fuelEfficiency= fuelEfficiency;
        this.distance= distance;
        this.maxSpeed= maxSpeed;
    }
}
