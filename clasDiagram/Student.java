import java.util.ArrayList;

public class Student extends Person {

    private String id_student = "";
    private float average = 0f;
    public ArrayList <Seminar> seminars_estudent = new ArrayList<>();

    public Student(String name, String phone, String email, String id_student, float average) {
        super(name, phone, email);
        this.id_student = id_student; 
        this.average = average;
    }

    public void elegibletoEnroll(){
        System.out.println("\nStudent\n Name: "+ super.name + "\n ID: "+ this.id_student+ "\n Average: "+ this.average);
    }

    public void getSeminarsTaken() {
        System.out.println("\nSeminarios inscritos");
        for(Seminar a : seminars_estudent){
            System.out.println(a.toString());
        }
    } 
    public void addSeminar(Seminar seminar){
    seminars_estudent.add(seminar);
    }
}
