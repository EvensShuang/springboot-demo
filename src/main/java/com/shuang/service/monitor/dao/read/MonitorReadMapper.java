package com.shuang.service.monitor.dao.read;

import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * <描述>
 *
 * @Author: zhengbin.jin
 * @Email: zhengbin.jin@rograndec.com
 * @CreateDate: 2018/5/10
 * @Version: 1.0
 */
@Repository
public interface MonitorReadMapper {
    Date getDataBaseCurrentTime();
}
