package com.bjajmd.mall.admin.common.freemark;

import freemarker.template.SimpleNumber;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bjajmd.mall.admin.common.exception.MyException;
import com.bjajmd.mall.admin.service.BlogCommentService;

import java.util.List;

@Component
public class CommentNumberTempletModel implements TemplateMethodModelEx {

    @Autowired
    private BlogCommentService blogCommentService;
    @Override
    public Object exec(List list) throws TemplateModelException {
        if(list == null || list.size() == 0){
            throw new MyException("参数为空");
        }
        SimpleNumber simpleNumber = (SimpleNumber) list.get(0);
        Long articleId = simpleNumber.getAsNumber().longValue();
        return blogCommentService.getArticleCommentsCount(articleId);
    }
}
