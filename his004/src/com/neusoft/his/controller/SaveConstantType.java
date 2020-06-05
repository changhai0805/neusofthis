package com.neusoft.his.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.his.entity.ConstantType;
import com.neusoft.his.service.ConstantTypeService;
import com.neusoft.his.service.impl.ConstantTypeServiceImpl;
import com.neusoft.his.util.StringUtil;

/**
 * Servlet implementation class SaveConstantType
 */
@WebServlet("/SaveConstantType")
public class SaveConstantType extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveConstantType() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		// 接收请求数据
		String vid = request.getParameter("id");

		String code = request.getParameter("code");
		String name = request.getParameter("name");

		ConstantType constantType = new ConstantType();
		constantType.setConstantTypeName(name);
		constantType.setConstantTypeCode(code);

		ConstantTypeService service = new ConstantTypeServiceImpl();
		int i = 0;
		try {
			if (StringUtil.isBlank(vid)) {
				// 调用添加业务
				i = service.add(constantType);
			} else {
				// 调用修改业务
				constantType.setId(Integer.parseInt(vid));
				i = service.update(constantType);
			}
			
			if(i > 0) {
				response.getWriter().print("{\"msg\":1}");
			} else {
				response.getWriter().print("{\"msg\":0}");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
