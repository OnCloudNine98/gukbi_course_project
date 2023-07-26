package com.algoda.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algoda.board.model.Boarddao;
import com.algoda.board.model.Boarddto;
import com.algoda.util.BoardPage;

@WebServlet("/boardlist.do")
public class Boardlistcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public Boardlistcontroller() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boarddao dao = new Boarddao();
		Map<String,Object> map = new HashMap<String,Object>();
		
		
		String search = request.getParameter("searchWord");
		 if(search != null) {
	         map.put("searchWord",search);
	      }
		 
		 int totalCount = dao.selectCount(map);
		 
		 ServletContext application = getServletContext();
	        int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
	        int blockPage = Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK"));
	        int pageNum = 1;  // 기본값
	        String pageTemp = request.getParameter("pageNum");
	        
	        if (pageTemp != null && !pageTemp.equals(""))
	            pageNum = Integer.parseInt(pageTemp);
	        
	        int start = (pageNum - 1) * pageSize + 1;  // 첫 게시물 번호
	        int end = pageNum * pageSize; // 마지막 게시물 번호
	        map.put("start", start);
	        map.put("end", end);
	        
	      
	        List<Boarddto> boardLists = dao.selectListPage(map);

	        
	        String pagingImg = BoardPage.pagingStr(totalCount, pageSize, blockPage, pageNum, "./boardlist.do");
	        
	        map.put("pagingImg",pagingImg);
	        map.put("totalCount",totalCount);
	        map.put("pageSize", pageSize);
	        map.put("pageNum", pageNum);
	        
	        request.setAttribute("boardLists", boardLists);
	        request.setAttribute("map",map);
	        
	        
	        
	        
	        request.getRequestDispatcher("/board/Board.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
