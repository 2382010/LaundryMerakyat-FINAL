import entities.LaundryMerakyatList;

public class Main {
    public class MainApplication {
        public static void main(String[] args) {
            // Membuat objek entitas LaundryMerakyatList
            LaundryMerakyatList laundry = new LaundryMerakyatList(
                    1,
                    "Timothy Pakpahan",
                    "08123456789",
                    "Jalan Kemerdekaan No. 123",
                    "Paket Cepat",
                    "Pakaian",
                    5,
                    50000
            );
            // Menampilkan data laundry
            System.out.println("Data Laundry:");
            System.out.println(laundry.toString());
        }
    }

}
