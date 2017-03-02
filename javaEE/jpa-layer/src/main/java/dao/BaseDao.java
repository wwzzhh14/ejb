package dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wzh on 14/12/2016.
 */

public class BaseDao  {
    private static DataSource datasource = null;

    @PersistenceContext
    protected EntityManager em;

    public Object getEntityById(Class c,String id){
        Object entity = em.find(c,id);
        return entity;
    }

    public <T> List<T> getModelBySql(String sql,T t){
        TypedQuery<T> reportTypedQuery= (TypedQuery<T>) em.createQuery(sql,t.getClass());
        List<T> results= reportTypedQuery.getResultList();
        return results;
    }

}
