package com.song.demo.service;

import com.song.demo.bean.Bean;
import com.song.demo.bean.FractionBean;
import com.song.demo.bean.ResultBean;
import com.song.demo.bean.StudentBean;
import com.song.demo.util.DBUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class FractionService  extends BaseService {

    public ResultBean addFraction(FractionBean fractionBean,StudentBean studentBean){
        int id=add(fractionBean,studentBean);
        return success(id);
    }

    public ResultBean getFraction(){
        List<Bean> studentBean1= get();
        return success(studentBean1);
    }

    public int add(FractionBean fractionBean, StudentBean studentBean){
        List<Map<Object, Object>> list = DBUtils.getList("SELECT * FROM tbstudent WHERE name='" + studentBean.getname() + "'");
        Map<Object, Object> map = list.get(0);
        StudentBean tbStudent = new StudentBean();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            if (entry.getKey().equals("id")) {
                tbStudent.setId((Integer) entry.getValue());
            }
        }
        int a=tbStudent.getId();
        int id= DBUtils.add_returnId("INSERT INTO tbfraction (studentid,fraction) VALUES (" + a + "," + fractionBean.getFraction() + ")");
        return id;
    }

    public List<Bean> get() {
        List<Bean> l = new ArrayList<>();
        try {
            List<Map<Object, Object>> list = DBUtils.getList("select s.id,s.name,s.age,f.fraction,g.grade from tbstudent as s join tbfraction as f on s.id = f.studentid join tbgrade as g on g.id=s.gradeid ");
            for (int j = 0; j < list.size(); ++j) {
                Map<Object, Object> map = list.get(j);
                Bean bean = new Bean();
                for (Map.Entry<Object, Object> entry : map.entrySet()) {
                    if (entry.getKey().equals("id")) {
                        bean.setId((Integer) entry.getValue());
                    }
                    if (entry.getKey().equals("name")) {
                        bean.setname((String) entry.getValue());
                    }
                    if (entry.getKey().equals("age")) {
                        bean.setAge((Integer) entry.getValue());
                    }
                    if (entry.getKey().equals("grade")) {
                        bean.setGrade((String) entry.getValue());
                    }
                    if (entry.getKey().equals("fraction")) {
                        bean.setFraction((Integer) entry.getValue());
                    }

                }
                l.add(bean);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return l;
    }

}
