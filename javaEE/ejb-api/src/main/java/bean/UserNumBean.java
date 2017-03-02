package bean;

import java.io.Serializable;

/**
 * Created by wzh on 24/12/2016.
 */
public class UserNumBean implements Serializable {
    private int visitor;
    private int user;
    private int sum;

    public UserNumBean() {
    }

    public UserNumBean(int visitor, int user, int sum) {
        this.visitor = visitor;
        this.user = user;
        this.sum = sum;
    }

    public int getVisitor() {
        return visitor;
    }

    public void setVisitor(int visitor) {
        this.visitor = visitor;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
