package LaundryApp.repositories;

import LaundryApp.config.Database;
import LaundryApp.entities.LaundryMerakyatList;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component
public class LaundryMerakyatRepositoryDbImpl implements LaundryMerakyatRepository {

    private final Database database;

    // Konstruktor untuk inisialisasi database
    public LaundryMerakyatRepositoryDbImpl(Database database) {
        this.database = database;
    }

    @Override
    public void saveOrder(LaundryMerakyatList order) {
        String sqlStatement = "INSERT INTO laundry_orders (customer_name, address, phone, service_type, weight, total_price) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {

            preparedStatement.setString(1, order.getCustomerName());
            preparedStatement.setString(2, order.getAddress());
            preparedStatement.setString(3, order.getPhone());
            preparedStatement.setString(4, order.getServiceType());
            preparedStatement.setDouble(5, order.getWeight());
            preparedStatement.setDouble(6, order.getTotalPrice());

            preparedStatement.executeUpdate();
            System.out.println("Order saved successfully!");
        } catch (Exception e) {
            System.out.println("Error while saving order: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<LaundryMerakyatList> getOrders() {
        String sqlStatement = "SELECT * FROM laundry_orders";
        ArrayList<LaundryMerakyatList> orders = new ArrayList<>();

        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String customerName = resultSet.getString("customer_name");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String serviceType = resultSet.getString("service_type");
                double weight = resultSet.getDouble("weight");
                double totalPrice = resultSet.getDouble("total_price");

                orders.add(new LaundryMerakyatList(customerName, address, phone, serviceType, weight, totalPrice));
            }
        } catch (Exception e) {
            System.out.println("Error while retrieving orders: " + e.getMessage());
        }
        return orders;
    }

    @Override
    public double calculateTotalPrice() {
        String sqlStatement = "SELECT SUM(total_price) AS total FROM laundry_orders";
        double totalPrice = 0;

        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                totalPrice = resultSet.getDouble("total");
            }
        } catch (Exception e) {
            System.out.println("Error while calculating total price: " + e.getMessage());
        }
        return totalPrice;
    }

    @Override
    public void addPackagePrice(double price) {
        // Implementasi tambahan jika diperlukan
    }
}
