package homework.controller;


import homework.dao.UserDao;
import homework.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao dao;

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users = StreamSupport //
                .stream(dao.findAll().spliterator(), false) //
                .collect(Collectors.toList());
        return users;
    }

    @GetMapping("/user/{id}")
    Optional<User> one(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping("/insertUser")
    public String insertUser(@RequestBody List<User> users) {
        dao.saveAll(users);
        return users.size() + " users were injected";
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        dao.deleteById(id);
        return "User with id " + id + " deleted";
    }

    @PutMapping("/modifyUser/{id}")
    User replaceEmployee(@RequestBody User newUser, @PathVariable int id) {

        return dao.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    return dao.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return dao.save(newUser);
                });
    }
}
