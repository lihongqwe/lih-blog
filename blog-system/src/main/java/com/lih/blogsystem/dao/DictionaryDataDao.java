package com.lih.blogsystem.dao;

import com.lih.blogsystem.entity.DictionaryData;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (DictionaryData)表数据库访问层
 *
 * @author makejava
 * @since 2022-11-20 19:13:52
 */
public interface DictionaryDataDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DictionaryData queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param dictionaryData 查询条件
     * @param pageable       分页对象
     * @return 对象列表
     */
    List<DictionaryData> queryAllByLimit(DictionaryData dictionaryData, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param dictionaryData 查询条件
     * @return 总行数
     */
    long count(DictionaryData dictionaryData);

    /**
     * 新增数据
     *
     * @param dictionaryData 实例对象
     * @return 影响行数
     */
    int insert(DictionaryData dictionaryData);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DictionaryData> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DictionaryData> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DictionaryData> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<DictionaryData> entities);

    /**
     * 修改数据
     *
     * @param dictionaryData 实例对象
     * @return 影响行数
     */
    int update(DictionaryData dictionaryData);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

