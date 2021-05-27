package cnweb.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cnweb.config.Constant;
import cnweb.model.User;
import cnweb.service.IUserService;
import cnweb.service.impl.UserService;

/**
 * Servlet implementation class ProfileController
 */
@WebServlet("/user/profile")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IUserService userService = new UserService();	
       
    public ProfileController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(Constant.Path.USER + "/myProfile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// update Profile
		
		String name = request.getParameter("name");
		String about = request.getParameter("about");
		
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		user.setName(name);
		user.setAbout(about);
		
		userService.updateUserInfo(user);
		response.sendRedirect(request.getContextPath() + "/user/profile");
	}

}
