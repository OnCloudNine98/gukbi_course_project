package com.algoda.word.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.algoda.util.BoardPage;
import com.algoda.voc.model.Myvocdao;
import com.algoda.voc.model.Myvocdto;



@WebServlet("/controller/voc.do")
public class Vocabularycontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Vocabularycontroller() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Myvocdao dao = new Myvocdao();
		Map<String,Object> map = new HashMap<String,Object>();
		
		
		
	      
		 //======================페이지 리스트 를 위한 코드================
		
	      String searchWord = request.getParameter("searchWord");
	      HttpSession session = request.getSession();
	      
	      session.setAttribute("examType", "myvoc");
	      
	      
	      String id= (String)session.getAttribute("id");
	      map.put("id", id);
	      
	      if(searchWord != null) {
	         map.put("searchWord",searchWord);
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
	        
	      
	        List<Myvocdto> boardLists = dao.selectListPage(map);
	        
	        
	        String pagingImg = BoardPage.pagingStr(totalCount, pageSize, blockPage, pageNum, "../controller/voc.do");
	        
	        map.put("pagingImg",pagingImg);
	        map.put("totalCount",totalCount);
	        map.put("pageSize", pageSize);
	        map.put("pageNum", pageNum);
	        
	        request.setAttribute("boardLists", boardLists);
	        request.setAttribute("map",map);
	        
	      //======================리스트 삭제(1단어) 를 위한 코드================

	       String mode= request.getParameter("mode");
	       String word = request.getParameter("word");
	       if(mode!=null && mode.equals("delete")) {
	    	   dao=new Myvocdao();
	    	   int alarm_del = dao.deleteVoc(word,id);
	    
	    	   
	    	   if(alarm_del == 1 ) {
	    		  System.out.println("단어장 해당 단어 삭제 완료");
	    		  response.setContentType("text/html;charset=UTF-8");
		    	  request.setAttribute("alarm_del", alarm_del);
		           
	    	   }else {
	    		  System.out.println("단어장 해당 단어 삭제 실패");
	    	   }
	    	   
	    	   

	    	 //======================리스트 삭제(전체 단어) 를 위한 코드================
	       }else if(mode!=null && mode.equals("deleteAll")) {
	    	   dao=new Myvocdao();
	    	   int alarm_delAll = dao.deleteVocAll(id);
	    	   
	    	   if(alarm_delAll != 0 ) {
		    		  System.out.println("단어장 전체 단어 삭제 완료");
		    		  response.setContentType("text/html;charset=UTF-8");
			    	  request.setAttribute("alarm_delAll", alarm_delAll);
		    	   }else {
		    		  System.out.println("단어장 전체 단어 삭제 실패");
		    	   }
	       }
	       
	       
	       
	       
	       
	       request.getRequestDispatcher("/list/Vocabulary.jsp").forward(request, response);
	      
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	       
	}

}
