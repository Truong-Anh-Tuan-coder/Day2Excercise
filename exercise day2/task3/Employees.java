import java.math.BigDecimal;

public class Employees {
    String name;
    String Address;
    int salary = 40000;
    String title = "Employee";
    String performance;

    public void work(){
        System.out.println("Working as an employee!");
        System.out.println(this.title +" salary: " + this.salary);
    }
    public void getSalary(){

    }
}
