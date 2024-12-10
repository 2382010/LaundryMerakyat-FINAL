package LaundryApp.view;

import LaundryApp.entities.LaundryMerakyatList;
import LaundryApp.services.LaundryMerakyatService;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class LaundryMerakyatTerminalViewImpl implements LaundryMerakyatView {
    public static Scanner scanner = new Scanner(System.in);
    private final LaundryMerakyatService laundryMerakyatService;

    public LaundryMerakyatTerminalViewImpl(LaundryMerakyatService laundryMerakyatService) {
        this.laundryMerakyatService = laundryMerakyatService;
    }

    public String input(String info) {
        System.out.print(info + " : ");
        var data = scanner.nextLine();
        return data;
    }

    public void showMainMenu() {
        // infinite loop so the program will always run
        boolean isRunning = true;
        while (isRunning) {
            showLaundryServices();
            System.out.println("MENU : ");
            System.out.println("1. Tambah layanan");
            System.out.println("2. Hapus layanan");
            System.out.println("3. Edit layanan");
            System.out.println("4. Hitung total harga");
            System.out.println("5. Keluar");
            // input untuk menerima input dari user
            String selectedMenu = input("Pilih");

            switch (selectedMenu) {
                case "1":
                    showMenuAddLaundryService();
                    break;
                case "2":
                    showMenuRemoveLaundryService();
                    break;
                case "3":
                    showMenuEditLaundryService();
                    break;
                case "4":
                    showTotalPrice();
                    break;
                case "5":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilih menu dengan benar");
            }
        }
    }

    public void showMenuAddLaundryService() {
        System.out.println("MENAMBAH LAYANAN LAUNDRY");
        String serviceType = input("Masukkan jenis layanan (x jika batal)");
        if (serviceType.equals("x")) {
            // batal
            return;
        }
        double weight = Double.parseDouble(input("Masukkan berat (kg)"));
        laundryMerakyatService.addLaundryService(serviceType, weight);
    }

    public void showMenuRemoveLaundryService() {
        System.out.println("MENGHAPUS LAYANAN LAUNDRY");
        String id = input("Masukkan ID layanan yang dihapus (x jika batal)");
        if (id.equals("x")) {
            return;
        }
        boolean success = laundryMerakyatService.removeLaundryService(Integer.valueOf(id));
        if (!success) {
            System.out.println("Gagal menghapus layanan dengan ID: " + id);
        }
    }

    public void showMenuEditLaundryService() {
        System.out.println("MENGEDIT LAYANAN LAUNDRY");
        String id = input("Masukkan ID layanan yang diedit (x jika batal)");
        if (id.equals("x")) {
            return;
        }
        String serviceType = input("Masukkan jenis layanan baru (x jika batal)");
        if (serviceType.equals("x")) {
            return;
        }
        double weight = Double.parseDouble(input("Masukkan berat baru (kg)"));
        boolean isEditSuccess = laundryMerakyatService.editLaundryService(Integer.valueOf(id), serviceType, weight);
        if (isEditSuccess) {
            System.out.println("Layanan berhasil diedit");
        } else {
            System.out.println("Gagal mengedit layanan");
        }
    }

    public void showLaundryServices() {
        System.out.println("LAYANAN LAUNDRY");
        LaundryMerakyatList[] laundryServices = laundryMerakyatService.getLaundryServices();
        for (var i = 0; i < laundryServices.length; i++) {
            var service = laundryServices[i];
            if (service != null) {
                System.out.println((i + 1) + ". " + service.getServiceType() + " - Berat: " + service.getWeight() + " kg - Harga: Rp " + service.getTotalPrice());
            }
        }
    }

    public void showTotalPrice() {
        double totalPrice = laundryMerakyatService.getTotalPrice();
        System.out.println("Total Harga Pesanan: Rp " + totalPrice);
    }

    @Override
    public void run() {
        showMainMenu();
    }
}
