// package com.lxj.com_lxj_student_info.configurer;

// import com.lxj.com_lxj_student_info.interceptor.LoginHandleInterceptor;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
// import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// /**
//  * LoginConfigurer
//  */
// @Configuration
// public class LoginConfigurer implements WebMvcConfigurer {

//     @Override
//     public void addInterceptors(InterceptorRegistry inter) {
//          inter.addInterceptor(loginHandleInterceptor()).addPathPatterns("/**");

//         // 拦截路径

//         // super.addInterceptors(inter);
//     }

//     public LoginHandleInterceptor loginHandleInterceptor() {
//         return new LoginHandleInterceptor();
//     }
// }