package cnweb.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cnweb.config.Constant;
import cnweb.model.Post;
import cnweb.service.IPostService;
import cnweb.service.impl.PostService;

/**
 * Servlet implementation class AdminPostController
 */
@WebServlet("/admin/post")
public class AdminPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	private IPostService postService = new PostService();
       
    public AdminPostController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page, index, totalPages, totalPosts;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch(Exception e) {
			page = 1;
		}
		
		List<Post> posts = postService.findAll();
		if(posts == null || posts.size() == 0) {
			totalPages = 1;
		} else {
			totalPosts = posts.size();
			totalPages = totalPosts % Constant.ITEMS_PER_PAGE == 0 ? totalPosts/Constant.ITEMS_PER_PAGE : totalPosts/Constant.ITEMS_PER_PAGE+1;
		}
		if(page > totalPages) page = 1;
		index = (page - 1) * Constant.ITEMS_PER_PAGE;
		
		posts = postService.getPosts(index, Constant.ITEMS_PER_PAGE);
		
		request.setAttribute("page", page);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("posts", posts);
		request.getRequestDispatcher(Constant.Path.ADMIN + "/managePost.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postId = request.getParameter("id");
		
		if(postId == null) {
			response.sendRedirect(request.getContextPath() + "/admin/post");
		} else {
			try {
				int id = Integer.parseInt(postId);
				postService.deletePost(id);
				response.sendRedirect(request.getContextPath() + "/admin/post");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
