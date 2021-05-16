package com.liuwohe.dao;

import com.liuwohe.domain.student;

import java.util.List;
import java.util.Map;

public interface studentDao {
    public student getById(String id);
    public void save(student s);

    List<student> getAll();

    List<student> select1(String s);

    List<student> select2();

    List<student> select3(student s);

    List<student> select4(String[] strArry);

    List<student> select5(String s);

    List<Map<String, Object>> select6();
}
