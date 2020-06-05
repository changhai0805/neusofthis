package com.neusoft.his.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.his.service.ConstantTypeService;
import com.neusoft.his.service.impl.ConstantTypeServiceImpl;
import com.neusoft.his.util.StringUtil;

/**
 * Servlet implementation class DeleteConstantTypeById
 */
@WebServlet("/DeleteConstantTypeById")
public class DeleteConstantTypeById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteConstantTypeById() {
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

		String id = request.getParameter("id");
		response.setContentType("application/json");
		if(!StringUtil.isBlank(id)) {
			//执行删除
			ConstantTypeService service = new ConstantTypeServiceImpl();
			try {
				int i = service.delete(Integer.parseInt(id));
				if(i > 0) {
					response.getWriter().print("{\"msg\":1}");
				} else {
					response.getWriter().print("{\"msg\":2}");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			response.getWriter().print("{\"msg\":0}");
		}
	}

}
