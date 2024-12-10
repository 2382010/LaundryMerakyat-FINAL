package LaundryApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import LaundryApp.config.Database;
import LaundryApp.view.LaundryMerakyatView;

@ComponentScan(basePackages = "LaundryApp")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        LaundryMerakyatView laundryMerakyatView = context.getBean(LaundryMerakyatView.class);
        laundryMerakyatView.run();
    }

    @Bean
    Database database() {
        Database database = new Database("databaseku", "root", "", "localhost", "3306");
        database.setup();
        return database;
    }
}
