package com.bjajmd.mall.admin.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bjajmd.mall.admin.dao.GroupDao;
import com.bjajmd.mall.admin.entity.Group;
import com.bjajmd.mall.admin.service.GroupService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangl
 * @since 2017-10-31
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class GroupServiceImpl extends ServiceImpl<GroupDao, Group> implements GroupService {
	
}
