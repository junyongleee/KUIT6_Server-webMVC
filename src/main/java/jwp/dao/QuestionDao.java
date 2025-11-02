package jwp.dao;

import core.jdbc.JdbcTemplate;
import core.jdbc.KeyHolder;
import core.jdbc.PreparedStatementSetter;
import core.jdbc.RowMapper;
import jwp.model.Question;

import java.sql.SQLException;
import java.util.List;

public class QuestionDao {
    private final JdbcTemplate<Question> jdbcTemplate = new JdbcTemplate<>();
    private final RowMapper<Question> questionRowMapper = rs -> {
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

    public List<Question> findAll() throws SQLException {
        String sql = "SELECT questionId, writer, title, contents, createdDate, countOfAnswer FROM QUESTIONS ORDER BY createdDate DESC";
        return jdbcTemplate.query(sql, questionRowMapper);
    }

    public Question findByQuestionId(long questionId) throws SQLException {
        String sql = "SELECT questionId, writer, title, contents, createdDate, countOfAnswer FROM QUESTIONS WHERE questionId = ?";
        PreparedStatementSetter setter = pstmt -> pstmt.setLong(1, questionId);
        return jdbcTemplate.queryForObject(sql, setter, questionRowMapper);
    }

    public Question insert(Question question) throws SQLException {
        String sql = "INSERT INTO QUESTIONS (writer, title, contents, createdDate, countOfAnswer) VALUES (?, ?, ?, CURRENT_TIMESTAMP(), ?)";
        PreparedStatementSetter setter = pstmt -> {
            pstmt.setString(1, question.getWriter());
            pstmt.setString(2, question.getTitle());
            pstmt.setString(3, question.getContents());
            Integer countOfAnswer = question.getCountOfAnswer();
            if (countOfAnswer == null) {
                pstmt.setInt(4, 0);
            } else {
                pstmt.setInt(4, countOfAnswer);
            }
        };

        KeyHolder keyHolder = new KeyHolder();
        jdbcTemplate.update(sql, setter, keyHolder);
        long questionId = keyHolder.getId();
        if (questionId == 0L) {
            return null;
        }
        return findByQuestionId(questionId);
    }
}