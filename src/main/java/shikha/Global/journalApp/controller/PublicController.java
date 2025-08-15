package shikha.Global.journalApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shikha.Global.journalApp.Entity.User;
import shikha.Global.journalApp.services.UserServices;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    UserServices userService;

    @GetMapping("/Health-check")
    public String healthCheck(){
        return "Ok";
    }
    @PostMapping("/create-user")
    public void createUser(@RequestBody User user){

        userService.saveNewUser(user);
    }
}
