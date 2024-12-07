package repositories;

import entities.LaundryMerakyatList;
import java.util.ArrayList;
import java.util.List;

public class LaundryMerakyatRepositoryImpl implements LaundryMerakyatRepository {
    private final List<LaundryMerakyatList> orders = new ArrayList<>();

    @Override
    public void addOrder(LaundryMerakyatList order) {
        orders.add(order);
    }

    @Override
    public List<LaundryMerakyatList> getAllOrders() {
        return orders;
    }
}
