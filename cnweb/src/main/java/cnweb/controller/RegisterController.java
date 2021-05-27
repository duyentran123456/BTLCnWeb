package cnweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cnweb.config.Constant;
import cnweb.model.User;
import cnweb.service.IUserService;
import cnweb.service.impl.UserService;
import cnweb.utils.SecurityHelper;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	private IUserService userService = new UserService();

    public RegisterController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(Constant.Path.GUEST + "/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		password = SecurityHelper.hashed(password);
	
		if(userService.findByUsername(username) != null) {
			request.setAttribute("message", "This username existed!");
			RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.Path.GUEST + "/register.jsp");
			dispatcher.forward(request, response);
			return;
		}
		else {
			User user = new User();
			user.setUsername(username);
			user.setHashedPw(password);
			user.setRole("user");
			int id = userService.register(user);
			user = userService.findById(id);
			request.getSession().setAttribute("user", user);
			request.setAttribute("message", "Successfully registered, please fill your info!");
			request.getRequestDispatcher(Constant.Path.USER + "/myProfile.jsp").forward(request, response);
		}
		
		
	}

}
