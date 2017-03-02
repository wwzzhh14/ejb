package blservice;

import javax.ejb.Remote;

/**
 * Created by wzh on 26/12/2016.
 */

@Remote
public interface UserService {
    public boolean checkAccount(String userId, String password);
}
