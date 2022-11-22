package ru.cocktails.customer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cocktails.customer.model.entity.Customer;
import ru.cocktails.customer.repo.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String createCustomer(String nickname) {
        if(customerRepository.findByNickname(nickname).isPresent()) {
            return "Customer already exists";
        }
        else{

            return "Customer created";
        }
    }

}
