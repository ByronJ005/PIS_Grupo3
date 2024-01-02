package modelo;

/**
 *
 * @author Asus
 */
public class Materia {
    private String nombreAsignatura;
    private Boolean tieneCadena;

    public Materia() {
    }

    public Materia(String nombreAsignatura, Boolean tieneCadena) {
        this.nombreAsignatura = nombreAsignatura;
        this.tieneCadena = tieneCadena;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public Boolean getTieneCadena() {
        return tieneCadena;
    }

    public void setTieneCadena(Boolean tieneCadena) {
        this.tieneCadena = tieneCadena;
    }
    
    
}
