package com.lih.blogsystem.service.impl;

import com.lih.blogsystem.entity.Tag;
import com.lih.blogsystem.dao.TagDao;
import com.lih.blogsystem.service.TagService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Tag)表服务实现类
 *
 * @author makejava
 * @since 2022-11-20 19:13:49
 */
@Service("tagService")
public class TagServiceImpl implements TagService {
    @Resource
    private TagDao tagDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Tag queryById(Long id) {
        return this.tagDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tag         筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Tag> queryByPage(Tag tag, PageRequest pageRequest) {
        long total = this.tagDao.count(tag);
        return new PageImpl<>(this.tagDao.queryAllByLimit(tag, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tag 实例对象
     * @return 实例对象
     */
    @Override
    public Tag insert(Tag tag) {
        this.tagDao.insert(tag);
        return tag;
    }

    /**
     * 修改数据
     *
     * @param tag 实例对象
     * @return 实例对象
     */
    @Override
    public Tag update(Tag tag) {
        this.tagDao.update(tag);
        return this.queryById(tag.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tagDao.deleteById(id) > 0;
    }
}
