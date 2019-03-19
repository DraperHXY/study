package com.jnshu.dreamteam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jnshu.dreamteam.mapper.NewsMapper;
import com.jnshu.dreamteam.pojo.News;
import com.jnshu.dreamteam.service.BaseServiceWrapper;
import com.jnshu.dreamteam.service.NewsService;
import com.mchange.v2.beans.BeansUtils;
import org.apache.commons.beanutils.BeanMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author draper_hxy
 */
@Service
public class NewsServiceImpl extends BaseServiceWrapper<News> implements NewsService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Resource
    private NewsMapper newsMapper;

    @Override
    public Boolean insert(News news) {
        LOGGER.trace("news insert");
        return getResult(newsMapper.insert(news));
    }

    @Override
    public News select(Long id) {
        LOGGER.trace("select news, id = {}", id);
        return newsMapper.selectById(id);
    }

    @Override
    public Boolean update(News news) {
        LOGGER.trace("update news, id = {}", news.getId());
        Map params = new BeanMap(news);
        UpdateWrapper<News> updateWrapper = buildUpdateWrapper(null, params);
        return getResult(newsMapper.update(news, updateWrapper));
    }

    @Override
    protected QueryWrapper<News> buildQueryWrapper(QueryWrapper<News> queryWrapper, Map<String, Object> params) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected UpdateWrapper<News> buildUpdateWrapper(UpdateWrapper<News> updateWrapper, Map<String, Object> params) {
        updateWrapper = super.buildUpdateWrapper(updateWrapper, null);
        LambdaUpdateWrapper<News> lambdaUpdateWrapper = updateWrapper.lambda();
        if (params.get("title") != null)
            lambdaUpdateWrapper.set(News::getTitle, params.get("title"));
        if (params.get("type") != null)
            lambdaUpdateWrapper.set(News::getType, params.get("type"));
        if (params.get("coverImg") != null)
            lambdaUpdateWrapper.set(News::getCoverImg, params.get("coverImg"));
        if (params.get("digest") != null)
            lambdaUpdateWrapper.set(News::getDigest, params.get("digest"));
        if (params.get("content") != null)
            lambdaUpdateWrapper.set(News::getContent, params.get("content"));
        return updateWrapper;
    }
}