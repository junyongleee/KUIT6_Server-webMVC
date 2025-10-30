package core.jdbc;

import jwp.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate<T> {

    public void update(String sql, PreparedStatementSetter pstmtSetter) throws SQLException {
        try (Connection conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmtSetter.setParameters(pstmt);
            pstmt.executeUpdate();
        }
    }

    public List<T> query(String sql, RowMapper<T> rowMapper) throws SQLException {
        List<T> objects = new ArrayList<>();

        try (Connection conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();) {

            while (rs.next()) {
                T object = rowMapper.mapRow(rs);
                objects.add(object);
            }
        }
        return objects;
    }

    public T queryForObject(String sql, PreparedStatementSetter pstmtSetter, RowMapper<T> rowMapper) throws SQLException {
        ResultSet rs = null;
        T object = null;

        try(Connection conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);) {

            rs = pstmt.executeQuery();
            if (rs.next()) {
                object = rowMapper.mapRow(rs);
            }
        }

        return object;
    }

}
