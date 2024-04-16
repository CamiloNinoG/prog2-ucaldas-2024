public class Main {

    public static void main(String[] args) {
        //instants
        Student student = new Student("Sara", "Lopez", "489099", "F", "000012345");
        Person person = new Person("Jose", "Cell", "78988", "M");
        Admin admin = new Admin("jorge", "rosa", "22233444", "M", "ING", "0004898");

        System.out.println(admin.toString());
        System.out.println(student.toString());
        System.out.println(person.toString());
    }

}