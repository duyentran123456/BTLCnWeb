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
import cnweb.model.Comment;
import cnweb.model.User;
import cnweb.service.ICommentService;
import cnweb.service.impl.CommentService;

/**
 * Servlet implementation class CommentController
 */
@WebServlet("/user/comment")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ICommentService commentService = new CommentService();
       
    public CommentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		User user = (User)session.getAttribute("user");
		
		List<Comment> comments = commentService.findByAuthor(user.getId());
		request.setAttribute("comments", comments);
		request.getRequestDispatcher(Constant.Path.USER + "/myComments.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String commentId = request.getParameter("id");
		HttpSession session = request.getSession(false);
		User user = (User)session.getAttribute("user");
		
		if(commentId == null) {
			response.sendRedirect(request.getContextPath() + "/user/comment");
			return;
		} 
		try {
			int id = Integer.parseInt(commentId);
			Comment comment = commentService.findById(id);
			if(comment!=null && comment.getId()==user.getId()) {
				commentService.deleteComment(id);
				response.sendRedirect(request.getContextPath() + "/user/comment");
				return;
			} else {
				response.sendRedirect(request.getContextPath() + "/user/comment");
				return;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
