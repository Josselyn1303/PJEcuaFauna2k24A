package PJBusinessLogic;

import PJDataAccess.PJSexoDAO;
import PJDataAccess.PJDTO.PJSexoDTO;
import java.util.List;

public class PJSexoBL {
    private PJSexoDAO sexoDAO;

    public PJSexoBL() throws Exception {
        this.sexoDAO = new PJSexoDAO();
    }

    public void addSexo(PJSexoDTO sexo) {
        try {
            sexoDAO.PJCreate(sexo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<PJSexoDTO> getAllSexos() {
        try {
            return sexoDAO.PJReadAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateSexo(PJSexoDTO sexo) {
        try {
            sexoDAO.PJUpdate(sexo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSexo(int id) {
        try {
            sexoDAO.PJDelete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PJSexoDTO getSexoById(int id) {
        try {
            return sexoDAO.PJReadBy(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

