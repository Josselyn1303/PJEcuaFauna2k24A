package PJDataAccess.PJDTO;

public class PJProvinciaDTO {
    private int idProvincia;  
    private String nombre;  

    // Constructor  
    public PJProvinciaDTO(String nombre) {  
        this.nombre = nombre;  
    }  

    // Getters y Setters  
    public Integer getIdProvincia() {  
        return idProvincia;  
    }  

    public void setIdProvincia(int idProvincia) {  
        this.idProvincia = idProvincia;  
    }  

    public String getNombre() {  
        return nombre;  
    }  

    public void setNombre(String nombre) {  
        this.nombre = nombre;  
    }  
}  

