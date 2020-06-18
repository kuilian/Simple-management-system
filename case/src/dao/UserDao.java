package dao;

import domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author KuiLian
 * @date 2020/6/6 - 17:37
 */
public interface UserDao {
    public List<User> findAll();
    public User login(User loginUser);

    void addUser(User user);

    void delete(int parseInt);

    User findByid(int parseInt);

    void update(User user);

    List<User> findByPage(int start, int rows, Map<String, String[]> codition);

    int findTotalCount(Map<String, String[]> codition);
}
