package com.song.demo.service;

import com.song.demo.bean.ResultBean;
import com.song.demo.bean.StudentBean;
import com.song.demo.util.DBUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class StudentService extends BaseService {
    /**
     * 添加学生
     * @param studentBean
     * @return
     */
    public ResultBean addStudent(StudentBean studentBean) {
        int id = add(studentBean);
        return success(id);
    }

    /**
     * 查询Student表数据
     * @return
     */
    public ResultBean getStudent(){
        List<StudentBean> studentBean1= get();
        return success(studentBean1);
    }

    public int add(StudentBean student) {
        int id = DBUtils.add_returnId("INSERT INTO tbstudent (name,age,gradeid) VALUES ('" + student.getname() + "'," + student.getAge() + "," + student.getGradeId() + ")");
        return id;
    }

    public List<StudentBean> get() {
        List<StudentBean> l = new ArrayList<>();
        try {
            List<Map<Object, Object>> list = DBUtils.getList("SELECT * FROM tbstudent ");
            for (int j = 0; j < list.size(); ++j) {
                Map<Object, Object> map = list.get(j);
                StudentBean tbStudent1 = new StudentBean();
                for (Map.Entry<Object, Object> entry : map.entrySet()) {
                    if (entry.getKey().equals("id")) {
                        tbStudent1.setId((Integer) entry.getValue());
                    }
                    if (entry.getKey().equals("name")) {
                        tbStudent1.setname((String) entry.getValue());
                    }
                    if (entry.getKey().equals("age")) {
                        tbStudent1.setAge((Integer) entry.getValue());
                    }
                    if (entry.getKey().equals("gradeid")) {
                        tbStudent1.setGradeId((Integer) entry.getValue());
                    }
                }
                l.add(tbStudent1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return l;
    }
}
