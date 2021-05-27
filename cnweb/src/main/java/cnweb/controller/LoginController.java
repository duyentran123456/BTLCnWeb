package cnweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

import cnweb.config.Constant;
import cnweb.model.User;
import cnweb.service.IUserService;
import cnweb.service.impl.UserService;
import cnweb.utils.SecurityHelper;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	private IUserService userService = new UserService();

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null && (session.getAttribute("user") != null || session.getAttribute("admin") != null)) {
			response.sendRedirect(request.getContextPath() + "/home");
			return;
		}
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(Constant.COOKIE_REMEMBER)) {
					session = request.getSession(true);
					User user = userService.findByUsername(cookie.getValue());
					if(user!= null) {
						request.setAttribute(user.getRole(), user);
						response.sendRedirect(request.getContextPath() + "/home");
						return;
					}
					else {
						break;
					}
				}
			}
		}
		request.getRequestDispatcher(Constant.Path.GUEST + "/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		password = SecurityHelper.hashed(password);

		boolean isRememberMe = false;
		String remember = request.getParameter("remember");

		if ("on".equals(remember)) {
			isRememberMe = true;
		}

		User user = userService.login(username, password);

		if (user != null) {
			HttpSession session = request.getSession();
			if (user.getRole().equals("user")) {
				session.setAttribute("user", user);
			} else if (user.getRole().equals("admin")) {
				session.setAttribute("admin", user);
			}

			if (isRememberMe) {
				saveRemeberMe(response, username);
			}

			response.sendRedirect(request.getContextPath() + "/home");
		} else {
			String message = "Invalid username or password";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.Path.GUEST + "/login.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void saveRemeberMe(HttpServletResponse response, String username) {
		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
		cookie.setMaxAge(30 * 60);
		response.addCookie(cookie);
	}

}
