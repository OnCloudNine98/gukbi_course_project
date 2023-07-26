//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.algoda.board.model;

import com.algoda.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Boarddao {
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public Boarddao() {
    }

    public List<Boarddto> selectListPage(Map<String, Object> map) {
        List<Boarddto> board = new ArrayList();
        String query = " SELECT * FROM (     SELECT Tb.*, ROWNUM rNum FROM (         SELECT * FROM board ";
        if (map.get("searchWord") != null) {
            query = query + " where title LIKE '%" + map.get("searchWord") + "%' ";
        }

        query = query + "        ORDER BY title ASC     ) Tb  )  WHERE rNum BETWEEN ? AND ?";

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, map.get("start").toString());
            stmt.setString(2, map.get("end").toString());
            this.rs = stmt.executeQuery();

            while (this.rs.next()) {
                Boarddto dto = new Boarddto();
                dto.setTitle(this.rs.getString(1));
                dto.setWriter(this.rs.getString(2));
                dto.setUpdate_pwd(this.rs.getString(3));
                dto.setContent(this.rs.getString(4));
                dto.setPostdate(this.rs.getDate(5));
                dto.setVisitcount(this.rs.getInt(6));
                dto.setID(this.rs.getString(7));
                board.add(dto);
            }
        } catch (Exception var5) {
            System.out.println("게시물 조회 중 예외 발생");
            var5.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }

        return board;
    }

    public int selectCount(Map<String, Object> map) {
        int totalCount = 0;
        String query = "SELECT COUNT(*) FROM board";
        if (map.get("searchWord") != null) {
            query = query + " WHERE title  LIKE '%" + map.get("searchWord") + "%'";
        }

        try {
            conn = JDBCUtil.getConnection();
            this.stmt = conn.prepareStatement(query);
            this.rs = this.stmt.executeQuery();
            this.rs.next();
            totalCount = this.rs.getInt(1);
        } catch (Exception var5) {
            System.out.println("게시물 카운트 중 예외 발생");
            var5.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }

        return totalCount;
    }

    public int insertBoard(Boarddto dto) {
        int result = 0;
        String query = "insert into board(  title,writer,update_pwd,content,visitcount,id)  values (  ?,? ,? ,? ,0,?)";

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, dto.getTitle());
            stmt.setString(2, dto.getWriter());
            stmt.setString(3, dto.getUpdate_pwd());
            stmt.setString(4, dto.getContent());
            stmt.setString(5, dto.getID());
            result = stmt.executeUpdate();
        } catch (SQLException var5) {
            var5.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }

        return result;
    }

    public Boarddto selectView(String title) {
        Boarddto dto = new Boarddto();
        String query = "SELECT * FROM board WHERE title=?";

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, title);
            this.rs = stmt.executeQuery();
            if (this.rs.next()) {
                dto.setTitle(this.rs.getString(1));
                dto.setWriter(this.rs.getString(2));
                dto.setUpdate_pwd(this.rs.getString(3));
                dto.setContent(this.rs.getString(4));
                dto.setPostdate(this.rs.getDate(5));
                dto.setVisitcount(this.rs.getInt(6));
                dto.setID(this.rs.getString(7));
            }
        } catch (Exception var5) {
            System.out.println("게시물 상세보기 중 예외 발생");
            var5.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }

        return dto;
    }

    public void updateVisitCount(String title) {
        String query = "UPDATE board set visitcount=visitcount+1  where title=?";

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, title);
            stmt.executeQuery();
        } catch (Exception var4) {
            System.out.println("게시물 조회수 증가 중 예외 발생");
            var4.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }

    }

    public int deletePost(String title) {
        int result = 0;

        try {
            conn = JDBCUtil.getConnection();
            String query = "DELETE FROM board WHERE title=?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, title);
            result = stmt.executeUpdate();
        } catch (Exception var4) {
            System.out.println("게시물 삭제 중 예외 발생");
            var4.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }

        return result;
    }

    public int updatePost(String title, String context, String writer, String update_pwd) {
        int result = 0;

        try {
            conn = JDBCUtil.getConnection();
            String query = "UPDATE board SET title=?, content=? WHERE writer=? and update_pwd=?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, title);
            stmt.setString(2, context);
            stmt.setString(3, writer);
            stmt.setString(4, update_pwd);
            result = stmt.executeUpdate();
        } catch (Exception var7) {
            System.out.println("게시물 수정 중 예외 발생");
            var7.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }

        return result;
    }
}
