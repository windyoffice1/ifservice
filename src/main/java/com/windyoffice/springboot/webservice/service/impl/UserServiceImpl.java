package com.windyoffice.springboot.webservice.service.impl;

import com.windyoffice.springboot.webservice.mo.User;
import com.windyoffice.springboot.webservice.service.UserService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

@WebService(name="userservice",serviceName = "userservice" ,targetNamespace = "service.webservice.windyoffice.com")
@Component
public class UserServiceImpl implements UserService {


    @Override
    public User getUserById(String id) {
        if("1".equals(id)){
            User user=new User();
            user.setId("1");
            user.setName("测试");
            user.setAddress("地址");
            return  user;
        }else {
            throw new  RuntimeException("查无此人");
        }
    }
}
