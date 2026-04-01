package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserDaoImp(EntityManager theEntityManager) {
        entityManager=theEntityManager;
    }

    @Override
    public List<User> findAllUsers() {
        //create a query
        TypedQuery<User> theQuery = entityManager.createQuery("from User", User.class);

        // execute query and get result list
        List<User> users = theQuery.getResultList();

        // return the results
        return users;
    }

    @Override
    public User findById(int theId) {
        User theUser = entityManager.find(User.class, theId);
        return theUser;
    }

    @Override
    public User save(User theUser) {
        System.out.println("User in DAO: " + theUser);
        User dbUser = entityManager.merge(theUser);
        return dbUser;
    }

    @Override
    public void deleteById(int theId) {
        User theUser = entityManager.find(User.class, theId);
        entityManager.remove(theUser);
    }
}
