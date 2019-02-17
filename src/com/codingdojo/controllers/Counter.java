package com.codingdojo.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Counter")
public class Counter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Counter() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Integer click = (Integer) session.getAttribute("click");
		
		if(click!= null) {
			
			session.setAttribute("click", click+1);
		} else {
			session.setAttribute("click", new Integer(0));
		}
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/view/counter.jsp");
		view.forward(request, response);
	}
		
	
		 
	

	
	
}
