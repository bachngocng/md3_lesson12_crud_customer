package com.codegym.dao;

import com.codegym.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDAO{
    Connection connection = DBConnection.getConnection();
    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customers");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id  = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");
                String email = resultSet.getString("email");
                Customer customer = new Customer(id,name,country,email);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = new Customer();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM customers where id = ?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");
                String email = resultSet.getString("email");
                customer = new Customer(id,name, country,email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean create(Customer customer) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customers (name, country, email) values (?, ?, ?)");
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getCountry());
            preparedStatement.setString(3, customer.getEmail());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateById(int id, Customer customer) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customers SET name=?,country=?,email=? WHERE id=?");
            preparedStatement.setString(1,customer.getName());
            preparedStatement.setString(2,customer.getCountry());
            preparedStatement.setString(3,customer.getEmail());
            preparedStatement.setInt(4,id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM customers WHERE id = ?");
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
