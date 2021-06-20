package com.liuwohe.crm.settings.service;

import com.liuwohe.crm.exception.LoginExecption;
import com.liuwohe.crm.settings.domain.User;

public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginExecption;
}
