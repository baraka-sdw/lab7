package ahpu.ssh.city.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

public interface BaseDao<T> {

    // 因Service中的某个方法可能会调用DAO类的几个方法，
    // 为了在Service层的方法中正确开始和提交事务，需要让
    // 这些DAO的方法公用一个Session对象。
    void setSession(Session session);

    // 应为BaseDao定义尽可能多的、涵盖各种可能的CRUD方法，以供各个子接口使用。
    // 因本实验的需求较少，故只定义了2个查找方法。

    List<T> findAll(); // 获得所有实体对象

    T find(Serializable id); //根据标识符字段查找唯一的实体对象
    
    // 根据字段名和字段值来查找实体对象
    List<T> find(String[] paramNames, Object[] paramValues);
}