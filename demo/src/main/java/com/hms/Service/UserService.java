package com.hms.Service;


import com.hms.entity.Users;

import java.util.List;



public interface UserService {
    List<Users> getAllUsers();
    Users getUserById(Long userId);
}
