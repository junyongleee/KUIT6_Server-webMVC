//package jwp.dao;
//
////import core.jdbc.JdbcTemplate;
////import core.jdbc.PreparedStatementSetter;
////import core.jdbc.RowMapper;
//import core.jdbc.JdbcTemplate;
//import jwp.model.User;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//
//import javax.persistence.EntityManager;
//import java.sql.SQLException;
//import java.util.List;
//
//@Repository
//@RequiredArgsConstructor
//public class UserDao {
//
//    private final EntityManager em;
//
//    @Transactional
//    public void insert(User user) throws SQLException {
//        em.persist(user);
////        String sql = "INSERT INTO USERS VALUES(?, ?, ?, ?)";
////        PreparedStatementSetter pss = pstmt -> {
////            pstmt.setString(1, user.getUserId());
////            pstmt.setString(2, user.getPassword());
////            pstmt.setString(3, user.getName());
////            pstmt.setString(4, user.getEmail());
////        };
////        jdbcTemplate.update(sql, pss);
//    }
//
//    public void update(User user) throws SQLException {
//        em.merge(user);
////        String sql = "UPDATE USERS SET password =?, name =?, email =? WHERE userId =?";
////        PreparedStatementSetter pstmtSetter = pstmt -> {
////            pstmt.setString(1, user.getPassword());
////            pstmt.setString(2, user.getName());
////            pstmt.setString(3, user.getEmail());
////            pstmt.setString(4, user.getUserId());
////        };
////        jdbcTemplate.update(sql, pstmtSetter);
//    }
//
////    public void delete(User user) throws SQLException {
////        String sql = "DELETE FROM USERS WHERE userId =?";
////        PreparedStatementSetter pss = pstmt -> {
////            pstmt.setString(1, user.getUserId());
////        };
////        jdbcTemplate.update(sql, pss);
////    }
//
//    // TODO findAll, findByUserId
//    public List<User> findAll() throws SQLException {
//        em.createQuery("select u from User u", User.class).getResultList();
////        String sql = "SELECT * FROM USERS";
////        RowMapper rowMapper = rs -> new User(rs.getString("userId"),
////                rs.getString("password"),
////                rs.getString("name"),
////                rs.getString("email"));
////        return jdbcTemplate.query(sql, rowMapper);
//    }
//
//    public User findByUserId(String userId) throws SQLException {
//        em.find(User.class, userId);
//
////        String sql = "SELECT * FROM USERS WHERE userId=?";
////
////        PreparedStatementSetter pstmtSetter = pstmt -> {
////            pstmt.setString(1, userId);
////        };
////
////        RowMapper rowMapper = rs -> new User(rs.getString("userId"),
////                rs.getString("password"),
////                rs.getString("name"),
////                rs.getString("email")
////        );
////        return jdbcTemplate.queryForObject(sql, pstmtSetter, rowMapper);
//    }
//}
