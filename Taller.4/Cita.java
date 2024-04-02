public class Cita {
    private Paciente paciente;
    private Medico medico;
    private Fecha fecha_cita;
    private String estado; // Estado de la cita (pendiente, confirmada, cancelada).

    public Cita(Paciente paciente, Medico medico, Fecha fecha_cita, String estado) {
        this.paciente = paciente;
        this.medico = medico;
        this.fecha_cita = fecha_cita;

        if (estado.equals("pendiente") || estado.equals("confirmada") || estado.equals("cancelada")) {
            this.estado = estado;
        } else {
            System.out.println("El estado de la cita debe ser: \n'confirmada'\n'pendiente'\n'cancelada'");
        }

    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public Fecha getFecha_cita() {
        return fecha_cita;
    }

    public String getEstado() {
        return estado;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setFecha_cita(Fecha fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
