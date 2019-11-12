package com.song.demo.config;


import net.atomarrow.configs.Config;
import net.atomarrow.configs.DbConfig;
import net.atomarrow.db.orm.OrmContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectConfig extends Config {

    @Override
    public boolean configServiceLog() {
        return false;
    }

    @Override
    public List<String> configAutoTxPrefix() {
        List<String> list = new ArrayList<>();
        list.add("add");
        list.add("modify");
        list.add("delete");
        return list;
    }

    @Override
    public String configDbName() {
        return "test";
    }

    @Override
    public String configDbType() {
        return DbConfig.DB_TYPE_MYSQL;
    }

    @Override
    public void configOrmBean(OrmContext ormContext) {

    }
}
