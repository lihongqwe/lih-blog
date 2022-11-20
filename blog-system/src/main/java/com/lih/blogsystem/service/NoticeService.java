package com.lih.blogsystem.service;

import com.lih.blogsystem.entity.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Notice)表服务接口
 *
 * @author makejava
 * @since 2022-11-20 19:13:51
 */
public interface NoticeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Notice queryById(Long id);

    /**
     * 分页查询
     *
     * @param notice      筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Notice> queryByPage(Notice notice, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    Notice insert(Notice notice);

    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    Notice update(Notice notice);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
