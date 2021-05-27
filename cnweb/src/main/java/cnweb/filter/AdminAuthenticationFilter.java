package cnweb.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Servlet Filter implementation class AdminAuthenticationFilter
 */
@WebFilter("/admin/*")
public class AdminAuthenticationFilter implements Filter {

    public AdminAuthenticationFilter() {
       
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);
 
        boolean isLoggedIn = (session != null && session.getAttribute("admin") != null);
 
        String loginURI = httpRequest.getContextPath() + "/login";
 
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
 
        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login.jsp");
 
        if (isLoggedIn && (isLoginRequest || isLoginPage)) {
            // the admin is already logged in and he's trying to login again
            // then forwards to the admin's homepage
            RequestDispatcher dispatcher = request.getRequestDispatcher(httpRequest.getContextPath() + "/home");
            dispatcher.forward(request, response);
 
        } else if (isLoggedIn || isLoginRequest) {
            // continues the filter chain
            // allows the request to reach the destination
            chain.doFilter(request, response);
 
        } else {
            // the admin is not logged in, so authentication is required
            // forwards to the Login page
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
            dispatcher.forward(request, response);
 
        }
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
