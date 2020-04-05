package com.bjajmd.mall.admin.common.freemark;

import com.bjajmd.mall.admin.common.exception.MyException;
import com.bjajmd.mall.admin.entity.BlogArticle;
import com.bjajmd.mall.admin.service.BlogArticleService;
import com.google.common.collect.Maps;

import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by wangl on 2018/2/7.
 * todo:
 */
@Component
public class LookLikeArticlesTempletModel extends BaseDirective implements TemplateDirectiveModel {

    @Autowired
    private BlogArticleService blogArticleService;
    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        Iterator iterator = map.entrySet().iterator();
        Integer limit = 5;
        Long articleId = null;
        while (iterator.hasNext()) {
            Map.Entry<String, TemplateModel> param = (Map.Entry<String, TemplateModel>) iterator.next();
            String paramName = param.getKey();
            TemplateModel paramValue = param.getValue();
            if(paramName.toLowerCase().equals("articleid")){
                articleId = getLong(paramName,paramValue);
            }
            if(paramName.toLowerCase().equals("limit")){
                int templimit = getInt(paramName,paramValue);
                if(templimit>0){
                    limit = templimit;
                }
            }
        }
        if(articleId == null){
            throw new MyException("模版参数错误");
        }
        Map<String,Object> dataMap = Maps.newHashMap();
        dataMap.put("limit",limit);
        dataMap.put("articleId",articleId);
        List<BlogArticle> articleList = blogArticleService.selectLikeSameWithTags(dataMap);
        DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_26);
        environment.setVariable("result", builder.build().wrap(articleList));
        templateDirectiveBody.render(environment.getOut());
    }
}
