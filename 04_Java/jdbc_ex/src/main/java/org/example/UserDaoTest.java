package org.example;

import org.example.common.JDBCUtil;
import org.example.dao.UserDAO;
import org.example.domain.UserVO;

import java.util.List;

public class UserDaoTest {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        UserVO user = new UserVO("ssamz3", "ssamz123", "쌤즈", "ADMIN");

        System.out.println("InsertUser ================");
        dao.insertUser(user);

        System.out.println("getUserList ================");
        List<UserVO> list = dao.getUserList();
        for (UserVO vo : list) {
            System.out.println(vo);
        }

        System.out.println("updateUser ================");
        user.setName("쌤즈3");
        dao.updateUser(user);

        System.out.println("getUserDetail ================");
        UserVO user2 = dao.getUser("ssamz3");
        System.out.println(user2);

        System.out.println("deleteUser ================");
        dao.deleteUser("ssamz3");

        JDBCUtil.close();
    }
}
