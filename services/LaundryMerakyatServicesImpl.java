package services;

import entities.LaundryMerakyatList;
import repositories.LaundryMerakyatRepository;

import java.util.List;

public class LaundryMerakyatServicesImpl implements LaundryMerakyatServices {
    private final LaundryMerakyatRepository repository;

    public LaundryMerakyatServicesImpl(LaundryMerakyatRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createOrder(LaundryMerakyatList order) {
        repository.addOrder(order);
    }

    @Override
    public List<LaundryMerakyatList> listOrders() {
        return repository.getAllOrders();
    }
}
