package com.rojay.wxshop;

import com.rojay.wxshop.generate.User;
import com.rojay.wxshop.generate.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Rojay
 * @version 1.0.0
 * @createTime 2020年12月01日  16:51:26
 */
@Service
public class UserDao {

    private final SqlSessionFactory sqlSessionFactory;

    @Autowired
    public UserDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void insertUser(User user) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            UserMapper mapper =  sqlSession.getMapper(UserMapper.class);
            mapper.insert(user);
        }
    }
}
