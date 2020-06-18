package service;

import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author KuiLian
 * @date 2020/6/6 - 17:34
 */
public interface UserService {
    public List<User> findAll();

    public User login(User loginUser);

    void addUser(User user);

    void delete(String id);

    User findById(String id);

    void update(User user);

    void deleteSelected(int parseInt);

    PageBean findUserByPage(String currentPage, String rows, Map<String, String[]> codition);
}
