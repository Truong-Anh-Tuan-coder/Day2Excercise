package excercise;

public class VehicleDemo {
    public static void main(String[] args){
        Vehicle car = new Car();
        Vehicle bike = new Bike();
        car.move();
        bike.move();
        car.totalVehicle();
    }
}
