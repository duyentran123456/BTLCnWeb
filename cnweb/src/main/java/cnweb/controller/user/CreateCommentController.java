package cnweb.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cnweb.model.Comment;
import cnweb.model.User;
import cnweb.service.ICommentService;
import cnweb.service.impl.CommentService;

/**
 * Servlet implementation class CreateCommentController
 */
@WebServlet("/user/comment/create")
public class CreateCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ICommentService commentService = new CommentService();
       
    public CreateCommentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("trying to create a comment!");
		HttpSession session = request.getSession(false);
		User user = (User)session.getAttribute("user");
		
		String postId = request.getParameter("postId");
		String content = request.getParameter("content");
		
		if(postId == null) {
			response.sendRedirect(request.getContextPath() + "/home");
			return;
		}
		try {
			int id = Integer.parseInt(postId);
			Comment comment = new Comment();
			comment.setPostId(id);
			comment.setContent(content);
			comment.setUserId(user.getId());
			commentService.newComment(comment);
			response.sendRedirect(request.getContextPath() + "/post?id=" + id);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
