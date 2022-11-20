package com.lih.blogsystem.service.impl;

import com.lih.blogsystem.entity.Link;
import com.lih.blogsystem.dao.LinkDao;
import com.lih.blogsystem.service.LinkService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Link)表服务实现类
 *
 * @author makejava
 * @since 2022-11-20 19:13:51
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService {
    @Resource
    private LinkDao linkDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Link queryById(Long id) {
        return this.linkDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param link        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Link> queryByPage(Link link, PageRequest pageRequest) {
        long total = this.linkDao.count(link);
        return new PageImpl<>(this.linkDao.queryAllByLimit(link, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param link 实例对象
     * @return 实例对象
     */
    @Override
    public Link insert(Link link) {
        this.linkDao.insert(link);
        return link;
    }

    /**
     * 修改数据
     *
     * @param link 实例对象
     * @return 实例对象
     */
    @Override
    public Link update(Link link) {
        this.linkDao.update(link);
        return this.queryById(link.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.linkDao.deleteById(id) > 0;
    }
}
