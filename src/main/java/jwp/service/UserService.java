package jwp.service;

import jwp.model.User;
import jwp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findByUserId(String userId) {
        return userRepository.findById(userId);
    }

    @Transactional
    public User updateUser(User updateUser) {
        User persistedUser = userRepository.findById(updateUser.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + updateUser.getUserId()));
        persistedUser.update(updateUser);
        return persistedUser;
    }

    public Optional<User> authenticate(String userId, String password) {
        return findByUserId(userId)
                .filter(user -> user.matchPassword(password));
    }
}