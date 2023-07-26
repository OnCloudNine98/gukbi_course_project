package com.algoda.word.controller;

import com.algoda.util.BoardPage;
import com.algoda.word.model.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.*;


@WebServlet("/controller/word.do")
public class Wordlistcontroller extends HttpServlet {


    public Wordlistcontroller() {
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	request.setCharacterEncoding("utf-8");
    	
        HttpSession session = request.getSession();

        //프로그램 설계를 위해 처음 기본 day값은 1로 세션에 설정
        session.setAttribute("wordDay", "1");
        
        session.setAttribute("examType", "words");


        //단어 레벨 값을 파라미터 값이 있으면 세션에 넣어주고 없으면 세션에서 가져오기
        String wordLevel = request.getParameter("wordLevel");
        if (wordLevel != null) {
            int level = Integer.parseInt(wordLevel);
            System.out.println("wordLevel:"+wordLevel);
            session.setAttribute("wordLevel", wordLevel);
            session.setAttribute("wordLevelQuiz", level);
        } else {
            wordLevel = (String) session.getAttribute("wordLevel");
        }


        //페이지 넘버를 파라미터 값이 있으면 세션에 넣어주고 없으면 세션에서 가져오기
        String pageTemp = request.getParameter("pageNum");

//        if (pageTemp != null) {
//            session.setAttribute("pageTemp", pageTemp);
//        } else {
//            pageTemp = (String) session.getAttribute("pageTemp");
//        }

        //페이지 넘버를 파라미터 값이 있으면 세션에 넣어주고 없으면 세션에서 가져오기(기본 값 1)

        String wordDay = request.getParameter("wordDay");
        if (wordDay != null) {
            int day = Integer.parseInt(wordDay);
            System.out.println(day);
            session.setAttribute("wordDay", wordDay);
            session.setAttribute("wordDayQuiz", day);
        } else {
            wordDay = (String) session.getAttribute("wordDay");
            System.out.println(wordDay);
        }


        Worddao dao;
        if (wordLevel != null && wordLevel.equals("1")) {
            dao = new Wordadao();
            request.setAttribute("section", "중등 영어");
        } else if (wordLevel != null && wordLevel.equals("2")) {
            dao = new Wordbdao();
            request.setAttribute("section", "수능 영어");
        } else if (wordLevel != null && wordLevel.equals("3")) {
            dao = new Wordcdao();
            request.setAttribute("section", "직장인 영어");
        } else {
            dao = null;
        }
        if (dao != null) {
            Map<String, Object> map = new HashMap<String, Object>();

            //======================페이지 리스트 를 위한 코드================

            //검색 단어 파라미터 값 받아오기
            String searchWord = request.getParameter("searchWord");


            if (searchWord != null) {
                map.put("searchWord", searchWord);
                System.out.println(searchWord);
            }

            int totalCount = dao.selectCount(map);

            ServletContext application = getServletContext();
            int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
            int blockPage = Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK"));


            int pageNum = 1;  // 기본값


            if (pageTemp != null && !pageTemp.equals(""))
                pageNum = Integer.parseInt(pageTemp);

            int start = (pageNum - 1) * pageSize + 1;  // 첫 게시물 번호
            int end = pageNum * pageSize; // 마지막 게시물 번호
            map.put("start", start);
            map.put("end", end);


            //단어 DAY값 map에 입력
            map.put("wordDay", wordDay);


            List<Worddto> boardLists = dao.selectListPage(map);


            String pagingImg = BoardPage.pagingStr(totalCount, pageSize, blockPage, wordLevel,wordDay,pageNum , "../controller/word.do");

            map.put("pagingImg", pagingImg);
            map.put("totalCount", totalCount);
            map.put("pageSize", pageSize);
            map.put("pageNum", pageNum);

            request.setAttribute("boardLists", boardLists);
            request.setAttribute("map", map);
            request.setAttribute("wordLevel", wordLevel);


            String insertingword = request.getParameter("word");
            if (insertingword != null) {
                int alarm_addvoc = dao.insertMyvoc(insertingword,(String)session.getAttribute("id"));
                if (alarm_addvoc == 1) {
                    System.out.println("단어장 입력 성공");
		    		  response.setContentType("text/html;charset=UTF-8");
			    	  request.setAttribute("alarm_addvoc", alarm_addvoc);
                } else {
                    System.out.println("단어장 입력 실패");
		    		  response.setContentType("text/html;charset=UTF-8");
			    	  request.setAttribute("alarm_addvoc", alarm_addvoc);
                }
            }
            
            
            
            
            
            request.getRequestDispatcher("/list/Wordlist.jsp").forward(request, response);
        }

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}