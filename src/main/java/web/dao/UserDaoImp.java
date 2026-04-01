package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{
    private EntityManager entityManager;

    @Autowired
    public UserDaoImp(EntityManager theEntityManager) {
        entityManager=theEntityManager;
    }

    @Override
    public List<User> findAllUsers() {
        //create a query
        TypedQuery<User> theQuery = entityManager.createQuery("from Employee", User.class);

        // execute query and get result list
        List<User> employees = theQuery.getResultList();

        // return the results
        return employees;
    }
}
