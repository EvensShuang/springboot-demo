package com.rograndec.service.monitor.dao.read;

import java.util.Date;

import org.springframework.stereotype.Repository;

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
