package com.song.demo.service;


import com.song.demo.bean.Bean;
import com.song.demo.bean.ResultBean;
import com.song.demo.util.DBUtils;
import org.springframework.stereotype.Component;

@Component
public class UpdateService extends BaseService {

    public ResultBean updateService(Bean bean) {
        update(bean);
        return success();
    }

    public ResultBean deleteService(Bean bean) {
        delete(bean);
        return success();
    }

    public void update(Bean bean) {
        DBUtils.update("UPDATE tbstudent SET name = '" + bean.getname() + "' WHERE id = " + bean.getId() + "");
        DBUtils.update("UPDATE tbstudent SET gradeid = '" + bean.getGradeId() + "' WHERE id = " + bean.getId() + "");
        DBUtils.update("UPDATE tbstudent SET age = '" + bean.getAge() + "' WHERE id = " + bean.getId() + "");
        DBUtils.update("UPDATE tbfraction SET fraction = '" + bean.getFraction() + "' WHERE studentid = " + bean.getId() + "");
    }

    /**
     * @param bean
     */
    public void delete(Bean bean) {
        DBUtils.update("DELETE FROM tbstudent WHERE id =" + bean.getId() + "");
        DBUtils.update("DELETE FROM tbfraction WHERE studentid =" + bean.getId() + "");

    }


}
