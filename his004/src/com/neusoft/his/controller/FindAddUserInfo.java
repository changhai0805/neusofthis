package com.neusoft.his.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neusoft.his.entity.User;
import com.neusoft.his.service.UserService;
import com.neusoft.his.service.impl.UserServiceImpl;

/**
 * Servlet implementation class FindAddUserInfo
 */
@WebServlet("/FindAddUserInfo")
public class FindAddUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAddUserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//定义service
		UserService service = new UserServiceImpl();
		
		try {
			Map<String, List> map = service.findAddUserInfo();
			
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(map);
			//System.out.println(json);
			response.setContentType("application/json");
			response.getWriter().print(json);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}

}
