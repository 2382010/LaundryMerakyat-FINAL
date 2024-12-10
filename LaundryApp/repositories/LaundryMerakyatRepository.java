package LaundryApp.repositories;

import LaundryApp.entities.LaundryMerakyatList;

public interface LaundryMerakyatRepository {
    Boolean remove(Integer id);

    LaundryMerakyatList[] getOrders();

    void saveOrder(LaundryMerakyatList laundryOrder);

    Double calculateTotalPrice();

    void addPackagePrice(Double price);

    Boolean removeOrder(Integer id);

    Boolean editOrder(LaundryMerakyatList order);
}
