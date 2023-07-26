package com.algoda.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.algoda.member.model.Memberdao;
import com.algoda.member.model.Memberdto;
import com.algoda.util.DBConnPool;

@WebServlet("/controller/login.do")
public class Idfindcontroller extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
   
    public Idfindcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }
    
//    public class IdfindService {
//    }
    
    

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
       
      String email = request.getParameter("email");
      
      int hint = Integer.parseInt(request.getParameter("hint"));
      String hint_asw = request.getParameter("hint_asw");
      
      System.out.println(email+hint+hint_asw);
      
          
          
          Memberdao memberdao = new Memberdao();

            Memberdto mdto = memberdao.searchId(email, hint, hint_asw);

           
      
      
   
      
      
      System.out.println("dto : " + mdto);

      if(mdto != null) {
         
         request.setAttribute("memberdto", mdto);
         request.getRequestDispatcher("/login/searchId.jsp").forward(request, response);
         
      }else {
         response.setContentType("text/html; charset=UTF-8");
           PrintWriter out = response.getWriter();
           out.println("<script>");
           out.println("alert('등록된 정보가 없습니다')");
           out.println("history.back()");
           out.println("</script>");
      }
      
      
      
   }
    
    

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}