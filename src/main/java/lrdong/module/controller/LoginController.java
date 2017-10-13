package lrdong.module.controller;

import com.alibaba.fastjson.JSON;
import lrdong.common.Constant.Constant;
import lrdong.common.exception.UnloginException;
import lrdong.module.bean.SysUser;
import lrdong.module.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/mybatis/admininfo")
public class LoginController {

    @Autowired
    private SysUserServiceImpl sysUserService;

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login1() throws Exception
    {
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(@RequestBody SysUser sysUser, HttpSession httpSession) throws Exception
    {
        SysUser loginInfo = sysUserService.login(sysUser);
        loginInfo.setUserPassword(null);
        httpSession.setAttribute(Constant.loginInfoID, JSON.toJSON(loginInfo));
        httpSession.setMaxInactiveInterval(7200);
        return "index";
    }

    @RequestMapping("login/error")
    @ResponseBody
    public Object loginError(HttpServletRequest req, HttpServletResponse res) throws UnloginException {
        throw  new UnloginException("重新登陆");
    }

}
