package com.hms.Service;

import java.util.List;
import java.util.Optional;


import com.hms.entity.Users;
import com.hms.repository.UserRepository;
import com.hms.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private  UsersRepository userRepository;



    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users getUserById(Long userId) {
    	Optional<Users> findById = userRepository.findById(userId);
		Users user = findById.get();
		return user;
               
    }
}

