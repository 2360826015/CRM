package com.liuwohe.service;

import com.liuwohe.domain.student;

import java.util.List;

public interface studentService {
    public student getById(String id);
    public void save(student s);

    List<student> getAll();
}
