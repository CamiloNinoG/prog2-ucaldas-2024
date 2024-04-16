import java.util.ArrayList;

public class Teacher extends Person {

    private String teacher_id = "";
    private ArrayList <Subject> subject_teacher = new ArrayList<>(); 
    private ArrayList <String> classroms = new ArrayList<>(); 

    public Teacher(String user_name, String last_name, String document, String gender, String teacher_id) {
        super(user_name, last_name, document, gender);
        this.teacher_id = teacher_id;
    }

    public void addCourse(String name_course, String hours_course){
        subject_teacher.add(new Subject(name_course, hours_course));
    }

    public void hoursCours(String name_course) {
        for(Subject s: subject_teacher){
            if(s. getName_curse().equals(name_course)){
                System.out.println("Horas a la semana del curso "+ s.getName_curse()+": "+s.getHours_week());
                break;
            }
        }
    }

    public void listClassrom(){
        for(String g: classroms){
            System.out.println(g);
        }
    }

    public void listSubject(){
        for(Subject g: subject_teacher){
            System.out.println(g);
        }
    }

    public String toString() {
        return super.toString() + "\n Teacher ID: " + teacher_id;
    }
    
}
