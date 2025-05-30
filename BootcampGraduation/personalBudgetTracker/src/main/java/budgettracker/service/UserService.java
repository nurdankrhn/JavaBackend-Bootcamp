package budgettracker.service;

import budgettracker.model.User;
import budgettracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Constructor Injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Save a user entity
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Find a user by username
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Find a user by id
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    // Add more methods as needed
}
