package shikha.Global.journalApp.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shikha.Global.journalApp.Entity.JournalEntry;
import shikha.Global.journalApp.Entity.User;
import shikha.Global.journalApp.services.JournalEntryServices;
import shikha.Global.journalApp.services.UserServices;

import javax.xml.transform.OutputKeys;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/journal")
public class JournalEntityControllerV2 {

    @Autowired
    private JournalEntryServices journalEntryServices;

    @Autowired
    private UserServices userServices;

    @GetMapping
    public ResponseEntity<?> getAllJournalEntriesOfUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userServices.findByUsername(userName);
        List<JournalEntry> list = user.getJournalEntries();

        if(list != null && !list.isEmpty()){
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody JournalEntry entry){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        try {

            journalEntryServices.save(entry,userName);
            return ResponseEntity.status(HttpStatus.CREATED).body(entry);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving entry: " + e.getMessage());
        }
    }


    @GetMapping("id/{myid}")
    public ResponseEntity<JournalEntry> getJournalById(@PathVariable ObjectId myid){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userServices.findByUsername(username);
        List<JournalEntry> list = user.getJournalEntries().stream().filter(x -> x.getId().equals(myid)).collect(Collectors.toList());
        if(!list.isEmpty()){
            Optional<JournalEntry> journalEntry = journalEntryServices.findById(myid);
            if(journalEntry.isPresent()){
            return new ResponseEntity<>(journalEntry.get(),HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteJournalById(@PathVariable ObjectId myId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
         journalEntryServices.deleteByid(myId,userName);
         return new ResponseEntity<JournalEntry>(HttpStatus.OK);

    }

    @PutMapping("id/{id}")
    public ResponseEntity<JournalEntry> updateJournalById(@RequestBody JournalEntry entry,
                                                          @PathVariable ObjectId id
                                                         ){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userServices.findByUsername(username);
        List<JournalEntry> list = user.getJournalEntries().stream().filter(x -> x.getId().equals(id)).collect(Collectors.toList());
        if(!list.isEmpty()) {
            JournalEntry old = journalEntryServices.findById(id).orElse(null);

            if (old != null) {
                old.setContent(entry.getContent().equals("") || entry.getContent() != null ? entry.getContent() : old.getContent());
                old.setTitle(entry.getTitle().equals("") || entry.getTitle() != null ? entry.getTitle() : old.getTitle());

            }
            journalEntryServices.save(old);
            return new ResponseEntity<>(old, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


    }
}
