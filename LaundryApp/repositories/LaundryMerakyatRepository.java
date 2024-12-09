package LaundryApp.repositories;

import LaundryApp.entities.LaundryMerakyatList;
import java.util.ArrayList;

public interface LaundryMerakyatRepository {
    // Simpan data pesanan laundry
    void saveOrder(LaundryMerakyatList laundryOrder);

    // Ambil semua data pesanan laundry
    ArrayList<LaundryMerakyatList> getOrders();

    // Hitung total harga untuk semua pesanan
    double calculateTotalPrice();

    // Tambahkan harga untuk paket layanan tertentu
    void addPackagePrice(double price);
}

