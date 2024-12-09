package LaundryApp.services;

import LaundryApp.entities.LaundryMerakyatList;

import java.util.ArrayList;

public interface LaundryMerakyatService {
    /**
     * Input data pelanggan baru.
     *
     * @param name Nama pelanggan.
     * @param address Alamat pelanggan.
     * @param phone Nomor telepon pelanggan.
     */
    void inputCustomerData(String name, String address, String phone);

    /**
     * Menambahkan layanan laundry yang dipilih pelanggan.
     *
     * @param serviceType Jenis layanan laundry (cuci, setrika, dll.).
     * @param weight Berat cucian (dalam kg).
     */
    void addLaundryService(String serviceType, double weight);

    /**
     * Mendapatkan total harga dari semua layanan laundry yang dipilih.
     *
     * @return Total harga.
     */
    double getTotalPrice();

    /**
     * Mendapatkan detail pelanggan.
     *
     * @return Daftar pelanggan.
     */
    ArrayList<LaundryMerakyatList> getCustomerDetails();

    /**
     * Menghitung biaya pengantaran berdasarkan jarak.
     *
     * @param distance Jarak dalam kilometer.
     */
    void calculateDeliveryFee(int distance);

    /**
     * Menampilkan detail pesanan yang dibuat pelanggan.
     */
    void showOrderDetails();

    void addPackage(int packageChoice, int quantity);
}
