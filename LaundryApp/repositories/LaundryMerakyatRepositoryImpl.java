package LaundryApp.repositories;

import LaundryApp.entities.LaundryMerakyatList;
import org.springframework.stereotype.Component;

@Component
public class LaundryMerakyatRepositoryImpl implements LaundryMerakyatRepository{
    public static LaundryMerakyatList[] orders = new LaundryMerakyatList[2];

    @Override
    public LaundryMerakyatList[] getOrders() {
        return orders;
    }

    @Override
    public void saveOrder(final LaundryMerakyatList order) {
        resizeArrayIfFull();

        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) {
                orders [i] = order;
                break;
            }
        }
    }

    private void resizeArrayIfFull() {
        // Check whether orders array is full
        boolean isFull = isArrayFull();

        // Resize the array to two times bigger if full
        if (isFull) {
            resizeArrayToTwoTimesBigger();
        }
    }

    private void resizeArrayToTwoTimesBigger() {
        LaundryMerakyatList[] temp = orders;
        orders = new LaundryMerakyatList[orders.length * 2];
        for (int i = 0; i < temp.length; i++) {
            orders[i] = temp[i];
        }
    }


    private boolean isArrayFull() {
        for (LaundryMerakyatList order : orders) {
            if (order == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Boolean remove(final Integer id) {
        if (isSelectedOrderNotValid(id)) {
            return false;
        }

        for (int i = id - 1; i < orders.length; i++) {
            if (i == (orders.length - 1)) {
                orders[i] = null;
            } else {
                orders[i] = orders[i + 1];
            }
        }
        return true;
    }

    private boolean isSelectedOrderNotValid(final Integer id) {
        // Check if id is zero or less
        if (id <= 0 || id > orders.length || orders[id - 1] == null) {
            return true;
        }
        return false;
    }

    @Override
    public Double calculateTotalPrice() {
        double totalPrice = 0;
        for (LaundryMerakyatList order : orders) {
            if (order != null) {
                totalPrice += order.getTotalPrice();
            }
        }
        return totalPrice;
    }

    @Override
    public void addPackagePrice(final Double price) {
        System.out.println("Adding package price feature not implemented.");
    }

    @Override
    public Boolean removeOrder(Integer id) {
        return null;
    }

    @Override
    public Boolean editOrder(LaundryMerakyatList order) {
        return null;
    }
}
