//package filter;
//
//import nuc.sw.entity.User;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(urlPatterns = {"*.do"})
//public class LoginFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) res;
//        String uri = request.getRequestURI();
//
//        if (uri.equalsIgnoreCase("/login.do")) {
//            chain.doFilter(request, response);
//        } else {
//            User u = (User) request.getSession().getAttribute("user");
//            if (u != null) {
//                chain.doFilter(request, response);
//            } else {
//                request.getSession().setAttribute("error", "请先登录在使用系统");
//                response.sendRedirect(request.getContextPath() + "/");
//            }
//        }
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
