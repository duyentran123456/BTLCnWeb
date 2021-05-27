package cnweb.controller.user;

import java.io.IOException;
import java.sql.Timestamp;

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
 * Servlet implementation class EditPostController
 */
@WebServlet("/user/post/edit")
public class EditPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IPostService postService = new PostService();

	public EditPostController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String postId = request.getParameter("id");
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");

		if (postId == null) {
			response.sendRedirect(request.getContextPath() + "/user/post");
			return;
		}
		try {
			int id = Integer.parseInt(postId);
			Post post = postService.findPostById(id);
			if (post != null && post.getAuthorId() == user.getId()) {
				request.setAttribute("post", post);
				request.getRequestDispatcher(Constant.Path.USER + "/editPost.jsp").forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/user/post");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String postId = request.getParameter("id");
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");

		if (postId == null) {
			response.sendRedirect(request.getContextPath() + "/user/post");
			return;
		}
		try {
			int id = Integer.parseInt(postId);
			Post post = postService.findPostById(id);
			if (post != null && post.getAuthorId() == user.getId()) {
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				Timestamp updated_time = new Timestamp(System.currentTimeMillis());

				post.setTitle(title);
				post.setContent(content);
				post.setUpdatedTime(updated_time);
				postService.updatePost(post);

				response.sendRedirect(request.getContextPath() + "/post?id=" + post.getId());
			} else {
				response.sendRedirect(request.getContextPath() + "/user/post");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
