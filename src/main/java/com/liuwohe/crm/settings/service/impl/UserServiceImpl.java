package com.liuwohe.crm.settings.service.impl;

import com.liuwohe.crm.exception.LoginExecption;
import com.liuwohe.crm.settings.dao.UserDao;
import com.liuwohe.crm.settings.domain.User;
import com.liuwohe.crm.settings.service.UserService;
import com.liuwohe.crm.utils.DateTimeUtil;
import com.liuwohe.crm.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao userdao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

    @Override
    public User login(String loginAct, String loginPwd, String ip) throws LoginExecption {

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("loginAct",loginAct);
        map.put("loginPwd",loginPwd);

        User user = userdao.login(map);

        if(user==null){
            throw new LoginExecption("账号密码错误");
        }
        //如果程序能够成功执行到该行，说明账号密码验证成功，需要继续向下验证

        String expirtime = user.getExpireTime();
        String currentTime = DateTimeUtil.getSysTime();
        if(expirtime.compareTo(currentTime)<0){
            throw new LoginExecption("账号已失效");
        }

        String localState = user.getLockState();
        if("0".equals(localState)){
            throw new LoginExecption("账号已锁定");
        }

        String allowIps = user.getAllowIps();
        if(!allowIps.contains(ip)){
            throw new LoginExecption("IP受限");
        }

        return user;
    }

}
