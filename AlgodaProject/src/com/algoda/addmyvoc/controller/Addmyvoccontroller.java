package com.algoda.addmyvoc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.algoda.word.model.Wordadao;
import com.algoda.word.model.Wordbdao;
import com.algoda.word.model.Wordcdao;


@WebServlet("/Addmyvoc.do")
public class Addmyvoccontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public Addmyvoccontroller() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//레벨 별로 넣을 단어 파라미터로 받아옴
		String level= request.getParameter("level");
		String insertingword= request.getParameter("insertingword");
		
		
		//세션에서 아이디 값 받아오기
		String id=(String)session.getAttribute("id");
		int result=0;
		
		if(level.equals("1")) {
			Wordadao worda= new Wordadao();
			result=worda.insertMyvoc(insertingword,id);
			
		}else if(level.equals("2")) {
			Wordbdao wordb= new Wordbdao();
			result=wordb.insertMyvoc(insertingword,id);
		}else if(level.equals("3")) {
			Wordcdao wordc= new Wordcdao();
			result=wordc.insertMyvoc(insertingword,id);
		}
		
		if(result==1) {
			System.out.println("단어장 단어 입력 성공");

//        	JOptionPane.showMessageDialog(null, "알림 메시지", "성공", JOptionPane.INFORMATION_MESSAGE);
		}else {
			System.out.println("이미 단어장에 해당 단어가 있습니다.");
		}
		
		response.sendRedirect("word/Main.jsp");
	}

}
