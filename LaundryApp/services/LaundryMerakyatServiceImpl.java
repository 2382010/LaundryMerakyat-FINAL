package LaundryApp.services;

import LaundryApp.entities.LaundryMerakyatList;
import LaundryApp.repositories.LaundryMerakyatRepository;
import org.springframework.stereotype.Component;

@Component
public class LaundryMerakyatServiceImpl implements LaundryMerakyatService {
    private LaundryMerakyatRepository laundryMerakyatRepository;

    public LaundryMerakyatRepository getLaundryMerakyatRepository() {
        return laundryMerakyatRepository;
    }

    public void setLaundryMerakyatRepository(LaundryMerakyatRepository laundryMerakyatRepository) {
        this.laundryMerakyatRepository = laundryMerakyatRepository;
    }

    @Override
    public LaundryMerakyatList[] getLaundryServices() {
        return laundryMerakyatRepository.getOrders();
    }

    @Override
    public void addLaundryService(String serviceType, double weight) {
        if (serviceType.isBlank() || serviceType.isEmpty() || weight <= 0) {
            System.out.println("Masukkan layanan dan berat dengan benar");
            return;
        }

        LaundryMerakyatList order = new LaundryMerakyatList();
        order.setServiceType(serviceType);
        order.setWeight(weight);
        order.setTotalPrice(calculateServicePrice(serviceType, weight));

        laundryMerakyatRepository.saveOrder(order);
    }

    @Override
    public Boolean removeLaundryService(Integer id) {
        return laundryMerakyatRepository.removeOrder(id);
    }

    @Override
    public Boolean editLaundryService(Integer id, String serviceType, double weight) {
        if (serviceType.isBlank() || serviceType.isEmpty() || weight <= 0) {
            System.out.println("Masukkan layanan dan berat dengan benar");
            return false;
        }

        LaundryMerakyatList order = new LaundryMerakyatList();
        order.setId(id);
        order.setServiceType(serviceType);
        order.setWeight(weight);
        order.setTotalPrice(calculateServicePrice(serviceType, weight));

        return laundryMerakyatRepository.editOrder(order);
    }

    @Override
    public double getTotalPrice() {
        return laundryMerakyatRepository.calculateTotalPrice();
    }

    private double calculateServicePrice(String serviceType, double weight) {
        double price = 0;
        switch (serviceType.toLowerCase()) {
            case "cuci":
                price = weight * 10000;
                break;
            case "setrika":
                price = weight * 5000;
                break;
            default:
                System.out.println("Layanan tidak dikenali");
                break;
        }
        return price;
    }
}
