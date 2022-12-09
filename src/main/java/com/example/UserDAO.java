package com.example;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
    final
    SqlSessionTemplate sqlSession;

    public UserDAO(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public UserVO getUser(UserVO vo) {
        return sqlSession.selectOne("User.getUser", vo);
    }
}
