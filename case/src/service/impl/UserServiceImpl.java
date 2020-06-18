package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.PageBean;
import domain.User;
import service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @author KuiLian
 * @date 2020/6/6 - 17:35
 */
public class UserServiceImpl implements UserService {
   private UserDao dao= new UserDaoImpl();
    @Override
    public List<User> findAll(){
        return dao.findAll();
    }

    @Override
    public User login(User loginUser) {
        return dao.login(loginUser);
    }

    @Override
    public void addUser(User user) {


        dao.addUser(user);
    }

    @Override
    public void delete(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findById(String id) {
        return dao.findByid(Integer.parseInt(id));
    }

    @Override
    public void update(User user) {
        dao.update(user);
    }

    @Override
    public void deleteSelected(int id) {
        dao.delete(id);
    }

    @Override
    public PageBean findUserByPage(String currentPage_, String rows_, Map<String, String[]> codition) {
        int currentPage = Integer.parseInt(currentPage_);
        int rows = Integer.parseInt(rows_);
        if (currentPage<=0){
            currentPage=1;
        }

        PageBean pb=new PageBean();

        pb.setRows(rows);
      int totalCount=  dao.findTotalCount(codition);
      pb.setTotalCount(totalCount);
      int start=(currentPage-1)*rows;
      List<User> list= dao.findByPage(start,rows,codition);


      pb.setList(list);
      //¼ÆËã×ÜÒ³Âë
        int totalPage= (totalCount%rows)==0?totalCount/rows :(totalCount/rows)+1;

        pb.setTotalPage(totalPage);

        pb.setCurrentPage(currentPage);
        return pb;
    }
}
