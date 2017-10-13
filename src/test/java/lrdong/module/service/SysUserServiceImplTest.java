package lrdong.module.service;

import com.doctorwork.common.exception.ServiceException;
import lrdong.Application;
import lrdong.module.bean.SysUser;
import lrdong.module.service.impl.SysUserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class SysUserServiceImplTest {

    @Autowired
    private SysUserServiceImpl sysUserService;

    @Test
    public void testLoginSusccess()
    {
        SysUser sysUserBo = new SysUser();
        sysUserBo.setUserName("lrdong");
        sysUserBo.setUserPassword("william");
        try {
            SysUser sysUser= sysUserService.login(sysUserBo);
            Assert.assertNotNull(sysUser);
        }catch (ServiceException e){
            System.out.println("登陆失败");
        }

    }

    @Test(expected = ServiceException.class)
    public void testLoginException() throws Exception
    {
        SysUser sysUserBo = new SysUser();
        sysUserBo.setUserName("lrdong");
        sysUserBo.setUserPassword("william11");
        SysUser sysUser= sysUserService.login(sysUserBo);
    }

}
