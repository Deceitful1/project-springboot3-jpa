package course.services;

import course.com.springboot3project.entities.User;
import course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll()
    {
        return userRepository.findAll();
    }

    public User findById(Long id)
    {
        Optional<User> obj = userRepository.findById(id);
        return obj.get();
    }
    public User findByName(String name)
    {
        Optional<User> obj = Optional.ofNullable(userRepository.findByName(name));
        return obj.get();
    }
    public User insert(User user)
    {
        userRepository.save(user);
        return user;
    }




}
