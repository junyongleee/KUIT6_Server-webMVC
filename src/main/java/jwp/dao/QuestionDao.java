package jwp.dao;
import core.jdbc.JdbcTemplate;
import core.jdbc.RowMapper;
import jwp.model.Question;

import java.sql.SQLException;
import java.util.List;

public class QuestionDao {
    private final JdbcTemplate<Question> jdbcTemplate = new JdbcTemplate<>();

    public List<Question> findAll() throws SQLException {
        String sql = "SELECT questionId, writer, title, contents, createdDate, countOfAnswer FROM QUESTIONS ORDER BY createdDate DESC";
        RowMapper<Question> rowMapper = rs -> {
            Integer countOfAnswer = rs.getInt("countOfAnswer");
            if (rs.wasNull()) {
                countOfAnswer = null;
            }
            return new Question(
                    rs.getLong("questionId"),
                    rs.getString("writer"),
                    rs.getString("title"),
                    rs.getString("contents"),
                    rs.getTimestamp("createdDate"),
                    countOfAnswer
            );
        };
        return jdbcTemplate.query(sql, rowMapper);
    }
}