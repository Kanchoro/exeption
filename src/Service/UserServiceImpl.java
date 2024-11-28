package Service;

import DAO.DAOImpl;
import Models.User;

public class UserServiceImpl implements UserService{
    private final DAOImpl dao;

    public UserServiceImpl(DAOImpl dao) {
        this.dao = dao;
    }

    @Override
    public void register(User user) {
        dao.register(user);
    }

    @Override
    public void login() {
        dao.login();
    }
}
