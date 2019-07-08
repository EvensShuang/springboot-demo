package com.rograndec.service.monitor.impl;

import com.rograndec.service.monitor.MonitorService;
import com.rograndec.service.monitor.dao.read.MonitorReadMapper;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
