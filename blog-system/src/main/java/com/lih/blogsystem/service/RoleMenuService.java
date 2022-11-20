package com.lih.blogsystem.service;

import com.lih.blogsystem.entity.RoleMenu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (RoleMenu)表服务接口
 *
 * @author makejava
 * @since 2022-11-20 19:13:50
 */
public interface RoleMenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RoleMenu queryById(Long id);

    /**
     * 分页查询
     *
     * @param roleMenu    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<RoleMenu> queryByPage(RoleMenu roleMenu, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param roleMenu 实例对象
     * @return 实例对象
     */
    RoleMenu insert(RoleMenu roleMenu);

    /**
     * 修改数据
     *
     * @param roleMenu 实例对象
     * @return 实例对象
     */
    RoleMenu update(RoleMenu roleMenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
