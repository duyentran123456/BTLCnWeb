package cnweb.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cnweb.config.Constant;
import cnweb.model.Post;
import cnweb.model.User;
import cnweb.service.IPostService;
import cnweb.service.impl.PostService;

/**
 * Servlet implementation class PostController
 */
@WebServlet("/user/post")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IPostService postService = new PostService();
       
    public PostController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		User user = (User)session.getAttribute("user");
		
		List<Post> posts = postService.findPostByAuthor(user.getId());
		request.setAttribute("posts", posts);
		request.getRequestDispatcher(Constant.Path.USER + "/myPosts.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession(false).getAttribute("user");
		String postId = request.getParameter("id");
		if(postId == null) {
			response.sendRedirect(request.getContextPath() + "/user/post");
			return;
		}
		try {
			int id = Integer.parseInt(postId);
			Post post = postService.findPostById(id);
			if(post!=null && post.getAuthorId() == user.getId()) {
				postService.deletePost(id);
				response.sendRedirect(request.getContextPath() + "/user/post");
				return;
			} else {
				response.sendRedirect(request.getContextPath() + "/user/post");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
