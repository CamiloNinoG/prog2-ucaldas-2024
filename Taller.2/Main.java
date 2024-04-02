import java.time.LocalDate;

class Main {
    public static void main(String[] args) {
        RegistroBiblioteca registro = new RegistroBiblioteca();
        registro.menuBiblioteca();
        LocalDate fechaActual = LocalDate.now();
        System.out.println("fecha actual"+fechaActual.getYear()+ " "+  fechaActual.getMonthValue() + " " +fechaActual.getDayOfMonth());
    }
}