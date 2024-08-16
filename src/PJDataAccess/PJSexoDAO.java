package PJDataAccess;

import PJDataAccess.PJDTO.PJSexoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PJSexoDAO extends PJDataHelper implements PJIDAO<PJSexoDTO> {
    private Connection connection;

    public PJSexoDAO() throws Exception {
        this.connection = openConnection();
    }

    @Override
    public boolean PJCreate(PJSexoDTO sexo) throws Exception {
        String sql = "INSERT INTO PJSexo (Nombre, Estado) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, sexo.getNombre());
            pstmt.setString(2, sexo.getEstado());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new Exception("Error al agregar el sexo", e);
        }
    }

    @Override
    public List<PJSexoDTO> PJReadAll() throws Exception {
        List<PJSexoDTO> sexos = new ArrayList<>();
        String sql = "SELECT * FROM PJSexo";
        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                PJSexoDTO sexo = new PJSexoDTO();
                sexo.setIdSexo(rs.getInt("IdSexo"));
                sexo.setNombre(rs.getString("Nombre"));
                sexo.setEstado(rs.getString("Estado"));
                sexos.add(sexo);
            }
        } catch (SQLException e) {
            throw new Exception("Error al obtener la lista de sexos", e);
        }
        return sexos;
    }

    @Override
    public boolean PJUpdate(PJSexoDTO sexo) throws Exception {
        String sql = "UPDATE PJSexo SET Nombre = ?, Estado = ? WHERE IdSexo = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, sexo.getNombre());
            pstmt.setString(2, sexo.getEstado());
            pstmt.setInt(3, sexo.getIdSexo());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new Exception("Error al actualizar el sexo", e);
        }
    }

    @Override
    public boolean PJDelete(int id) throws Exception {
        String sql = "DELETE FROM PJSexo WHERE IdSexo = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new Exception("Error al eliminar el sexo", e);
        }
    }

    @Override
    public PJSexoDTO PJReadBy(Integer id) throws Exception {
        PJSexoDTO sexo = null;
        String sql = "SELECT * FROM PJSexo WHERE IdSexo = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    sexo = new PJSexoDTO();
                    sexo.setIdSexo(rs.getInt("IdSexo"));
                    sexo.setNombre(rs.getString("Nombre"));
                    sexo.setEstado(rs.getString("Estado"));
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al obtener el sexo por ID", e);
        }
        return sexo;
    }
}
