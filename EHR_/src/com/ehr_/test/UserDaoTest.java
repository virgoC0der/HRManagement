package com.ehr_.test;

import com.ehr_.dao.BaseDao;
import com.ehr_.util.Jdbc;
import org.junit.Test;

public class UserDaoTest {

    private Jdbc jdbc;

    @Test
    public void testGetConnection() {
        BaseDao baseDao = new BaseDao();
        if(baseDao.getConnection()==null){
            System.out.println("数据库没有连接");
        }else{
            System.out.println("数据库已经连接");
        }
    }
}
