package modelo;

/**
 *
 * @author Asus
 */
public class Cuenta {
    private Integer id;
    private String correo;
    private String clave;
    private Boolean estado;

    public Cuenta() {
    }

    public Cuenta(Integer id, String correo, String clave, Boolean estado) {
        this.id = id;
        this.correo = correo;
        this.clave = clave;
        this.estado = estado;
    }
    
    public Boolean comparar(Cuenta c, String field, Integer type) {
        switch (type) {
            case 1:
                if (field.equalsIgnoreCase("id")) {
                    return getId().intValue() > c.getId().intValue();
                } 
                else if (field.equalsIgnoreCase("correo")) {
                    return  getCorreo().compareTo(c.getCorreo()) > 0;
                }
                else if (field.equalsIgnoreCase("clave")) {
                    return getClave().compareTo(c.getClave()) > 0;
                }
                else if (field.equalsIgnoreCase("estado")) {
                    return getEstado().compareTo(c.getEstado()) > 0;
                }
                
            case 0:
                if (field.equalsIgnoreCase("id")) {
                    return getId().intValue() < c.getId().intValue();
                } 
                else if (field.equalsIgnoreCase("correo")) {
                    return  getCorreo().compareTo(c.getCorreo()) < 0;
                }
                else if (field.equalsIgnoreCase("clave")) {
                    return getClave().compareTo(c.getClave()) < 0;
                }
                else if (field.equalsIgnoreCase("estado")) {
                    return getEstado().compareTo(c.getEstado()) < 0;
                }         
            default:
                return null;
        }
    }      

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
     
}
