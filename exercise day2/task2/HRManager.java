public class HRManager extends Employees{
    public HRManager(){
        this.salary = 70000;
        this.title = "Manager";
    }

    @Override
    public void work() {
        System.out.println("Managing employees");
        System.out.println(this.title +" salary: " + this.salary);

        System.out.println();
        System.out.println();
    }
    public void addEmployee(){
        System.out.println("Adding new employee!");
    }
}
