package LaundryApp;

import LaundryApp.config.Database;
import LaundryApp.view.LaundryMerakyatView;
import LaundryApp.view.LaundryMerakyatViewDbimpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "LaundryApp")
public class Main {

    public static void main(String[] args){
        // Membuat konteks aplikasi Spring
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        // Mengambil bean LaundryMerakyatView yang akan digunakan untuk interaksi terminal
        LaundryMerakyatView laundryMerakyatView = context.getBean(LaundryMerakyatViewDbimpl.class);

        // Menjalankan metode untuk menangani input pengguna melalui tampilan terminal
        laundryMerakyatView.handleInput();  // Memanggil method handleInput() dengan benar
    }

    // Definisikan bean untuk database dan repository
    @Bean
    Database database() {
        Database database = new Database("databaseku", "root", "", "localhost", "3306");
        database.setup();  // Setup koneksi ke database
        return database;
    }
}
