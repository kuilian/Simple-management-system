package dao.impl;

import dao.UserDao;
import domain.User;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author KuiLian
 * @date 2020/6/6 - 17:37
 */
public class UserDaoImpl implements UserDao {


    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {


        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User login(User loginUser) {
        try {
            String sql = "select * from user where username=? and password=?";
            User user =
                    template.queryForObject(sql,
                            new BeanPropertyRowMapper<User>(User.class),
                            loginUser.getUsername(),
                            loginUser.getPassword());

            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addUser(User user) {
        String sql="insert into user value(null,null,null,?,?,?,?,?,null)";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(),user.getQq());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from user where id=?";
        template.update(sql,id);
    }

    @Override
    public User findByid(int id) {
        String sql = "select * from user where  id=?";
        return    template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);

    }

    @Override
    public void update(User user) {
        String sql="update user set name=?,gender=?,age=?,address=?,qq=? where id=?";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getId());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> codition) {
        String sql = "select * from user where 1= 1 ";



        StringBuilder sb = new StringBuilder(sql);
        List<Object> param = new ArrayList<Object>();
        Set<String> keySet = codition.keySet();
        for (String key : keySet) {
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = codition.get(key)[0];

            if (value!=null && !"".equals(value))
            {
                sb.append("  and   "+ key +" like  ?  ");
                param.add("%"+value+"%");
            }

        }
        sb.append("  limit ?,?");
        param.add(start);
        param.add(rows);
        sql=sb.toString();
        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),param.toArray());
    }
    /*
    * @Description: ²éÑ¯×Ü¼ÇÂ¼
    * @Date 1:33 2020/6/14
    * @Param []
    * @return int
    */
    @Override
    public int findTotalCount(Map<String, String[]> codition) {
        String sql="select count(*) from user where 1=1  ";
        StringBuilder sb = new StringBuilder(sql);
        List<Object> param = new ArrayList<Object>();
        Set<String> keySet = codition.keySet();
        for (String key : keySet) {
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = codition.get(key)[0];

            if (value!=null && !"".equals(value))
            {
                sb.append("  and   "+ key +" like  ?  ");
                param.add("%"+value+"%");
            }

        }

        System.out.println(sb.toString());
        System.out.println(param);

        return template.queryForObject(sb.toString(),Integer.class,param.toArray());
    }
}
