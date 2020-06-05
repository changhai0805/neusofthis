package com.neusoft.his.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neusoft.his.entity.RegistLevel;
import com.neusoft.his.service.RegistLevelService;
import com.neusoft.his.service.impl.RegistLevelServiceImpl;
import com.neusoft.his.util.PageBean;
import com.neusoft.his.util.StringUtil;

@WebServlet("/FindRegistLevel")
public class FindRegistLevel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindRegistLevel() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//首先定义分页对象
		PageBean<RegistLevel> pageBean = new PageBean<RegistLevel>();
		
		//获取当前页
		String curpageStr = request.getParameter("currentPage");
		int currentPage = StringUtil.isBlank(curpageStr)?1:Integer.parseInt(curpageStr);
		pageBean.setCurrentPage(currentPage);
		//定义每页记录数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		
		//定义业务层对象，
		RegistLevelService service = new RegistLevelServiceImpl();
		//获取总记录条数
		try {
			int totalCount = service.getTotalCount();
			
			//获取数据
			List<RegistLevel> list = service.findRegistLevels(pageBean.getBeginIndex(), pageSize);
			//将数据存放到pageBean中
			pageBean.setTotalCount(totalCount);
			pageBean.setPageData(list);
			
			//将pageBean转成json对象，响应给前端
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(pageBean);
//			System.out.println(json);
			//将响应类型设置为json
			response.setContentType("application/json");
			response.getWriter().print(json);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
