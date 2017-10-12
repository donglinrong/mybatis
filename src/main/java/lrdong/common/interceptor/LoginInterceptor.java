package lrdong.common.interceptor;

import lrdong.common.Constant.Constant;
import lrdong.common.annotation.LoginRequire;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    protected final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断当前handler是否为methodHandler
        if(!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        LoginRequire loginRequire = handlerMethod.getMethodAnnotation(LoginRequire.class);

        if(null == loginRequire) {
            return true;
        }

        //获取是否有登录信息
        String login = (String)request.getSession(true).getAttribute(Constant.loginInfoID);
        if(StringUtils.isBlank(login)) {
            request.getRequestDispatcher("/mybatis/admininfo/login/error").forward(request, response);
            return false;
        }
        logger.info("登录信息为 {}",login);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
