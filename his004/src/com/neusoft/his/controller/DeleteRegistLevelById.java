package com.neusoft.his.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.his.service.RegistLevelService;
import com.neusoft.his.service.impl.RegistLevelServiceImpl;
import com.neusoft.his.util.StringUtil;

/**
 * Servlet implementation class DeleteRegistLevelById
 */
@WebServlet("/DeleteRegistLevelById")
public class DeleteRegistLevelById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteRegistLevelById() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		response.setContentType("application/json");
		if(!StringUtil.isBlank(id)){
			
			RegistLevelService service = new RegistLevelServiceImpl();
			try {
				int i = service.delete(Integer.parseInt(id));
				if(i>0){
					response.getWriter().print("{\"msg\":1}");
				}else{
					response.getWriter().print("{\"msg\":2}");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}else{
			response.getWriter().print("{\"msg\":0}");
		}
	}

}
