package repositories;

import entities.LaundryMerakyatList;
import java.util.List;

public interface LaundryMerakyatRepository {
    void addOrder(LaundryMerakyatList order);
    List<LaundryMerakyatList> getAllOrders();
}
