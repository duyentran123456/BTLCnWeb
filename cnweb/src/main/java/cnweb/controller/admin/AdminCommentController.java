package cnweb.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cnweb.config.Constant;
import cnweb.model.Comment;
import cnweb.service.ICommentService;
import cnweb.service.impl.CommentService;

/**
 * Servlet implementation class AdminCommentController
 */
@WebServlet("/admin/comment")
public class AdminCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ICommentService commentService = new CommentService();
       
    public AdminCommentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Comment> comments = commentService.findAll();
		request.setAttribute("comments", comments);
		request.getRequestDispatcher(Constant.Path.ADMIN + "/manageComment.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String commentId = request.getParameter("id");
		if(commentId == null) {
			response.sendRedirect(request.getContextPath() + "/admin/comment");
		} else {
			try {
				int id = Integer.parseInt(commentId);
				commentService.deleteComment(id);
				response.sendRedirect(request.getContextPath() + "/admin/comment");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
