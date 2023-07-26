//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.algoda.member.model;

import com.algoda.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Memberdao {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public Memberdao() {
    }

    public int addMember(Memberdto dto) {
        int insertCount = 0;
        String sql = "insert into member (id, name, pwd, email, tel, hint, hint_asw, scorea, scoreb, scorec, acount, bcount, ccount) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, dto.getId());
            stmt.setString(2, dto.getName());
            stmt.setString(3, dto.getPwd());
            stmt.setString(4, dto.getEmail());
            stmt.setString(5, dto.getTel());
            stmt.setInt(6, dto.getHint());
            stmt.setString(7, dto.getHint_asw());
            stmt.setInt(8, dto.getScorea());
            stmt.setInt(9, dto.getScoreb());
            stmt.setInt(10, dto.getScorec());
            stmt.setInt(11, dto.getAcount());
            stmt.setInt(12, dto.getBcount());
            stmt.setInt(13, dto.getCcount());
            insertCount = this.stmt.executeUpdate();

        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return insertCount;
    }

    public List<Memberdto> listMember() {
        List<Memberdto> memberlist = new ArrayList();
        String sql = "select * from member";

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            this.rs = stmt.executeQuery();

            while (this.rs.next()) {
                Memberdto dto = new Memberdto();
                dto.setId(this.rs.getString(1));
                dto.setName(this.rs.getString(2));
                dto.setPwd(this.rs.getString(3));
                dto.setEmail(this.rs.getString(4));
                dto.setTel(this.rs.getString(5));
                dto.setHint(this.rs.getInt(6));
                dto.setHint_asw(this.rs.getString(7));
                dto.setScorea(this.rs.getInt(8));
                dto.setScoreb(this.rs.getInt(9));
                dto.setScorec(this.rs.getInt(10));
                dto.setAcount(this.rs.getInt(11));
                dto.setBcount(this.rs.getInt(12));
                dto.setCcount(this.rs.getInt(13));
                memberlist.add(dto);
            }


        } catch (Exception var4) {
            var4.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return memberlist;
    }

    public int updateMember(Memberdto dto) {
        int updateCount = 0;
        String sql = "update member set id =?, name=?, pwd=?, email=?, tel=?, hint=?, hint_asw=? scorea=? scoreb=? score=c, acount=?,bcount=? ccount=? where id = ?";

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, dto.getId());
            stmt.setString(2, dto.getName());
            stmt.setString(3, dto.getPwd());
            stmt.setString(4, dto.getEmail());
            stmt.setString(5, dto.getTel());
            stmt.setInt(6, dto.getHint());
            stmt.setString(7, dto.getHint_asw());
            stmt.setInt(8, dto.getScorea());
            stmt.setInt(9, dto.getScoreb());
            stmt.setInt(10, dto.getScorec());
            stmt.setInt(11, dto.getAcount());
            stmt.setInt(12, dto.getBcount());
            stmt.setInt(13, dto.getCcount());
            updateCount = stmt.executeUpdate();
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return updateCount;
    }

    public int deleteMember(Memberdto dto) {
        int deleteCount = 0;
        String sql = "delete from member where id =?";

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, dto.getId());
            deleteCount = stmt.executeUpdate();
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return deleteCount;
    }

    public Memberdto selectloginMember(String id, String pwd) {
        Memberdto dto = null;
        String query = "select id, name, pwd, email, tel, hint, hint_asw, scorea, scoreb, scorec, acount, bcount, ccount from member where id = ? and pwd = ?";

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            stmt.setString(2, pwd);
            this.rs = stmt.executeQuery();
            if (this.rs.next()) {
                dto = new Memberdto();
                dto.setId(this.rs.getString(1));
                dto.setName(this.rs.getString(2));
                dto.setPwd(this.rs.getString(3));
                dto.setEmail(this.rs.getString(4));
                dto.setTel(this.rs.getString(5));
                dto.setHint(this.rs.getInt(6));
                dto.setHint_asw(this.rs.getString(7));
                dto.setScorea(this.rs.getInt(8));
                dto.setScoreb(this.rs.getInt(9));
                dto.setScorec(this.rs.getInt(10));
                dto.setAcount(this.rs.getInt(11));
                dto.setBcount(this.rs.getInt(12));
                dto.setCcount(this.rs.getInt(13));
            }

            this.rs.close();

        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return dto;
    }

    public Memberdto searchId(String email, int hint, String hint_asw) {
        Memberdto dto = null;
        String query = "SELECT id,name FROM member WHERE email = ?  AND hint = ? AND hint_asw = ?";

        try {
        	conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
           
            stmt.setInt(2, hint);
            stmt.setString(3, hint_asw);
            rs = stmt.executeQuery();

            if (rs.next()) {
                dto = new Memberdto();
                dto.setId(rs.getString(1));
                dto.setName(rs.getString(2));
                
              
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return dto;
    }

    public Memberdto searchPwd(String id, String email, int hint, String hint_asw) {
        Memberdto dto = null;
        String query = "SELECT pwd,name FROM member WHERE id = ? and email = ? AND hint = ? AND hint_asw = ?";

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            stmt.setString(2, email);
            stmt.setInt(3, hint);
            stmt.setString(4, hint_asw);
            this.rs = stmt.executeQuery();
            if (this.rs.next()) {
                dto = new Memberdto();
                dto.setPwd(this.rs.getString(1));
                dto.setName(this.rs.getString(2));
            }


        } catch (Exception var8) {
            var8.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return dto;
    }

    public int checkId(String id) {
        String sql = "select * from member where id =?";
        int idCheck = 0;

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
            this.rs = stmt.executeQuery();
            if (!this.rs.next() && !id.equals("")) {
                idCheck = 1;
            } else {
                idCheck = 0;
            }
        } catch (SQLException var8) {
            var8.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return idCheck;
    }

    public int checkword(String word) {
        String sql = "select * from VOCAA where word =?";
        int wordCheck = 0;

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, word);
            this.rs = stmt.executeQuery();
            if (!this.rs.next() && !word.equals("")) {
                sql = "select * from VOCAB where word =?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, word);
                this.rs = stmt.executeQuery();
                if (!this.rs.next() && !word.equals("")) {
                    sql = "select * from VOCAC where word =?";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, word);
                    this.rs = stmt.executeQuery();
                    if (!this.rs.next() && !word.equals("")) {
                        wordCheck = 1;
                    } else {
                        wordCheck = 0;
                    }
                } else {
                    wordCheck = 0;
                }
            } else {
                wordCheck = 0;
            }
        } catch (SQLException var8) {
            var8.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return wordCheck;
    }

    public Memberdto getMemberByEmail(String email) throws SQLException {
        Memberdto dto = null;
        String sql = "SELECT * FROM member WHERE email = ?";
        conn = JDBCUtil.getConnection();
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, email);
        this.rs = stmt.executeQuery();
        if (this.rs.next()) {
            dto = new Memberdto();
            dto.setId(this.rs.getString("id"));
            dto.setName(this.rs.getString("name"));
            dto.setPwd(this.rs.getString("pwd"));
            dto.setEmail(this.rs.getString("email"));
            dto.setTel(this.rs.getString("tel"));
            dto.setHint(this.rs.getInt("hint"));
            dto.setHint_asw(this.rs.getString("hint_asw"));
            dto.setScorea(this.rs.getInt("scorea"));
            dto.setScoreb(this.rs.getInt("scoreb"));
            dto.setScorec(this.rs.getInt("scorec"));
            dto.setAcount(this.rs.getInt("acount"));
            dto.setBcount(this.rs.getInt("bcount"));
            dto.setCcount(this.rs.getInt("ccount"));
            System.out.println("dto" + this.rs.getString("email"));
        }
        JDBCUtil.close(rs, stmt, conn);


        return dto;
    }

    public void updateMemberPassword(Memberdto member) throws SQLException {
        try {
            conn = JDBCUtil.getConnection();
            String sql = "UPDATE member SET pwd = ? WHERE email = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, member.getPwd());
            stmt.setString(2, member.getEmail());
            stmt.executeUpdate();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

    }
}
