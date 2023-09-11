package com.mazi.expensetrackerapi.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImplementation implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User validateUser(String email, String password) throws UserAuthException {
        if (email != null) email = email.toLowerCase();
            return userRepository.findByEmailAndPassword(email,password);

    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws UserAuthException {
//        Regex for the email format
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (email != null) {
            email = email.toLowerCase();
            if (!pattern.matcher(email).matches()){
                throw new UserAuthException("Invalid Email pattern or format use this example 'mazi@example.com'");
            }
//            Check if email already exists
            Integer count = userRepository.getCountByEmail(email);
            if(count > 0) throw new UserAuthException("This Email already exists.");
            Integer userId = userRepository.create(  firstName,  lastName,  email,  password);
            return userRepository.findById(userId);

        }

        return null;
    }
}
