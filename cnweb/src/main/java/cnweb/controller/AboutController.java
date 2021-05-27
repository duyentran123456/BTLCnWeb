package cnweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cnweb.config.Constant;
import cnweb.model.Post;
import cnweb.model.User;
import cnweb.service.IPostService;
import cnweb.service.IUserService;
import cnweb.service.impl.PostService;
import cnweb.service.impl.UserService;

/**
 * Servlet implementation class AboutController
 */
@WebServlet("/about")
public class AboutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IUserService userService = new UserService();
	private IPostService postService = new PostService();

	public AboutController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String authorIdStr = request.getParameter("id");
		if(authorIdStr == null) {
			List<User> users = userService.findAll();
			request.setAttribute("users", users);
			
			request.getRequestDispatcher(Constant.Path.GUEST + "/users.jsp").forward(request, response);
			return;
		}
		
		try {
			int authorId = Integer.parseInt(authorIdStr);

			User author = userService.findById(authorId);
			List<Post> posts = postService.findPostByAuthor(authorId);
			
			request.setAttribute("author", author);
			request.setAttribute("posts", posts);
			
			request.getRequestDispatcher(Constant.Path.GUEST + "/about.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/about");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
