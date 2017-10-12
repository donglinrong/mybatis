package lrdong.common.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
/**
 * 标注是否需要登录
 * @author lrdong
 */
public @interface LoginRequire {

}
