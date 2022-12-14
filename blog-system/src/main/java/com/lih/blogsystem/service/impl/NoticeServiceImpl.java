package com.lih.blogsystem.service.impl;

import com.lih.blogsystem.entity.Notice;
import com.lih.blogsystem.dao.NoticeDao;
import com.lih.blogsystem.service.NoticeService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Notice)表服务实现类
 *
 * @author makejava
 * @since 2022-11-20 19:13:51
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private NoticeDao noticeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Notice queryById(Long id) {
        return this.noticeDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param notice      筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Notice> queryByPage(Notice notice, PageRequest pageRequest) {
        long total = this.noticeDao.count(notice);
        return new PageImpl<>(this.noticeDao.queryAllByLimit(notice, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public Notice insert(Notice notice) {
        this.noticeDao.insert(notice);
        return notice;
    }

    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public Notice update(Notice notice) {
        this.noticeDao.update(notice);
        return this.queryById(notice.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.noticeDao.deleteById(id) > 0;
    }
}
