package PJDataAccess.PJDTO;

public class PJSexoDTO {
    private Integer IdSexo;
    private String Nombre;
    private String Estado;
    private String FechaCrea;

    public PJSexoDTO(Integer IdSexo, String Nombre, String Estado, String FechaCrea){
        this.IdSexo = IdSexo;
        this.Nombre = Nombre;
        this.Estado = Estado;
        this.FechaCrea = FechaCrea;
    }

    public PJSexoDTO(){}

    public PJSexoDTO(String nombre){
        this.Nombre = nombre;
    }

    public Integer getIdSexo() {
        return IdSexo;
    }
    public void setIdSexo(Integer idSexo) {
        IdSexo = idSexo;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }
    public String getFechaCrea() {
        return FechaCrea;
    }
    public void setFechaCrea(String fechaCrea) {
        FechaCrea = fechaCrea;
    }
}
