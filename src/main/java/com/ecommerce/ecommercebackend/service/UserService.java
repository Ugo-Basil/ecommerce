package com.ecommerce.ecommercebackend.service;


import com.ecommerce.ecommercebackend.api.model.RegistrationBody;
import com.ecommerce.ecommercebackend.exception.UserAlreadyExistsException;
import com.ecommerce.ecommercebackend.model.LocalUser;
import com.ecommerce.ecommercebackend.model.dao.LocalUserDAO;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private  LocalUserDAO localUserDAO;
    public  UserService(LocalUserDAO localUserDAO) {
        this.localUserDAO = localUserDAO;
    }

    public LocalUser registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {


      if ( localUserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
              && localUserDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()){

          throw  new UserAlreadyExistsException();

      }

        LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setFirstname(registrationBody.getFirstName());
        user.setLastname(registrationBody.getLastName());
        user.setUsername(registrationBody.getUsername());
        user.setPassword(registrationBody.getPassword());

        return localUserDAO.save(user);

    }
}
