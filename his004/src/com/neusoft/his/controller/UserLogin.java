package com.neusoft.his.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.his.entity.User;
import com.neusoft.his.service.UserService;
import com.neusoft.his.service.impl.UserServiceImpl;
import com.neusoft.his.util.StringUtil;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
//		 接收用户名和密码
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		String yzm = request.getParameter("yzm");
		String checkcode = (String)request.getSession().getAttribute("checkcode");
		if(yzm.trim().toLowerCase().equals(checkcode.toLowerCase())) {
		
			if(StringUtil.isBlank(uname) || StringUtil.isBlank(pwd)) {
				response.sendRedirect("login.jsp");
			} else {
				UserService service = new UserServiceImpl();
				try {
					User user = service.findUserByUnamePwd(uname, pwd);
					if(null == user) {
						//用户名或者错误
						request.setAttribute("msg", "用户名或密码错误");
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}else {
						//登录成功
						HttpSession session = request.getSession();
						session.setAttribute("user", user);
						response.sendRedirect("index.jsp");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		
	} else {
		request.setAttribute("msg", "验证码无效");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	}
}
