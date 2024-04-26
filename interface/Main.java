import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Implement inst_implementContenedor = new Implement();
        System.out.println(inst_implementContenedor.getStudents_list());
        ArrayList<Student> list_students = inst_implementContenedor.getStudents_list();
        
        for(Student a : list_students){
            System.out.println("Name: " + a.getStudent_name() + " - Code: "+ a.getStudent_code());
        }
        
    }
}