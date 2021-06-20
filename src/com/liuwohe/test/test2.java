package com.liuwohe.test;

import com.liuwohe.dao.studentDao;
import com.liuwohe.domain.student;
import com.liuwohe.util.SqlSessionUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class test2 {
    public static void main(String[] args) {
        studentDao studentDao = SqlSessionUtil.getSession().getMapper(studentDao.class);
        //like模糊查询 使用#{}
//        List<student> sList =  studentDao.select1("xian");
//        for(student s:sList){
//            System.out.println(s);
//        }
        //resultType当数据库表名和domain类属性名不一致时，使用resultMap
//        List<student> sList =  studentDao.select2();
//        for(student s:sList){
//                System.out.println(s);
//        }
        //测试：动态sql where标签+if标签
//        student s = new student();
//        s.setName("x");
//        List<student> sList = studentDao.select3(s);
//        for (student s1:sList){
//            System.out.println(s1);
//        }
        //测试：动态sql foreach 标签
//        String strArry[] = {"1","2"};
//        List<student> sList = studentDao.select4(strArry);
//        for (student s:sList){
//            System.out.println(s);
//        }
        //测试sql片段插入
//        List<student> sList = studentDao.select5("1");
//        for (student s:sList){
//            System.out.println(s);
//        }
        //多表连级查询
        List<Map<String,Object>> mapList = studentDao.select6();
        for (Map<String,Object> map:mapList){
            Set<String> set = map.keySet();
            for (String key:set){
                System.out.println("key:"+key);
                System.out.println("value:"+map.get(key));
            }
            System.out.println("-----------------------");
        }
    }
}
