package com.example;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BoardDAO {
    @Autowired
    SqlSession sqlSession;

    /*
    JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private final String BOARD_INSERT = "insert into BOARD ( title, writer, content) values (?,?,?)";
    private final String BOARD_UPDATE = "update BOARD set title =?, writer=?, content=? where seq=?";
    private final String BOARD_DELETE = "delete from BOARD where seq=?";
    private final String BOARD_GET = "select * from BOARD where seq = ?";
    private final String BOARD_LIST ="select*from BOARD order by seq desc";*/

    public int insertBoard(BoardVO vo){
        int result = sqlSession.insert("Board.insertBoard", vo);
        return result;
    }

    public int deleteBoard(int seq){
        int result = sqlSession.delete("Board.deleteBoard", seq);
        return result;
    }

    public int updateBoard(BoardVO vo){
        int result = sqlSession.update("Board.updateBoard", vo);
        return result;
    }


    /*private final String BOARD_GET = "select * from BOARD where seq =?";

    public BoardVO getBoard(int seq){
        return jdbcTemplate.queryForObject(BOARD_GET, new Object[]{seq}, new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
    }

    private final String BOARD_LIST = "select * from BOARD order by seq desc";
*/

    class BoardRowMapper implements RowMapper<BoardVO>{
        @Override
        public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            BoardVO data = new BoardVO();
            data.setSeq(rs.getInt("seq"));
            data.setTitle(rs.getString("title"));
            data.setContent(rs.getString("content"));
            data.setWriter(rs.getString("writer"));
            data.setRegdate(rs.getDate("regdate"));
            return data;
        }
    }

    public BoardVO getBoard(int seq){
        BoardVO one = sqlSession.selectOne("Board.getBoard", seq);
        return one;
    }

    public List<BoardVO> getBoardList(){
        List<BoardVO> list= sqlSession.selectList("Board.getBoardList");
        return list;
    }



}

