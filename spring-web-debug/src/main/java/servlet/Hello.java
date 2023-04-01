package servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Hello implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}


	/*
	  用于处理业务逻辑。当用户没访问Servlet时，都会被调用
	  req:用于获得客户端（浏览器）的信息
	  res:用于向客户端（浏览器）返回信息
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// 从res中得到PrintWriter
		PrintWriter pw = res.getWriter();
		pw.println("hello world");
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	// 销毁Servlet实例(释放内存) 1.reload该Servlet(webApps)  2.关闭tomcat  3.关机
	@Override
	public void destroy() {
		System.out.println("destroy!");
	}
}
