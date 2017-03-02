package ejbbean;

import entity.User;
import Factory.JPAFactory;
import blservice.UserService;
import dataservice.UserDataService;

import javax.ejb.Stateless;

/**
 * Created by wzh on 28/12/2016.
 */

@Stateless(name = "UserEJB")
public class UserBean implements UserService
{
    UserDataService userDataService= (UserDataService) JPAFactory.getJPA("");
//    @Override
    public boolean checkAccount(String userId, String password) {
        if(userId!=null){
            User user=userDataService.getUserById(userId);
            if(user!=null){
                if(user.getPassword().equals(password)){
                   return true;
                }else {
                    return false;
                }
            }else {
               return false;
            }
        }
        return false;
    }
}
