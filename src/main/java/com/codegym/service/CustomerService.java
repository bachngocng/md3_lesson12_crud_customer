package com.codegym.service;

import com.codegym.dao.ICustomerDAO;
import com.codegym.model.Customer;

import java.util.List;

public class CustomerService implements ICustomerService{
    ICustomerDAO customerDAO;

    public CustomerService(ICustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }
    @Override
    public List findAll() {
        return customerDAO.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerDAO.findById(id);
    }

    @Override
    public boolean create(Customer customer) {
        return customerDAO.create(customer);
    }

    @Override
    public boolean updateById(int id, Customer customer) {
        return customerDAO.updateById(id,customer);
    }

    @Override
    public boolean deleteById(int id) {
        return customerDAO.deleteById(id);
    }
}
