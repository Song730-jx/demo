package com.song.demo.service;


import com.song.demo.bean.Bean;
import com.song.demo.bean.ExcelBean;
import com.song.demo.util.DBUtils;
import com.song.demo.util.ExcelUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ExcelService extends BaseService {
    public static void main(String[] args) throws IllegalAccessException {
        ExcelService a = new ExcelService();
        a.excel();
    }

    /**
     * 导出excel查询方法
     *
     * @return
     */
    public String excel() throws IllegalAccessException {
        List<Bean> excelList = list();
        System.out.println(excelList);
        ExcelBean excel = new ExcelBean();
        excel.setExcelName("学生管理系统导出表");
        excel.setSheetName("信息表");
        excel.setList(excelList);
        String[] title = new String[]{"学号", "姓名", "年龄", "年级", "分数"};
        excel.setTitle(title);
        String[] keys = new String[]{"id", "name", "age", "grade", "fraction"};
        excel.setKeys(keys);
        excel.setPath("C:\\Users\\Song\\IdeaProjects\\demo\\src\\main\\resources\\static");
        ExcelUtils.createExcel(excel);
        return "导出表.xlxs";
    }

    public List<Bean> list() {
        List<Bean> l = new ArrayList<>();
        try {
            List<Map<Object, Object>> list = DBUtils.getList("select s.id,s.name,s.age,f.fraction,g.grade from tbstudent as s join tbfraction as f on " +
                    "s.id = f.studentid join tbgrade as g on g.id=s.gradeid ");
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

}
