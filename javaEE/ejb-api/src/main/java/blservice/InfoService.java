package blservice;

import bean.ScoreBean;

import javax.ejb.Remote;

/**
 * Created by wzh on 26/12/2016.
 */

@Remote
public interface InfoService {
    public ScoreBean getScore(String id);
}
