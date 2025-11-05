package jwp.service;

import jwp.model.Question;
import jwp.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> findAll() {
        return questionRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"));
    }

    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    @Transactional
    public Question createQuestion(String writer, String title, String contents) {
        Question question = new Question(writer, title, contents);
        return questionRepository.save(question);
    }
}