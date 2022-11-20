package com.lih.blogsystem.service;

import com.lih.blogsystem.entity.Link;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Link)表服务接口
 *
 * @author makejava
 * @since 2022-11-20 19:13:51
 */
public interface LinkService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Link queryById(Long id);

    /**
     * 分页查询
     *
     * @param link        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Link> queryByPage(Link link, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param link 实例对象
     * @return 实例对象
     */
    Link insert(Link link);

    /**
     * 修改数据
     *
     * @param link 实例对象
     * @return 实例对象
     */
    Link update(Link link);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
