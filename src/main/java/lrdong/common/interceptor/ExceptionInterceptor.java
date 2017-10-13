package lrdong.common.interceptor;

import com.doctorwork.common.exception.ServiceException;
import lrdong.common.exception.UnloginException;
import lrdong.common.model.response.HttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by wuke on 2017/5/17.
 */
@ControllerAdvice
public class ExceptionInterceptor {
    /**
     * 日志对象.
     */
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler
    //    @ExceptionHandler(value={RuntimeException.class,MyRuntimeException.class})
    //    @ExceptionHandler//处理所有异常
    @ResponseBody //在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public HttpResult RuntineExceptionHandler(Exception e, HttpServletResponse response) {
        if(e instanceof BindException){
            e.printStackTrace();
            return error("请求参数不合规!" );
        }else if (e instanceof UnloginException)
        {
            e.printStackTrace();
            return error("请重新登陆");
        }else if (e instanceof ServiceException)
        {
            e.printStackTrace();
            return error("用户名密码不存在");
        }
        else if (e instanceof Exception) {
            logger.error("系统异常:",e);
            return error("系统异常");
        }
        return null;
    }
    /**
     * 失败
     * @param message
     * @return
     */
    protected HttpResult error(String message) {
        return new HttpResult(1,message,null);
    }
    /**
     * 失败
     * @param message
     * @return
     */
}
