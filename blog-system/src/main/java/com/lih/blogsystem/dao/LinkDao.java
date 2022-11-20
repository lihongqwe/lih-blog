package com.lih.blogsystem.dao;

import com.lih.blogsystem.entity.Link;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Link)表数据库访问层
 *
 * @author makejava
 * @since 2022-11-20 19:13:51
 */
public interface LinkDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Link queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param link     查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Link> queryAllByLimit(Link link, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param link 查询条件
     * @return 总行数
     */
    long count(Link link);

    /**
     * 新增数据
     *
     * @param link 实例对象
     * @return 影响行数
     */
    int insert(Link link);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Link> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Link> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Link> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Link> entities);

    /**
     * 修改数据
     *
     * @param link 实例对象
     * @return 影响行数
     */
    int update(Link link);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

