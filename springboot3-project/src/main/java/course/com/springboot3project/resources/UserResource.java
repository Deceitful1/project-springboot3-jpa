package course.com.springboot3project.resources;

import course.com.springboot3project.entities.User;
import course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource
{
    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<List<User>> findAll()
    {
        List<User> u = userService.findAll();
        return ResponseEntity.ok().body(u);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id)
    {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

/*
    @GetMapping(value = "/{name}")
    public ResponseEntity<User> findByName(@PathVariable String name)
    {
        User user = userService.findByName(name);
        return ResponseEntity.ok().body(user);
    }
*/

}
