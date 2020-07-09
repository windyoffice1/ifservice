package com.windyoffice.springboot.webservice.service;

import com.windyoffice.springboot.webservice.mo.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name="userservice",serviceName = "userservice" ,targetNamespace = "service.webservice.windyoffice.com")
public interface UserService {

    @WebMethod
    @WebResult
    User getUserById(@WebParam(name="id") String id);
}
