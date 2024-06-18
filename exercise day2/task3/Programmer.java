public class Programmer extends Employees{
    public Programmer(){
        this.name = "yaron Gabriel";
        this.salary = 9120;
        this.performance = "Excellent";
        this.title = "Programmer";
    }
    public void getSalary(){
        System.out.println("Programmer's Bonus: "+ this.salary);
    }
    public void getPerformance(){
        System.out.println("Performance report for "+ this.title +" " + this.name + ": " + this.performance);
    }
    public void getRole(){
        System.out.println(this.title + " " + this.name +" is debugging code in Python");
    }
}
