public class Seminar {
    
    private String name_course = "";
    private int hours = 0;
    private Professor professor_charge;

    public Seminar(String name_course, int hours, Professor professor_charge) {
        this.name_course = name_course;
        this.hours = hours;
        this.professor_charge = professor_charge;
    }

    public String getName_seminars() {
        return name_course;
    }

    public void setName_seminars(String name_course) {
        this.name_course = name_course;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public Professor getProfessor_charge() {
        return professor_charge;
    }

    public void setProfessor_charge(Professor professor_charge) {
        this.professor_charge = professor_charge;
    }

    public String toString(){
        return "\nName Course: " + this.name_course + "\nHours: " + this.hours + professor_charge.toString();
    }
}
