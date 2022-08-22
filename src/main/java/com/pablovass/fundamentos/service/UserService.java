package com.pablovass.fundamentos.service;

import com.pablovass.fundamentos.entity.User;
import com.pablovass.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class UserService {
    private final Log LOG = LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveTransactional(List<User> users) {
        users.stream()
                .peek(user -> LOG.info("usuario insertado" + user))
                .forEach(userRepository::save);
    }
    public List<User>getAllUsers(){
        return userRepository.findAll();
    }
    public  User save(User newUser){
        return userRepository.save(newUser );
    }
}