package com.lih.blogsystem.service;

import com.lih.blogsystem.entity.ArticleTag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (ArticleTag)表服务接口
 *
 * @author makejava
 * @since 2022-11-20 19:13:53
 */
public interface ArticleTagService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ArticleTag queryById(Long id);

    /**
     * 分页查询
     *
     * @param articleTag  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<ArticleTag> queryByPage(ArticleTag articleTag, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param articleTag 实例对象
     * @return 实例对象
     */
    ArticleTag insert(ArticleTag articleTag);

    /**
     * 修改数据
     *
     * @param articleTag 实例对象
     * @return 实例对象
     */
    ArticleTag update(ArticleTag articleTag);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
