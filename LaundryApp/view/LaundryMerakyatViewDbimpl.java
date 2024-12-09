package LaundryApp.view;

import LaundryApp.services.LaundryMerakyatService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class LaundryMerakyatViewDbimpl implements LaundryMerakyatView {
    private LaundryMerakyatService laundryMerakyatService;
    private Scanner scanner = new Scanner(System.in);

    public LaundryMerakyatViewDbimpl(LaundryMerakyatService service) {
        this.laundryMerakyatService = (LaundryMerakyatService) service;
    }

    @Override
    public void displayMenu() {
        System.out.println("============ Laundry Merakyat ============");
        System.out.println("1. Tampilkan layanan dan harga");
        System.out.println("2. Pilih layanan dan jumlah pesanan");
        System.out.println("3. Input data pelanggan (nama, alamat, telepon)");
        System.out.println("4. Hitung total harga pesanan");
        System.out.println("5. Hitung biaya pengiriman (berdasarkan jarak)");
        System.out.println("6. Konfirmasi pesanan");
        System.out.println("7. Tampilkan semua data pelanggan");
        System.out.println("8. Keluar");
        System.out.println("=========================================");
    }

    @Override
    public void handleInput() {
        while (true) {
            displayMenu();
            System.out.print("Pilih Opsi Menu: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("=== Daftar Layanan ===");
                    System.out.println("1. Pencucian Kiloan - Rp 50,000");
                    System.out.println("2. Pembersihan Setrika - Rp 30,000");
                    System.out.println("3. Layanan Ekspres - Rp 100,000");
                }
                case 2 -> {
                    System.out.print("Pilih Layanan (1-3): ");
                    int packageChoice = scanner.nextInt();
                    System.out.print("Jumlah yang ingin dipesan: ");
                    int quantity = scanner.nextInt();
                    laundryMerakyatService.addPackage(packageChoice, quantity);
                }
                case 3 -> {
                    scanner.nextLine(); // Consume newline
                    System.out.print("Masukkan nama: ");
                    String name = scanner.nextLine();
                    System.out.print("Masukkan alamat: ");
                    String address = scanner.nextLine();
                    System.out.print("Masukkan nomor telepon: ");
                    String phone = scanner.nextLine();
                    laundryMerakyatService.inputCustomerData(name, address, phone);
                }

                case 4 -> System.out.println("Total Harga: Rp " + laundryMerakyatService.getTotalPrice());

                case 5 -> {
                    System.out.print("Masukkan jarak ke alamat (km): ");
                    int distance = scanner.nextInt();
                    laundryMerakyatService.calculateDeliveryFee(distance);
                    System.out.println("Ongkos kirim berhasil dihitung.");
                }
                case 6 -> {
                    System.out.println("Pesanan telah dikonfirmasi.");
                }
                case 7 -> {
                    laundryMerakyatService.showOrderDetails();
                }
                case 8 -> {
                    System.out.println("Keluar dari aplikasi...");
                    return;
                }
                default -> System.out.println("Opsi tidak valid.");
            }
        }
    }
}

