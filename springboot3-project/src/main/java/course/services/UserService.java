package course.services;

import course.com.springboot3project.entities.User;
import course.repositories.UserRepository;
import course.services.exceptions.DatabaseException;
import course.services.exceptions.ResourceNotFoundException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
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

    public void delete(Long id)
    {
        try {
            userRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e)
        {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e)
        {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update (Long id, User obj)
    {
        User entity = userRepository.getReferenceById(id);
        updateData(entity, obj);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User obj)
    {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());

    }


}
