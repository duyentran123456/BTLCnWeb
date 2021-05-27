package cnweb.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import cnweb.utils.XSSRequestWrapper;

/**
 * Servlet Filter implementation class XSSFilter
 */
@WebFilter("/*")
public class XSSFilter implements Filter {

    public XSSFilter() {
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(new XSSRequestWrapper((HttpServletRequest) request), response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
