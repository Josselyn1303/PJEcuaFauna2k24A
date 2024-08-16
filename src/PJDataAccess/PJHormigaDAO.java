package PJDataAccess;

import PJDataAccess.PJDTO.PJHormigaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PJHormigaDAO extends PJDataHelper implements PJIDAO<PJHormigaDTO>{
    private Connection connection;

    public PJHormigaDAO() throws Exception {
        this.connection = openConnection();
    }

    @Override
    public boolean PJCreate(PJHormigaDTO hormiga) throws Exception {
        String sql = "INSERT INTO PJHormiga (TipoHormiga, idSexo, idProvincia, idGenoAlimento, idIngestaNativa) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, hormiga.getTipoHormiga());
            pstmt.setInt(2, hormiga.getIdSexo());
            pstmt.setInt(3, hormiga.getIdProvincia());
            pstmt.setInt(4, hormiga.getIdGenoAlimento());
            pstmt.setInt(5, hormiga.getIdIngestaNativa());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new Exception("Error al agregar la hormiga", e);
        }
    }

    @Override
    public List<PJHormigaDTO> PJReadAll() throws Exception {
        List<PJHormigaDTO> hormigas = new ArrayList<>();
        String sql = "SELECT * FROM PJHormiga";
        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                PJHormigaDTO hormiga = new PJHormigaDTO();
                hormiga.setIdHormiga(rs.getInt("IdHormiga"));
                hormiga.setTipoHormiga(rs.getString("TipoHormiga"));
                hormiga.setIdSexo(rs.getInt("idSexo"));
                hormiga.setIdProvincia(rs.getInt("idProvincia"));
                hormiga.setIdGenoAlimento(rs.getInt("idGenoAlimento"));
                hormiga.setIdIngestaNativa(rs.getInt("idIngestaNativa"));
                hormigas.add(hormiga);
            }
        } catch (SQLException e) {
            throw new Exception("Error al obtener la lista de hormigas", e);
        }
        return hormigas;
    }

    @Override
    public boolean PJUpdate(PJHormigaDTO hormiga) throws Exception {
        String sql = "UPDATE PJHormiga SET TipoHormiga = ?, idSexo = ?, idProvincia = ?, idGenoAlimento = ?, idIngestaNativa = ? WHERE IdHormiga = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, hormiga.getTipoHormiga());
            pstmt.setInt(2, hormiga.getIdSexo());
            pstmt.setInt(3, hormiga.getIdProvincia());
            pstmt.setInt(4, hormiga.getIdGenoAlimento());
            pstmt.setInt(5, hormiga.getIdIngestaNativa());
            pstmt.setInt(6, hormiga.getIdHormiga());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new Exception("Error al actualizar la hormiga", e);
        }
    }

    @Override
    public boolean PJDelete(int id) throws Exception {
        String sql = "DELETE FROM PJHormiga WHERE IdHormiga = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new Exception("Error al eliminar la hormiga", e);
        }
    }

    @Override
    public PJHormigaDTO PJReadBy(Integer id) throws Exception {
        PJHormigaDTO hormiga = null;
        String sql = "SELECT * FROM PJHormiga WHERE IdHormiga = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    hormiga = new PJHormigaDTO();
                    hormiga.setIdHormiga(rs.getInt("IdHormiga"));
                    hormiga.setTipoHormiga(rs.getString("TipoHormiga"));
                    hormiga.setIdSexo(rs.getInt("idSexo"));
                    hormiga.setIdProvincia(rs.getInt("idProvincia"));
                    hormiga.setIdGenoAlimento(rs.getInt("idGenoAlimento"));
                    hormiga.setIdIngestaNativa(rs.getInt("idIngestaNativa"));
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al obtener la hormiga por ID", e);
        }
        return hormiga;
    }
}
