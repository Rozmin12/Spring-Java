package com.example.demo.service;

import com.example.demo.dao.RoleDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.HashSet;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    public User registerNewUser(User user){
       return userDao.save(user);
    }
    public void initRolesAndUser(){
        Role adminRole=new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin Role ");
        roleDao.save(adminRole);

        Role userRole=new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default Role for newly created record ");
        roleDao.save(userRole);

        User adminUser=new User();
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserName("admin123");
        adminUser.setUserPassword("admin@pass");
        Set<Role> adminRoles =new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        User user=new User();
        user.setUserFirstName("Rozmin");
        user.setUserLastName("Shaikh");
        user.setUserName("rozmin123");
        user.setUserPassword("rozmin@pass");
        Set<Role> userRoles =new HashSet<>();
        user.setRole(userRoles);
        userRoles.add(userRole);
        userDao.save(user);





    }
}
