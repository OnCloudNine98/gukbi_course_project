package com.algoda.board.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.algoda.board.model.Boarddao;
import com.algoda.board.model.Boarddto;


@WebServlet("/boardview.do")
public class Boardviewcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Boardviewcontroller() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Boarddao dao = new Boarddao();
		Boarddto dto = new Boarddto();
		
		String title = request.getParameter("title");
		String mode = request.getParameter("mode");
		
		//boardview화면 처리에서만 조회수 처리
		if(title!=null && mode==null ) {
		dao.updateVisitCount(title);
		}
		
		dto= dao.selectView(title);
		
		
		//게시물 엔터 내용 엔터 처리
		dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));
		
		//쿼리 스트링으로 넘겨주기 위한 과정
		title=dto.getTitle();
		String writer= dto.getWriter();
		
		//date값은 쿼리 스트링으로 넘겨주기 곤란해 , String으로 고쳐서 그냥 session값에 넣어 넘겨줌
		Date date= new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String postdate = dateFormat.format(dto.getPostdate());
		
		HttpSession session = request.getSession();
		session.setAttribute("view_postdate", postdate);
		
		
		
		int visitcount=dto.getVisitcount();
		String content= dto.getContent();
		
		
		String update_pwd=dto.getUpdate_pwd();
		
		
		//boardview화면 처리와 editview화면 처리 구분
		if(title!=null && mode==null ) {
//			request.getRequestDispatcher("board/View.jsp").forward(request, response);
			response.sendRedirect("board/View.jsp?title="+title+"&writer="+writer
									+"&visitcount="+visitcount+"&content="+content);
		}
		else if((title!=null && mode!=null && mode.equals("editview"))) {
			response.sendRedirect("board/Edit.jsp?title="+title+"&writer="+writer
									+"&update_pwd="+update_pwd+"&content="+content);
		
		}
		
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
