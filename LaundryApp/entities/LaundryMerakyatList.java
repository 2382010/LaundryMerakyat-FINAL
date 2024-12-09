package LaundryApp.entities;

public class LaundryMerakyatList {
    private String customerName; // Nama pelanggan
    private String address;      // Alamat pelanggan
    private String phone;        // Nomor telepon pelanggan
    private String serviceType;  // Jenis layanan (cuci, setrika, dll.)
    private double weight;       // Berat cucian dalam kg
    private double totalPrice;   // Harga total cucian

    // Konstruktor
    public LaundryMerakyatList(String customerName, String address, String phone, String serviceType, double weight, double totalPrice) {
        this.customerName = customerName;
        this.address = address;
        this.phone = phone;
        this.serviceType = serviceType;
        this.weight = weight;
        this.totalPrice = totalPrice;
    }

    // Getter dan Setter
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "LaundryMerakyatList{" +
                "customerName='" + customerName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", weight=" + weight +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

