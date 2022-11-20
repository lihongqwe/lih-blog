package com.lih.blogsystem.service.impl;

import com.lih.blogsystem.entity.RoleMenu;
import com.lih.blogsystem.dao.RoleMenuDao;
import com.lih.blogsystem.service.RoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (RoleMenu)表服务实现类
 *
 * @author makejava
 * @since 2022-11-20 19:13:50
 */
@Service("roleMenuService")
public class RoleMenuServiceImpl implements RoleMenuService {
    @Resource
    private RoleMenuDao roleMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RoleMenu queryById(Long id) {
        return this.roleMenuDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param roleMenu    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<RoleMenu> queryByPage(RoleMenu roleMenu, PageRequest pageRequest) {
        long total = this.roleMenuDao.count(roleMenu);
        return new PageImpl<>(this.roleMenuDao.queryAllByLimit(roleMenu, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param roleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public RoleMenu insert(RoleMenu roleMenu) {
        this.roleMenuDao.insert(roleMenu);
        return roleMenu;
    }

    /**
     * 修改数据
     *
     * @param roleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public RoleMenu update(RoleMenu roleMenu) {
        this.roleMenuDao.update(roleMenu);
        return this.queryById(roleMenu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.roleMenuDao.deleteById(id) > 0;
    }
}
