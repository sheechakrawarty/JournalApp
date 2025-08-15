package shikha.Global.journalApp.services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import shikha.Global.journalApp.Entity.JournalEntry;
import shikha.Global.journalApp.Entity.User;
import shikha.Global.journalApp.Repository.JournalEntryRepo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryServices {
    @Autowired
    private JournalEntryRepo journalEntryRepo ;

    @Autowired
    private UserServices userServices;
    @Transactional
    public void save(JournalEntry journalEntry,String userName){
        User user = userServices.findByUsername(userName);
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry journalentry = journalEntryRepo.save(journalEntry);
        user.getJournalEntries().add(journalentry);
        userServices.saveUser(user);
    }
    public void save(JournalEntry journalEntry){

        journalEntryRepo.save(journalEntry);
    }
    public List<JournalEntry> getAll(){
        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepo.findById(id);
    }
    public void deleteByid(ObjectId id, String userName){
        User user = userServices.findByUsername(userName);
        user.getJournalEntries().removeIf(x->x.getId().equals(id));
        userServices.saveNewUser(user);
        journalEntryRepo.deleteById(id);

    }


}
// controller --> services --> repository