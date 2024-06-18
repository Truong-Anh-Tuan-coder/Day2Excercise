public class HelloWorld {
    /*
    Author: Truong Anh Tuan
    DateTime: 17/6/2024
    Function: print hello world
     */
    public static void main(String[] args){
        System.out.println("Hello World");

        int[] array = {1,2,3};
        for( var element : array){
            System.out.println(element + " " );
        }

        // OOP
//        Parent parent = new Child();
//        parent.show();
        // task1
        Vehicle vehicle = new Vehicle();
        Car car = new Car();
        Bicycle bicycle = new Bicycle();

        vehicle.speedUp();
        car.speedUp();
        bicycle.speedUp();
        System.out.println("------------------End task 1----------");
        System.out.println();
        System.out.println();

        //task 2
        Employees employees = new Employees();
        HRManager hrManager = new HRManager();

        employees.work();
        hrManager.work();
        hrManager.addEmployee();
        System.out.println("------------------End task 2----------");
        System.out.println();
        System.out.println();


        //task 3
        Manager manager = new Manager();
        Developer developer = new Developer();
        Programmer programmer = new Programmer();
        manager.getSalary();
        developer.getSalary();
        programmer.getSalary();

        manager.getPerformance();
        developer.getPerformance();
        programmer.getPerformance();

        manager.getRole();
        developer.getRole();
        programmer.getRole();
        System.out.println("------------------End task 3----------");
        System.out.println();
        System.out.println();

        // task 4
        Truck truck = new Truck();
        truck.getData();
        System.out.println();
        System.out.println();

        Car car1 = new Car();
        car1.getData();
        System.out.println();
        System.out.println();

        Motorcycle motorcycle = new Motorcycle();
        motorcycle.getData();
        System.out.println();
        System.out.println();
        System.out.println("------------------End task 4----------");


    }

}