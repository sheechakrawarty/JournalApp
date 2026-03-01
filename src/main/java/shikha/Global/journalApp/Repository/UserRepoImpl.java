package shikha.Global.journalApp.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import shikha.Global.journalApp.Entity.User;

import java.util.List;

public class UserRepoImpl {
    @Autowired
    MongoTemplate mongoTemplate;
    public List<User> getUserForSA(){
        Query query = new Query();
        query.addCriteria(Criteria.where("sentiments").is(true) );
        query.addCriteria(Criteria.where("email").regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"));
        List<User> list = mongoTemplate.find(query,User.class);
        return list;
    }
}
