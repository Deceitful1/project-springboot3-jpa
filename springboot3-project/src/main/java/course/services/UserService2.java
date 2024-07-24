package course.services;

import course.com.springboot3project.entities.User;
import course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService2
{
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }
    public User findById(Long id)
    {
        Optional<User> user2 = userRepository.findById(id);
        return user2.orElse(null);
    }

    public User insert(User user)
    {
        User user1 = userRepository.save(user);
        return user1;
    }


}
