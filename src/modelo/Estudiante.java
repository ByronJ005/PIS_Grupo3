package modelo;

/**
 *
 * @author Asus
 */
public class Estudiante extends Persona{
    private Boolean gratuidad;

    public Estudiante() {
    }

    public Estudiante(Boolean gratuidad, String nombres, String apellidos, String cedula, String nacionalidad, Integer edad, String telefono) {
        super(nombres, apellidos, cedula, nacionalidad, edad, telefono);
        this.gratuidad = gratuidad;
    }

    public Boolean getGratuidad() {
        return gratuidad;
    }

    public void setGratuidad(Boolean gratuidad) {
        this.gratuidad = gratuidad;
    }
    
    public Boolean comparar(Estudiante e, Integer type, String field, Integer aux){
        if (type == 0)
            type = 1;
        else 
            type = 0;
        return comparar(e, type, field);
    }
    
    public Boolean comparar(Estudiante e, Integer type, String field){
        switch (type) {
            case 1:
                if (field.equalsIgnoreCase("id"))
                    return getId().intValue() > e.getId().intValue();
                else if (field.equalsIgnoreCase("nombre"))
                    return getNombres().compareToIgnoreCase(e.getNombres()) > 0;
                else if (field.equalsIgnoreCase("apellidos"))
                    return getApellidos().compareToIgnoreCase(e.getApellidos()) > 0;
                else if (field.equalsIgnoreCase("cedula"))
                    return getCedula().compareToIgnoreCase(e.getCedula()) > 0;
                else if (field.equalsIgnoreCase("edad"))
                    return getEdad().intValue() > e.getEdad().intValue();
                else if (field.equalsIgnoreCase("nacionalidad"))
                    return getNacionalidad().compareToIgnoreCase(e.getNacionalidad()) > 0;
                else if (field.equalsIgnoreCase("gratuidad"))
                    return getGratuidad().compareTo(e.getGratuidad()) > 0;
            case 0:
                if (field.equalsIgnoreCase("id"))
                    return getId().intValue() < e.getId().intValue();
                else if (field.equalsIgnoreCase("nombre"))
                    return getNombres().compareToIgnoreCase(e.getNombres()) < 0;
                else if (field.equalsIgnoreCase("apellidos"))
                    return getApellidos().compareToIgnoreCase(e.getApellidos()) < 0;
                else if (field.equalsIgnoreCase("cedula"))
                    return getCedula().compareToIgnoreCase(e.getCedula()) < 0;
                else if (field.equalsIgnoreCase("edad"))
                    return getEdad().intValue() < e.getEdad().intValue();
                else if (field.equalsIgnoreCase("nacionalidad"))
                    return getNacionalidad().compareToIgnoreCase(e.getNacionalidad()) < 0;
                else if (field.equalsIgnoreCase("gratuidad"))
                    return getGratuidad().compareTo(e.getGratuidad()) < 0;
            default:
                return false;
        }
    }
    
}
