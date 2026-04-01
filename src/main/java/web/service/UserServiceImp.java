package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = true)
    @Override
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(int theId) {
        return userDao.findById(theId);
    }

    @Transactional
    @Override
    public User save(User theUser) {
        return userDao.save(theUser);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        userDao.deleteById(theId);
    }
}
