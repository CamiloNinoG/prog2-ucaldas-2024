public class Student extends Person {

    private String student_id = "";

    //constructor super person class & student class
    public Student(String user_name, String last_name, String document, String gender, String student_id) {
        super(user_name, last_name, document, gender);
        this.student_id = student_id;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Student ID: " + student_id;
    }

    
}
