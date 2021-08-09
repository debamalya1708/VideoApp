package com.ds.videoapp;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;

public class CorsFilter extends GenericFilterBean implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
		httpServletResponse.setHeader("Access-Control-Allow-Methods","*");
		httpServletResponse.setHeader("Access-Control-Allow-Headers","*");
		httpServletResponse.setHeader("Access-Control-Allow-Credentials","false");
		System.out.println("Cors filter ends here");
		chain.doFilter(request, response);	
	}
}
