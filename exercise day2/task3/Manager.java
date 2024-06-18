public class Manager extends Employees{
    public Manager(){
        this.name = "Avril Aroldo";
        this.salary = 12000;
        this.performance = "Excellent";
        this.title = "Manager";
    }
    public void getSalary(){
        System.out.println("Manager's Bonus: "+ this.salary);
    }
    public void getPerformance(){
        System.out.println("Performance report for "+ this.title +" " + this.name + ": " + this.performance);
    }
    public void getRole(){
        System.out.println(this.title + " " + this.name +" is managing a project");
    }
}
