package shikha.Global.journalApp.controller;

import org.springframework.web.bind.annotation.*;
import shikha.Global.journalApp.Entity.JournalEntry;
import shikha.Global.journalApp.JournalApplication;

import java.util.*;
/*
@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    HashMap<Long, JournalEntry> journalEntries = new HashMap<>();
    @GetMapping
    public List<JournalEntry> getAll(){
        //System.out.println("Hey");
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean add(@RequestBody JournalEntry entry){
        journalEntries.put(entry.getId(),entry);
        return true;
    }

    @GetMapping("id/{myid}")
    public JournalEntry getJournalById(@PathVariable long myid){
        return journalEntries.get(myid);
    }

    @DeleteMapping("id/{myid}")
    public JournalEntry deleteJournalById(@PathVariable Long myId){
        return journalEntries.remove(myId);

    }

    @PutMapping
    public JournalEntry updateJournalById(@RequestBody JournalEntry entry){
        return journalEntries.put(entry.getId(), entry);
    }
}
*/