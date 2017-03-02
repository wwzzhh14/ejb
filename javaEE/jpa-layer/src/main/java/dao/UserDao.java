package dao;


import entity.User;
import dataservice.UserDataService;

import javax.ejb.Stateless;

/**
 * Created by wzh on 15/12/2016.
 */

@Stateless(name = "UserDao")
public class UserDao implements UserDataService {
    BaseDao baseDao=new BaseDao();
    public User getUserById(String id){
        User user = (User) baseDao.getEntityById(User.class,id);
        return user;
    }
}
