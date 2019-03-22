// package com.lxj.com_lxj_student_info.interceptor;

// import java.io.IOException;

// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.HttpSession;

// import org.springframework.stereotype.Component;
// import org.springframework.web.servlet.HandlerInterceptor;

// /**
//  * LoginHandleInterceptor
//  */
// @Component
// public class LoginHandleInterceptor implements HandlerInterceptor {

//     public boolean preHandle(HttpSession session, HttpServletRequest request, HttpServletResponse response,
//             Object handler) throws IOException {
//         if (session.getAttribute("user_name") == null) {
//             String url = "/login";
//             response.sendRedirect(url);
//             return false;
//         } else {
//             return true;
//         }
//     }
// }