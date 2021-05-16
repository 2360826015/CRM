package com.liuwohe.test;

import com.liuwohe.domain.student;
import com.liuwohe.service.impl.studentServiceImpl;
import com.liuwohe.service.studentService;
import com.liuwohe.util.ServiceFactory;

import java.util.List;

public class test {
    public static void main(String [] args){

        //studentService ss = new studentServiceImpl();
        studentService ss = (studentService) ServiceFactory.getService(new studentServiceImpl());
//        student s =new student();
//        s.setId("4");
//        s.setName("xianbei");
//        s.setAge(18);
//        ss.save(s);

//          student s = ss.getById("1");
//          System.out.println(s);


        List<student> sList= ss.getAll();
        for (student s:sList){
            System.out.println(s);
        }
    }
}
