package lrdong;

import lrdong.module.Application;
import lrdong.module.dao.SysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class SysUserMapperTest {


    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void testSelece()
    {
        System.out.println(sysUserMapper.selectByPrimaryKey(1l));
    }
}
