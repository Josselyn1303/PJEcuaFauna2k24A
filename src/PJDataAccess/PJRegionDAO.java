package PJDataAccess;

import PJDataAccess.PJDTO.PJRegionDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PJRegionDAO extends PJDataHelper implements PJIDAO<PJRegionDTO>{
    private Connection connection;

    public PJRegionDAO() throws Exception {
        this.connection = openConnection();
    }

    @Override
    public boolean PJCreate(PJRegionDTO region) throws Exception {
        String sql = "INSERT INTO PJRegion (NombreRegion, IdPJPais, Estado) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, region.getNombreRegion());
            pstmt.setInt(2, region.getIdPJPais());
            pstmt.setString(3, region.getEstado());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new Exception("Error al agregar la región", e);
        }
    }

    @Override
    public List<PJRegionDTO> PJReadAll() throws Exception {
        List<PJRegionDTO> regiones = new ArrayList<>();
        String sql = "SELECT * FROM PJRegion";
        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                PJRegionDTO region = new PJRegionDTO();
                region.setIdPJRegion(rs.getInt("IdPJRegion"));
                region.setNombreRegion(rs.getString("NombreRegion"));
                region.setIdPJPais(rs.getInt("IdPJPais"));
                region.setEstado(rs.getString("Estado"));
                regiones.add(region);
            }
        } catch (SQLException e) {
            throw new Exception("Error al obtener la lista de regiones", e);
        }
        return regiones;
    }

    @Override
    public boolean PJUpdate(PJRegionDTO region) throws Exception {
        String sql = "UPDATE PJRegion SET NombreRegion = ?, IdPJPais = ?, Estado = ? WHERE IdPJRegion = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, region.getNombreRegion());
            pstmt.setInt(2, region.getIdPJPais());
            pstmt.setString(3, region.getEstado());
            pstmt.setInt(4, region.getIdPJRegion());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new Exception("Error al actualizar la región", e);
        }
    }

    @Override
    public boolean PJDelete(int id) throws Exception {
        String sql = "DELETE FROM PJRegion WHERE IdPJRegion = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new Exception("Error al eliminar la región", e);
        }
    }

    @Override
    public PJRegionDTO PJReadBy(Integer id) throws Exception {
        PJRegionDTO region = null;
        String sql = "SELECT * FROM PJRegion WHERE IdPJRegion = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    region = new PJRegionDTO();
                    region.setIdPJRegion(rs.getInt("IdPJRegion"));
                    region.setNombreRegion(rs.getString("NombreRegion"));
                    region.setIdPJPais(rs.getInt("IdPJPais"));
                    region.setEstado(rs.getString("Estado"));
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al obtener la región por ID", e);
        }
        return region;
    }
    
    public List<String> obtenerRegiones() throws Exception {
        List<String> regiones = new ArrayList<>();
        String query = "SELECT NombreRegion FROM PJRegion";
        
        try (Connection conn = PJDataHelper.openConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                regiones.add(rs.getString("NombreRegion"));
            }
        }
        return regiones;
    }
}

