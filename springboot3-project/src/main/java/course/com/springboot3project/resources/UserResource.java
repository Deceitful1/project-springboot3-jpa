package course.com.springboot3project.resources;

import course.com.springboot3project.entities.User;
import course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj)
    {
        obj = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        userService.delete(id);
        return ResponseEntity.noContent().build();
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
