package LaundryApp.entities;

public class LaundryMerakyatList {
    private String customerName;
    private String address;
    private String phone;
    private String serviceType;
    private Double weight;
    private Double totalPrice;

    public LaundryMerakyatList() {
    }

    public LaundryMerakyatList(String customerName, String address, String phone, String serviceType, double weight, double totalPrice) {
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(final String serviceType) {
        this.serviceType = serviceType;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(final Double weight) {
        this.weight = weight;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(final Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setId(Integer id) {
    }
}
