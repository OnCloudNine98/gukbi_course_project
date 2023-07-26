package com.algoda.user.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algoda.member.model.Memberdto;
import com.algoda.member.model.Memberdao;
import com.algoda.smtp.NaverSMTP;

@WebServlet("/controller/forgotpwd.do")
public class Pwdfindmailcontroller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        
        System.out.println("email : " + email);
        
        
        
        // 이메일 주소를 가진 멤버를 데이터베이스에서 검색
        Memberdao dao = new Memberdao();
        Memberdto dto = null;
        try {
            dto = dao.getMemberByEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (dto != null) {
            // 임시 비밀번호 생성
            String temporaryPassword = generateRandomPassword(10);

            // 임시 비밀번호를 멤버 객체에 설정
            dto.setPwd(temporaryPassword);

            // 멤버의 비밀번호를 임시 비밀번호로 업데이트
            try {
                dao.updateMemberPassword(dto);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // 임시 비밀번호를 이메일로 발송하기 위한 정보 설정
            request.setCharacterEncoding("utf-8");
            Map<String, String> emailInfo = new HashMap<>();
            emailInfo.put("from", "dgeth@naver.com"); // 발신자 이메일 주소
            emailInfo.put("to", email); // 수신자 이메일 주소
            emailInfo.put("subject", "ALGODA에서 보내는 임시 비밀번호입니다."); // 이메일 제목
            emailInfo.put("format", "text/plain"); // 이메일 형식 (텍스트)
            emailInfo.put("content","Your temporary password : " + temporaryPassword); // 이메일 내용

            try {
                NaverSMTP smtpServer = new NaverSMTP(); // 메일 전송 클래스 생성
                smtpServer.emailSending(emailInfo); // 이메일 발송
                request.setAttribute("message", "이메일이 발송되었습니다. 임시 비밀번호를 확인 후 임시비밀번호로 재로그인해주세요.");
            } catch (MessagingException e) {
                e.printStackTrace();
                request.setAttribute("message", "이메일 발송 실패");
            }
        } else {
            request.setAttribute("message", "해당 이메일 주소로 가입된 회원이 없습니다.");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/login/Pwdresult.jsp");  
        dispatcher.forward(request, response);
    }

    // 임시 비밀번호 생성 메서드
    private String generateRandomPassword(int length) {
        String charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(charset.length());
            password.append(charset.charAt(randomIndex));
        }
        
        return password.toString();
    }
}