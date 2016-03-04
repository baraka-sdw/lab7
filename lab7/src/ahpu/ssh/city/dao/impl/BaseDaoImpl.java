package ahpu.ssh.city.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import ahpu.ssh.city.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {
    private Session session;
    private Class<?> entityClass; //泛型参数对应的实际实体类

    public BaseDaoImpl() {
        Type type = ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
        entityClass = (Class<?>) type;
    }

    public void setSession(Session session) {
        if (this.session == null || !session.isOpen()) {
            this.session = session;
        }
    }
    
    public List<T> findAll() {
        // 不指定任何参数名即为查找所有实体对象
        return find(new String[0], new Object[0]); 
    }
    
    public T find(Serializable id) {
        return (T)session.get(entityClass, id);
    }

    public List<T> find(String[] paramNames, Object[] paramValues) {
        StringBuffer sb = new StringBuffer("from " + entityClass.getSimpleName() + " where 1=1");

        for (int i = 0; i < paramNames.length; i++) {
            sb.append(" and ");
            sb.append(paramNames[i]);
            sb.append("=?");
        }

        Query q = session.createQuery(sb.toString());
        for (int i = 0; i < paramNames.length; i++) {
            q.setParameter(i, paramValues[i]);
        }
        List<T> entities = q.list();
        return entities;
    }
}