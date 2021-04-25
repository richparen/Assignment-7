package kz.iitu.lms.controller;

import kz.iitu.lms.model.User;
import kz.iitu.lms.service.iUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private iUserService iUserService;


    @GetMapping("/users/{id}")
    public User get(@PathVariable Long id) {
        return iUserService.getById(id);
    }

    @PostMapping("/users/create")
    public User create(@RequestBody User o){
        return iUserService.create(o);
    }

    @PutMapping("/users/update")
    public User update(@RequestBody User o){
        return iUserService.update(o);
    }

    @DeleteMapping("/users/delete/{id}")
    public void deleteById(@PathVariable Long id) {iUserService.deleteUserById(id);
    }

    @GetMapping("/users/all")
    public List<User> getAll() {
        return iUserService.getAll();
    }

    @GetMapping("/users")
    public List<User> getAllByName(@Param(value = "name") String name) {
        return iUserService.getAllByName(name);
    }

}


