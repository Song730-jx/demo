package com.song.demo.service;

import com.song.demo.bean.AdminBean;
import com.song.demo.bean.ResultBean;
import com.song.demo.util.DBUtils;
import com.song.demo.util.Md5Utils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class AdmainService extends BaseService {

    public ResultBean addService(AdminBean admin)  {
        String s = Md5Utils.md5Utils(admin.getPassword());
        admin.setPassword(s);
        add(admin);
        return success();
    }

    public ResultBean getService(AdminBean admin){
        String s = Md5Utils.md5Utils(admin.getPassword());
        admin.setPassword(s);
        AdminBean adminBean1 = get(admin);
        if (adminBean1 == null) {
            return failure("该用户不存在");
        } else {
            if (s.equals(adminBean1.getPassword())) {
                System.out.println("登录成功");
                return success(adminBean1);
            } else {
                System.out.println("登录失败");
                return failure("密码错误!");
            }
        }
    }

    public int add(AdminBean admin) {
        int id=DBUtils.update("INSERT INTO tbadmin (number,password) VALUES ('" + admin.getNumber() + "','" + admin.getPassword() + "')");
        return id;
    }

    public AdminBean get(AdminBean admin) {
        String sql = "SELECT * FROM tbadmin WHERE password='" + admin.getPassword() + "' and number='" + admin.getNumber() + "'";
        AdminBean admin1 = new AdminBean();
        try {
            List<Map<Object, Object>> list = DBUtils.getList(sql);
            Map<Object, Object> map = list.get(0);
            for (Map.Entry<Object, Object> entry : map.entrySet()) {
                if (entry.getKey().equals("password")) {
                    admin1.setPassword((String) entry.getValue());
                }
                if (entry.getKey().equals("number")) {
                    admin1.setNumber((String) entry.getValue());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return admin1;
    }

}
