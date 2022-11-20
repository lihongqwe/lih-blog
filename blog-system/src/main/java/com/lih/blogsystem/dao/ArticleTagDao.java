package com.lih.blogsystem.dao;

import com.lih.blogsystem.entity.ArticleTag;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (ArticleTag)表数据库访问层
 *
 * @author makejava
 * @since 2022-11-20 19:13:53
 */
public interface ArticleTagDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ArticleTag queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param articleTag 查询条件
     * @param pageable   分页对象
     * @return 对象列表
     */
    List<ArticleTag> queryAllByLimit(ArticleTag articleTag, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param articleTag 查询条件
     * @return 总行数
     */
    long count(ArticleTag articleTag);

    /**
     * 新增数据
     *
     * @param articleTag 实例对象
     * @return 影响行数
     */
    int insert(ArticleTag articleTag);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ArticleTag> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ArticleTag> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ArticleTag> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ArticleTag> entities);

    /**
     * 修改数据
     *
     * @param articleTag 实例对象
     * @return 影响行数
     */
    int update(ArticleTag articleTag);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

