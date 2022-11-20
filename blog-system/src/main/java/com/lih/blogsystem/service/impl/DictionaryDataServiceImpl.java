package com.lih.blogsystem.service.impl;

import com.lih.blogsystem.entity.DictionaryData;
import com.lih.blogsystem.dao.DictionaryDataDao;
import com.lih.blogsystem.service.DictionaryDataService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (DictionaryData)表服务实现类
 *
 * @author makejava
 * @since 2022-11-20 19:13:52
 */
@Service("dictionaryDataService")
public class DictionaryDataServiceImpl implements DictionaryDataService {
    @Resource
    private DictionaryDataDao dictionaryDataDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DictionaryData queryById(Long id) {
        return this.dictionaryDataDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param dictionaryData 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    @Override
    public Page<DictionaryData> queryByPage(DictionaryData dictionaryData, PageRequest pageRequest) {
        long total = this.dictionaryDataDao.count(dictionaryData);
        return new PageImpl<>(this.dictionaryDataDao.queryAllByLimit(dictionaryData, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param dictionaryData 实例对象
     * @return 实例对象
     */
    @Override
    public DictionaryData insert(DictionaryData dictionaryData) {
        this.dictionaryDataDao.insert(dictionaryData);
        return dictionaryData;
    }

    /**
     * 修改数据
     *
     * @param dictionaryData 实例对象
     * @return 实例对象
     */
    @Override
    public DictionaryData update(DictionaryData dictionaryData) {
        this.dictionaryDataDao.update(dictionaryData);
        return this.queryById(dictionaryData.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.dictionaryDataDao.deleteById(id) > 0;
    }
}
