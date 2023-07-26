//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.algoda.voc.model;

import com.algoda.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Myvocdao {
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public Myvocdao() {
    }

    public List<Myvocdto> selectListPage(Map<String, Object> map) {
        List<Myvocdto> board = new ArrayList();
        String query = " SELECT * FROM (     SELECT Tb.*, ROWNUM rNum FROM (         SELECT * FROM sel  WHERE id ='" + map.get("id") + "'";
        if (map.get("searchWord") != null) {
            query = query + " and word LIKE '%" + map.get("searchWord") + "%' ";
        }

        query = query + "        ORDER BY WORD ASC     ) Tb  )  WHERE rNum BETWEEN ? AND ?";

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, map.get("start").toString());
            stmt.setString(2, map.get("end").toString());
            rs = stmt.executeQuery();

            while (this.rs.next()) {
                Myvocdto dto = new Myvocdto();
                dto.setWord(this.rs.getString(1));
                dto.setMEANINGA(this.rs.getString(2));
                dto.setMEANINGB(this.rs.getString(3));
                dto.setMEANINGC(this.rs.getString(4));
                dto.setSIMILAR_WORDA(this.rs.getString(5));
                dto.setSIMILAR_WORDB(this.rs.getString(6));
                dto.setSIMILAR_WORDC(this.rs.getString(7));
                dto.setDAY(this.rs.getInt(8));
                dto.setID(this.rs.getString(9));
                dto.setWORD_LEVEL(this.rs.getInt(10));
                board.add(dto);
            }
        } catch (Exception var5) {
            System.out.println("게시물 조회 중 예외 발생");
            var5.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return board;
    }

    public int selectCount(Map<String, Object> map) {
        int totalCount = 0;
        String query = "SELECT COUNT(*) FROM sel";
        if (map.get("searchWord") != null) {
            query = query + " WHERE word  LIKE '%" + map.get("searchWord") + "%'";
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
            JDBCUtil.close(rs, stmt, conn);
        }

        return totalCount;
    }

    public int deleteVoc(String word, String id) {
        int result = 0;

        try {
            String query = "DELETE FROM SEL WHERE word=? and id='" + id + "'";
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, word);
            result = stmt.executeUpdate();
        } catch (Exception var5) {
            System.out.println("게시물 삭제 중 예외 발생");
            var5.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return result;
    }

    public int deleteVocAll(String id) {
        int result = 0;

        try {
            String query = "DELETE FROM SEL where id='" + id + "'";
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(query);
            result = stmt.executeUpdate();
        } catch (Exception var4) {
            System.out.println("게시물 삭제 중 예외 발생");
            var4.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return result;
    }

    public List<Myvocdto> selectExamList() {
        List<Myvocdto> board = new ArrayList();
        String query = "SELECT * FROM SEL";

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(query);
            rs = this.stmt.executeQuery();

            while (this.rs.next()) {
                Myvocdto dto = new Myvocdto();
                dto.setWord(this.rs.getString(1));
                dto.setMEANINGA(this.rs.getString(2));
                dto.setMEANINGB(this.rs.getString(3));
                dto.setMEANINGC(this.rs.getString(4));
                dto.setSIMILAR_WORDA(this.rs.getString(5));
                dto.setSIMILAR_WORDB(this.rs.getString(6));
                dto.setSIMILAR_WORDC(this.rs.getString(7));
                dto.setDAY(this.rs.getInt(8));
                dto.setID(this.rs.getString(9));
                dto.setWORD_LEVEL(this.rs.getInt(10));
                board.add(dto);
            }
        } catch (Exception var4) {
            System.out.println("게시물 조회 중 예외 발생");
            var4.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return board;
    }
}
