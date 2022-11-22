package ru.cocktails.customer.service;


import org.springframework.stereotype.Service;
import ru.cocktails.customer.repo.CustomerRepository;

@Service
public class UserService {

    private final CustomerRepository customerRepository;

    public UserService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String createUserIfNotExist(String nickname) {
        if(customerRepository.findByNickname(nickname).isPresent()) {
                return "User already exist";
        }
        else{
            return "User created";
        }
    }


}

