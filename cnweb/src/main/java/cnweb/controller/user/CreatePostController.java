package cnweb.controller.user;

import java.io.IOException;
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
@WebServlet("/user/post/create")
public class CreatePostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IPostService postService = new PostService();
       
    public CreatePostController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(Constant.Path.USER + "/createPost.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		User author = (User)session.getAttribute("user");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Post post = new Post();
		post.setAuthorId(author.getId());
		post.setTitle(title);
		post.setContent(content);
		
		int newId = postService.newPost(post);
		response.sendRedirect(request.getContextPath() + "/post?id=" + newId);
	}

}
