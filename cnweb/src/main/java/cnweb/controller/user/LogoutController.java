package cnweb.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cnweb.config.Constant;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet(urlPatterns = "/user/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        
        session.removeAttribute("user");
        
        Cookie[] cookies = request.getCookies();
        
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if(Constant.COOKIE_REMEMBER.equals(cookie.getName())){
                    cookie.setMaxAge(0); // <=> remove cookie
                    response.addCookie(cookie); // add again
                    break;
                }
            }
        }
        
       response.sendRedirect(request.getContextPath() + "/home");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
