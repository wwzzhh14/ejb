package dataservice;



import entity.User;

import javax.ejb.Remote;

/**
 * Created by wzh on 28/12/2016.
 */

@Remote
public interface UserDataService {
    public User getUserById(String id);
}
