package view;

import entities.LaundryMerakyatList;
import services.LaundryMerakyatServices;
import view.LaundryMerakyatView;

import java.util.List;
import java.util.Scanner;

public class LaundryMerakyatViewImpl implements LaundryMerakyatView {
    private final LaundryMerakyatServices service;
    private final Scanner scanner;

    public LaundryMerakyatViewImpl(LaundryMerakyatServices service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    @Override
    public void showMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\nSelamat Datang di Laundry Merakyat");
            System.out.println("1. Tambah Pesanan");
            System.out.println("2. Lihat Pesanan");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addOrder();
                    break;
                case 2:
                    showOrders();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    @Override
    public void showOrders() {
        List<LaundryMerakyatList> orders = service.listOrders();
        if (orders.isEmpty()) {
            System.out.println("Belum ada pesanan.");
        } else {
            for (LaundryMerakyatList order : orders) {
                System.out.println(order);
                System.out.println("--------------------");
            }
        }
    }

    private void addOrder() {
        System.out.print("Masukkan nama: ");
        String name = scanner.nextLine();

        System.out.print("Masukkan no. HP: ");
        String phone = scanner.nextLine();

        System.out.print("Masukkan alamat: ");
        String address = scanner.nextLine();

        System.out.print("Masukkan paket (Cuci Lipat/Setrika): ");
        String packageType = scanner.nextLine();

        System.out.print("Masukkan jumlah KG: ");
        int kg = scanner.nextInt();
        scanner.nextLine();

        int totalPrice = kg * 15000; // Contoh harga per kg
        LaundryMerakyatList order = new LaundryMerakyatList(name, phone, address, packageType, kg, totalPrice);
        service.createOrder(order);

        System.out.println("Pesanan berhasil ditambahkan!");
    }
}
