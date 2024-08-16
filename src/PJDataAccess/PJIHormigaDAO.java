package PJDataAccess;

import PJDataAccess.PJDTO.PJHormigaDTO;

import java.util.List;   

public interface PJIHormigaDAO {  
    void agregarHormiga(PJHormigaDTO hormiga);  
    void eliminarHormiga(int idHormiga);  
    void actualizarHormiga(PJHormigaDTO hormiga);  
    PJHormigaDTO obtenerHormiga(int idHormiga);  
    List<PJHormigaDTO> listarHormigas();  
}  

