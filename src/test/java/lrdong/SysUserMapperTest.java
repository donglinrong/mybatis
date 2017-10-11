package lrdong;

import com.alibaba.fastjson.JSON;
import lrdong.module.Application;
import lrdong.module.bean.SysUserCriteria;
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
    public void testSelectByPrimaryKey()
    {
        System.out.println(JSON.toJSON(sysUserMapper.selectByPrimaryKey(1l)));
    }

    @Test
    public void testCountByExample()
    {
        SysUserCriteria sysUserCriteria = new SysUserCriteria();
        sysUserCriteria.or().andIdEqualTo(1l).andUserEmailIsNotNull();
        sysUserCriteria.setOrderByClause("crate_time ASC");
        System.out.println("aaaaaaaaaaaaaaaaaaa:"+sysUserMapper.countByExample(sysUserCriteria));
    }
}
