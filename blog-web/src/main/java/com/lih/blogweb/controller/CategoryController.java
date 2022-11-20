package com.lih.blogweb.controller;

import com.lih.blogsystem.entity.Category;
import com.lih.blogsystem.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Category)表控制层
 *
 * @author makejava
 * @since 2022-11-20 19:13:54
 */
@RestController
@RequestMapping("category")
public class CategoryController {
    /**
     * 服务对象
     */
    @Resource
    private CategoryService categoryService;

    /**
     * 分页查询
     *
     * @param category    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Category>> queryByPage(Category category, PageRequest pageRequest) {
        return ResponseEntity.ok(this.categoryService.queryByPage(category, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Category> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.categoryService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param category 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Category> add(Category category) {
        return ResponseEntity.ok(this.categoryService.insert(category));
    }

    /**
     * 编辑数据
     *
     * @param category 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Category> edit(Category category) {
        return ResponseEntity.ok(this.categoryService.update(category));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.categoryService.deleteById(id));
    }

}

