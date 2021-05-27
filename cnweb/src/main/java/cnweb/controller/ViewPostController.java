package cnweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cnweb.config.Constant;
import cnweb.model.Comment;
import cnweb.model.Post;
import cnweb.model.Tag;
import cnweb.model.User;
import cnweb.service.ICommentService;
import cnweb.service.IPostService;
import cnweb.service.ITagService;
import cnweb.service.IUserService;
import cnweb.service.impl.CommentService;
import cnweb.service.impl.PostService;
import cnweb.service.impl.TagService;
import cnweb.service.impl.UserService;

/**
 * Servlet implementation class ViewPostController
 */
@WebServlet("/post")
public class ViewPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IPostService postService = new PostService();
	private IUserService userService = new UserService();
	private ICommentService commentService = new CommentService();
	private ITagService tagService = new TagService();
       
    public ViewPostController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String postId = request.getParameter("id");
		if(postId == null) {
			response.sendRedirect(request.getContextPath() + "/home");
		} else {
			try {
				int id = Integer.parseInt(postId);
				Post post = postService.findPostById(id);
				if(post != null) {
					User author = userService.findById(post.getAuthorId());
					List<Tag> tags = tagService.findAll();
					List<Comment> comments = commentService.findAllCommentsInAPost(id);
					Post nextPost = postService.getNextPost(post);
					Post previousPost = postService.getPreviousPost(post);
					
					if(nextPost != null) request.setAttribute("nextId", nextPost.getId());
					if(previousPost != null) request.setAttribute("prevId", previousPost.getId());
					
					request.setAttribute("author", author);
					request.setAttribute("tags", tags);
					request.setAttribute("comments", comments);
					request.setAttribute("post", post);
				} else {
					response.sendRedirect(request.getContextPath() + "/post");
					return;
				}
			} catch(Exception e) {
				e.printStackTrace();
				response.sendRedirect(request.getContextPath() + "/post");
				return;
			}
			request.getRequestDispatcher(Constant.Path.GUEST + "/post.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
