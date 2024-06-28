package excercise;

public abstract class Vehicle {
    //declare field for abstract class section
//    final   int      id;
    static  int      vehicleCount;
    String          name;
    //constructor section
    public Vehicle(){
        vehicleCount++;
    }

    //method move of vehicle class.
    abstract void move();
    public void totalVehicle(){
        System.out.println(vehicleCount);
    }
}
