import java.util.ArrayList;

public class Implement implements Contenedor{
    
    public ArrayList<Student> student_list = new ArrayList<>();

    //constructor add automaticly students
    public Implement(){
        this.student_list.add(new Student("Sara", "123"));
        this.student_list.add(new Student("Jose", "456"));
        this.student_list.add(new Student("Mario", "789"));
    }

    //implementacion funcion del contenedor
    public ArrayList<Student> getStudents_list() {
        return this.student_list;  
    }
}
