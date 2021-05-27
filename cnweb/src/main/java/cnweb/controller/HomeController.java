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
import cnweb.model.User;
import cnweb.service.IPostService;
import cnweb.service.ITagService;
import cnweb.service.IUserService;
import cnweb.service.impl.PostService;
import cnweb.service.impl.TagService;
import cnweb.service.impl.UserService;

/**
 * Servlet implementation class HomeController
 */
@WebServlet(urlPatterns = {"/home", "/"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IPostService postService = new PostService();
	private ITagService tagService = new TagService();
	private IUserService userService = new UserService();
       
    public HomeController() {
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
		for(Post post : posts) {
			String short_content = post.getContent().length() > 100 ? post.getContent().substring(0,99) : post.getContent();
			post.setContent(short_content);
		}
		
		request.setAttribute("page", page);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("posts", posts);
		
		List<Tag> tags = tagService.findAll();
		request.setAttribute("tags", tags);
		
		List<User> authors = userService.findAll();
		request.setAttribute("authors", authors);
				
		request.getRequestDispatcher(Constant.Path.GUEST + "/home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
