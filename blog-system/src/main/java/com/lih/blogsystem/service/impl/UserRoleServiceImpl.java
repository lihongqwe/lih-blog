package com.lih.blogsystem.service.impl;

import com.lih.blogsystem.entity.UserRole;
import com.lih.blogsystem.dao.UserRoleDao;
import com.lih.blogsystem.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (UserRole)表服务实现类
 *
 * @author makejava
 * @since 2022-11-20 19:13:55
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
    private UserRoleDao userRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserRole queryById(Long id) {
        return this.userRoleDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param userRole    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<UserRole> queryByPage(UserRole userRole, PageRequest pageRequest) {
        long total = this.userRoleDao.count(userRole);
        return new PageImpl<>(this.userRoleDao.queryAllByLimit(userRole, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    @Override
    public UserRole insert(UserRole userRole) {
        this.userRoleDao.insert(userRole);
        return userRole;
    }

    /**
     * 修改数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    @Override
    public UserRole update(UserRole userRole) {
        this.userRoleDao.update(userRole);
        return this.queryById(userRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.userRoleDao.deleteById(id) > 0;
    }
}
