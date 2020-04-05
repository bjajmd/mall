package com.bjajmd.mall.admin.common.util;

import java.util.Comparator;

import com.bjajmd.mall.admin.entity.Menu;

/**
 * Created by wangl on 2017/12/3.
 * todo:菜单排序
 */
public class MyCompare implements Comparator<Menu> {
    @Override
    public int compare(Menu a, Menu b) {
        if(a.getParentIds().contains(b.getParentIds())){
            return -1;
        }else{
            return 1;
        }
    }
}
