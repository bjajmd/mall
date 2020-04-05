package com.bjajmd.mall.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bjajmd.mall.admin.dao.QuartzTaskLogDao;
import com.bjajmd.mall.admin.entity.QuartzTaskLog;
import com.bjajmd.mall.admin.service.QuartzTaskLogService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 任务执行日志 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2018-01-25
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class QuartzTaskLogServiceImpl extends ServiceImpl<QuartzTaskLogDao, QuartzTaskLog> implements QuartzTaskLogService {

}
