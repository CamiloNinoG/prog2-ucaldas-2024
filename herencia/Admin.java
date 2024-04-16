public class Admin extends Person {

    private String deparment = "";
    private String admin_id = "";

    public Admin(String user_name, String last_name, String document, String gender, String deparment, String admin_id) {
        super(user_name, last_name, document, gender);
        this.admin_id = admin_id;
        this.deparment = deparment;
    }

    public String getDeparment() {
        return deparment;
    }

    public String getAdmin_id() {
        return admin_id;
    } 

    @Override
    public String toString(){
        return super.toString() + "\n Departamento: "+ deparment + "\n Amdin ID: " + admin_id;
    }
}
