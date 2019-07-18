package com.shuang.service.demo.dao.write;

import com.shuang.service.demo.entity.Demo;
import org.springframework.stereotype.Repository;

/**
 * @Author: shuang.zhang
 * @Email: shuang.zhang@rograndec.com
 * @CreateTime: 2019-7-17
 * @Version: 1.0
 */
@Repository
public interface DemoWriteDao {
    /**
     * 插入数据
     */
    Integer addDemo(Demo demo);

    /**
     * 修改数据
     */
    Integer updateDemo(Demo demo);

    /**
     * 删除数据
     */
    Integer deleteDemo(Integer id);
}
