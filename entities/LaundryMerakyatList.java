package entities;

public class LaundryMerakyatList {
    private String name;
    private String phoneNumber;
    private String address;
    private String packageType;
    private int quantityKg;
    private int totalPrice;

    public LaundryMerakyatList(String name, String phoneNumber, String address, String packageType, int quantityKg, int totalPrice) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.packageType = packageType;
        this.quantityKg = quantityKg;
        this.totalPrice = totalPrice;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public int getQuantityKg() {
        return quantityKg;
    }

    public void setQuantityKg(int quantityKg) {
        this.quantityKg = quantityKg;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Nama: " + name +
                "\nNo. HP: " + phoneNumber +
                "\nAlamat: " + address +
                "\nPaket: " + packageType +
                "\nJumlah KG: " + quantityKg +
                "\nTotal Harga: Rp " + totalPrice;
    }
}
