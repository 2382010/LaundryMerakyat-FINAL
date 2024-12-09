import repositories.LaundryMerakyatRepositoryImpl;
import services.LaundryMerakyatServicesImpl;
import view.LaundryMerakyatViewImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize dependencies
        LaundryMerakyatRepositoryImpl repository = new LaundryMerakyatRepositoryImpl();
        LaundryMerakyatServicesImpl service = new LaundryMerakyatServicesImpl(repository);
        LaundryMerakyatViewImpl view = new LaundryMerakyatViewImpl(service, scanner);

        // Run the application
        view.showMenu();

        scanner.close();
    }
}
