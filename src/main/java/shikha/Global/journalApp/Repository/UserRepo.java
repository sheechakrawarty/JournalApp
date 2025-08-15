package shikha.Global.journalApp.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import shikha.Global.journalApp.Entity.JournalEntry;
import shikha.Global.journalApp.Entity.User;

public interface UserRepo extends MongoRepository<User, ObjectId> {
    User findByUsername(String username);
    User deleteByUsername(String username);
}
