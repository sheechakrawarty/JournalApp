package shikha.Global.journalApp;

import com.mongodb.client.MongoDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import java.lang.management.ManagementFactory;

@SpringBootApplication
@EnableTransactionManagement
@EnableMongoRepositories(basePackages = "shikha.Global.journalApp.Repository")

public class JournalApplication {

	public static void main(String[] args) {
		SpringApplication.run(JournalApplication.class, args);
	}

	@Bean
	PlatformTransactionManager mana(MongoDatabaseFactory mongoDatabase){
		return new MongoTransactionManager(mongoDatabase);
	}
	@Bean
	RestTemplate restTemplate (){
		return new RestTemplate();
	}
}
