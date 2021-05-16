package com.liuwohe.service.impl;

import com.liuwohe.dao.studentDao;
import com.liuwohe.domain.student;
import com.liuwohe.service.studentService;
import com.liuwohe.util.SqlSessionUtil;

import java.util.List;

public class studentServiceImpl implements studentService {
    private studentDao studentDao = SqlSessionUtil.getSession().getMapper(studentDao.class);
    @Override
    public student getById(String id) {
        student s = studentDao.getById(id);
        return s;
    }


    @Override
    public void save(student s) {
        studentDao.save(s);
    }

    @Override
    public List<student> getAll() {
        List<student> sList = studentDao.getAll();
        return sList;
    }
}
