package shikha.Global.journalApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import shikha.Global.journalApp.Entity.User;
import shikha.Global.journalApp.services.UserServices;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserServices userServices;

    @GetMapping("get-All")
    public ResponseEntity<?> getAll(){
        List<User> users = userServices.getAll();
        if(users != null && !users.isEmpty()){
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("add-admin")
    public ResponseEntity<?> createAdmin(@RequestBody User user){
        userServices.saveAdmin(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
