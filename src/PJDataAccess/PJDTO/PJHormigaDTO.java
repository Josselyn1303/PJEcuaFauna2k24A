package PJDataAccess.PJDTO;

import java.util.Date; 

public class PJHormigaDTO {
    // HormigaDTO.java   
    private int idHormiga;  
    private String tipoHormiga;  
    private int idSexo;  
    private int idProvincia;  
    private int idGenoAlimento;  
    private int idIngestaNativa;  
    private char estado;  
    private Date fechaCreacion;  

    public PJHormigaDTO(){}
    // Constructor, getters y setters  
    public PJHormigaDTO(String tipoHormiga, int idSexo, int idProvincia, int idGenoAlimento, int idIngestaNativa) {  
        this.tipoHormiga = tipoHormiga;  
        this.idSexo = idSexo;  
        this.idProvincia = idProvincia;  
        this.idGenoAlimento = idGenoAlimento;  
        this.idIngestaNativa = idIngestaNativa;  
        this.estado = 'A'; // Estado por defecto  
        this.fechaCreacion = new Date(); // Fecha actual por defecto  
    }

    public Integer getIdHormiga() {
        return idHormiga;
    }

    public void setIdHormiga(int idHormiga) {
        this.idHormiga = idHormiga;
    }

    public String getTipoHormiga() {
        return tipoHormiga;
    }

    public void setTipoHormiga(String tipoHormiga) {
        this.tipoHormiga = tipoHormiga;
    }

    public int getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(int idSexo) {
        this.idSexo = idSexo;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public int getIdGenoAlimento() {
        return idGenoAlimento;
    }

    public void setIdGenoAlimento(int idGenoAlimento) {
        this.idGenoAlimento = idGenoAlimento;
    }

    public int getIdIngestaNativa() {
        return idIngestaNativa;
    }

    public void setIdIngestaNativa(int idIngestaNativa) {
        this.idIngestaNativa = idIngestaNativa;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }  
 
}

