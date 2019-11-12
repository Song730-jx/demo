package com.song.demo.service;

import com.song.demo.bean.Bean;
import com.song.demo.bean.ResultBean;
import com.song.demo.util.DBUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class GradeService  extends BaseService  {

    public int countService(){
        int count = count();
        return count;

    }

    public ResultBean getList(Bean bean,String page,String limit){
        int page1=Integer.parseInt(page);
        page1=(page1-1)*10;
        List<Bean> studentBean1= get(bean,page1,limit);
        return success(studentBean1);
    }

    /**
     * 查询总数据
     * @param bean
     * @param page
     * @param limit
     * @return
     */
    public List<Bean> get(Bean bean,int page,String limit) {
        String a=null;
        String b=null;
        if (bean.getname()==null){
            b="";
        }else {
            b=bean.getname();
        }
        if (bean.getGradeId()==0){
            a="%%";
        }else {
            a=String.valueOf(bean.getGradeId());
        }
        List<Bean> l = new ArrayList<>();
        try {
            List<Map<Object, Object>> list = DBUtils.getList("select s.id,s.name,s.age,f.fraction,g.grade from tbstudent as s join tbfraction as f on " +
                    "s.id = f.studentid join tbgrade as g on g.id=s.gradeid where name like '%" + b + "%'and gradeid like'" + a + "' limit "+page+","+limit+"");
            for (int j = 0; j < list.size(); ++j) {
                Map<Object, Object> map = list.get(j);
                Bean beanList = new Bean();
                for (Map.Entry<Object, Object> entry : map.entrySet()) {
                    if (entry.getKey().equals("id")) {
                        beanList.setId((Integer) entry.getValue());
                    }
                    if (entry.getKey().equals("name")) {
                        beanList.setname((String) entry.getValue());
                    }
                    if (entry.getKey().equals("age")) {
                        beanList.setAge((Integer) entry.getValue());
                    }
                    if (entry.getKey().equals("grade")) {
                        beanList.setGrade((String) entry.getValue());
                    }
                    if (entry.getKey().equals("fraction")) {
                        beanList.setFraction((Integer) entry.getValue());
                    }
                }
                l.add(beanList);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return l;
    }

    /**
     * 总数据，分页
     * @return
     */
    public int count(){
        int count = DBUtils.getCount("select count(*) from tbstudent");
        return count;
    }

}
