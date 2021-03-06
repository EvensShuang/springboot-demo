package com.shuang.service.monitor.impl;

import com.shuang.service.monitor.MonitorService;
import com.shuang.service.monitor.dao.read.MonitorReadMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MonitorServiceImpl implements MonitorService {
    private static final Logger logger = LoggerFactory.getLogger(MonitorServiceImpl.class);

    @Autowired
    private MonitorReadMapper monitorReadMapper;

    @Override
    public Date getDataBaseCurrentTime() {
        return monitorReadMapper.getDataBaseCurrentTime();
    }

}
