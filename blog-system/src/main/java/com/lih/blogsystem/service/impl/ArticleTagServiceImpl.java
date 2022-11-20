package com.lih.blogsystem.service.impl;

import com.lih.blogsystem.entity.ArticleTag;
import com.lih.blogsystem.dao.ArticleTagDao;
import com.lih.blogsystem.service.ArticleTagService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (ArticleTag)表服务实现类
 *
 * @author makejava
 * @since 2022-11-20 19:13:53
 */
@Service("articleTagService")
public class ArticleTagServiceImpl implements ArticleTagService {
    @Resource
    private ArticleTagDao articleTagDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ArticleTag queryById(Long id) {
        return this.articleTagDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param articleTag  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<ArticleTag> queryByPage(ArticleTag articleTag, PageRequest pageRequest) {
        long total = this.articleTagDao.count(articleTag);
        return new PageImpl<>(this.articleTagDao.queryAllByLimit(articleTag, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param articleTag 实例对象
     * @return 实例对象
     */
    @Override
    public ArticleTag insert(ArticleTag articleTag) {
        this.articleTagDao.insert(articleTag);
        return articleTag;
    }

    /**
     * 修改数据
     *
     * @param articleTag 实例对象
     * @return 实例对象
     */
    @Override
    public ArticleTag update(ArticleTag articleTag) {
        this.articleTagDao.update(articleTag);
        return this.queryById(articleTag.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.articleTagDao.deleteById(id) > 0;
    }
}
