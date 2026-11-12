package edu.kirkwood;

import edu.kirkwood.dao.sql.SQLDahliaDAO;
import edu.kirkwood.dao.sql.SQLMovieDAO;
import edu.kirkwood.view.MainMenu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MyDataApplication {
    static void main(String[] args) {
        SpringApplication.run(MyDataApplication.class, args);
    }

    @Bean
    CommandLineRunner run(SQLMovieDAO movieDAO, SQLDahliaDAO dahliaDAO) {
        return args -> {
            MainMenu.show(movieDAO, dahliaDAO);
        };
    }
}
