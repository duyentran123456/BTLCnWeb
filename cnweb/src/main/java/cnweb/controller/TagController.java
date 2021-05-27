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
import cnweb.model.Tag;
import cnweb.service.IPostService;
import cnweb.service.ITagService;
import cnweb.service.impl.PostService;
import cnweb.service.impl.TagService;

/**
 * Servlet implementation class TagController
 */
@WebServlet(urlPatterns = {"/tag"})
public class TagController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	private ITagService tagService = new TagService();
	private IPostService postService = new PostService();
       
    public TagController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tagId = request.getParameter("id");
		if(tagId == null) {
			List<Tag> tags = tagService.findAll();
			request.setAttribute("tags", tags);
			request.getRequestDispatcher(Constant.Path.GUEST + "/allTags.jsp").forward(request, response);
		} else {
			try {
				int id = Integer.parseInt(tagId);
				Tag tag = tagService.findTagById(id);
				if(tag != null) {
					request.setAttribute("tag", tag);
					
					List<Post> posts = postService.findPostsByTag(id);
					request.setAttribute("posts", posts);
					request.getRequestDispatcher(Constant.Path.GUEST + "/tag.jsp").forward(request, response);
				} else {
					response.sendRedirect(request.getContextPath() + "/tag");
				}
			} catch(Exception e) {
				e.printStackTrace();
				response.sendRedirect(request.getContextPath() + "/home");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
