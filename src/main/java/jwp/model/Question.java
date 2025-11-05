package jwp.model;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "QUESTIONS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question {
//    private final Long questionId;
//    private final String writer;
//    private final String title;
//    private final String contents;
//    private final Timestamp createdDate;
//    private final Integer countOfAnswer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questionId")
    private Long questionId;

    @Column(name = "writer", nullable = false, length = 30)
    private String writer;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "contents", nullable = false, length = 5000)
    private String contents;

    @Column(name = "createdDate", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "countOfAnswer")
    private Integer countOfAnswer;

    public Question(String writer, String title, String contents) {
        this(null, writer, title, contents, null, null);
    }

    public Question(Long questionId, String writer, String title, String contents, LocalDateTime createdDate, Integer countOfAnswer) {
        this.questionId = questionId;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.createdDate = createdDate;
        this.countOfAnswer = countOfAnswer;
    }

    @PrePersist
    protected void onCreate() {
        if (createdDate == null) {
            createdDate = LocalDateTime.now();
        }
        if (countOfAnswer == null) {
            countOfAnswer = 0;
        }
    }

    public Long getQuestionId() {
        return questionId;
    }

    public String getWriter() {
        return writer;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public Integer getCountOfAnswer() {
        return countOfAnswer;
    }
}