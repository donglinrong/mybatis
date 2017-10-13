package lrdong.module.service.impl;

import com.doctorwork.common.exception.ServiceException;
import com.doctorwork.common.util.Md5Util;
import lrdong.module.bean.SysUser;
import lrdong.module.bean.SysUserCriteria;
import lrdong.module.dao.SysUserMapper;
import lrdong.module.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser login(SysUser sysUser) throws ServiceException
    {
        SysUser sysUserBo = new SysUser();
        sysUserBo.setUserName(sysUser.getUserName());
        sysUserBo.setUserPassword(Md5Util.encoderByMd5(sysUser.getUserPassword()));
        SysUserCriteria sysUserCriteria = new SysUserCriteria();
        sysUserCriteria.or().andUserNameEqualTo(sysUser.getUserName()).
                andUserPasswordEqualTo(Md5Util.encoderByMd5(sysUser.getUserPassword()));
        List<SysUser> sysUserSelect = sysUserMapper.selectByExample(sysUserCriteria);
        if (sysUserSelect==null||sysUserSelect.size()==0)
        {
            throw new ServiceException("用户名密码不正确");
        }
        sysUserBo.setId(sysUserSelect.get(0).getId());
        sysUserBo.setUserEmail(sysUserSelect.get(0).getUserEmail());
        return sysUserBo;
    }
}
