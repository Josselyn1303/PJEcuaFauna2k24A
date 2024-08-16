package PJDataAccess.PJDTO;

public class PJRegionDTO {
    private int idPJRegion;
    private String nombreRegion;
    private int idPJPais;
    private String estado;

    public PJRegionDTO(){}
    
    public PJRegionDTO(int idPJRegion, String nombreRegion, int idPJPais, String estado) {
        this.idPJRegion = idPJRegion;
        this.nombreRegion = nombreRegion;
        this.idPJPais = idPJPais;
        this.estado = estado;
    }
    public Integer getIdPJRegion() {
        return idPJRegion;
    }
    public void setIdPJRegion(int idPJRegion) {
        this.idPJRegion = idPJRegion;
    }
    public String getNombreRegion() {
        return nombreRegion;
    }
    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }
    public int getIdPJPais() {
        return idPJPais;
    }
    public void setIdPJPais(int idPJPais) {
        this.idPJPais = idPJPais;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}