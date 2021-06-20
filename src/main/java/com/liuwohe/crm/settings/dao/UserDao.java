package com.liuwohe.crm.settings.dao;

import com.liuwohe.crm.settings.domain.User;

import java.util.Map;

public interface UserDao {
    User login(Map<String, Object> map);
}
