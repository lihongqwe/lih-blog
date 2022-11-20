package com.lih.blogsystem.service;

import com.lih.blogsystem.entity.DictionaryData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (DictionaryData)表服务接口
 *
 * @author makejava
 * @since 2022-11-20 19:13:52
 */
public interface DictionaryDataService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DictionaryData queryById(Long id);

    /**
     * 分页查询
     *
     * @param dictionaryData 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    Page<DictionaryData> queryByPage(DictionaryData dictionaryData, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param dictionaryData 实例对象
     * @return 实例对象
     */
    DictionaryData insert(DictionaryData dictionaryData);

    /**
     * 修改数据
     *
     * @param dictionaryData 实例对象
     * @return 实例对象
     */
    DictionaryData update(DictionaryData dictionaryData);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
