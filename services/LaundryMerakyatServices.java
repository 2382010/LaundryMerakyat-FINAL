package services;

import entities.LaundryMerakyatList;
import java.util.List;

public interface LaundryMerakyatServices {
    void createOrder(LaundryMerakyatList order);
    List<LaundryMerakyatList> listOrders();
}
