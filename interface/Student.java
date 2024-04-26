public class Student {
    private String student_name = "";
    private String student_code = "";
    
    public Student(String student_name, String student_code) {
        this.student_name = student_name;
        this.student_code = student_code;
    }

    public String getStudent_name() {
        return this.student_name;
    }

    public String getStudent_code() {
        return this.student_code;
    }   

    public String toString(){
        return "Name student: " + this.student_name + " - Code: "+this.student_code;
    }
}
