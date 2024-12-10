package LaundryApp.services;

import LaundryApp.entities.LaundryMerakyatList;

public interface LaundryMerakyatService {
    LaundryMerakyatList[] getLaundryServices();

    void addLaundryService(String serviceType, double weight);

    Boolean removeLaundryService(Integer id);

    Boolean editLaundryService(Integer id, String serviceType, double weight);

    double getTotalPrice();
}
