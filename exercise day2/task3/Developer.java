public class Developer extends Employees{
    public Developer(){
        this.name = "Iver Dipali";
        this.salary = 7200;
        this.performance = "Good";
        this.title = "Developer";
    }
    public void getSalary(){
        System.out.println("Developer's Bonus: "+ this.salary);
    }
    public void getPerformance(){
        System.out.println("Performance report for "+ this.title +" " + this.name + ": " + this.performance);
    }
    public void getRole(){
        System.out.println(this.title + " " + this.name +" is writing code in Java");
    }
}
