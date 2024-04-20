public class Professor extends Person {
    
    private double salary = 0;

    public Professor(String name, String phone, String email, double salary) {
        super(name, phone, email);
        this.salary = salary;
    }
    public Professor(String name, String phone, String email) {
        super(name, phone, email);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
