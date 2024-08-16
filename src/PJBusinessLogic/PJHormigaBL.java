package PJBusinessLogic;

import PJDataAccess.PJHormigaDAO;  // Cambiado a la implementación correcta
import PJDataAccess.PJDTO.PJHormigaDTO;
import java.util.List;

public class PJHormigaBL {
    private PJHormigaDAO hormigaDAO;
    
    public PJHormigaBL() throws Exception {
        // Se utiliza la implementación concreta
        this.hormigaDAO = new PJHormigaDAO();
    }

    public void addHormiga(PJHormigaDTO hormiga) {
        try {
            hormigaDAO.PJCreate(hormiga);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<PJHormigaDTO> getAllHormigas() {
        try {
            return hormigaDAO.PJReadAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateHormiga(PJHormigaDTO hormiga) {
        try {
            hormigaDAO.PJUpdate(hormiga);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteHormiga(int id) {
        try {
            hormigaDAO.PJDelete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PJHormigaDTO getHormigaById(int id) {
        try {
            return hormigaDAO.PJReadBy(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
