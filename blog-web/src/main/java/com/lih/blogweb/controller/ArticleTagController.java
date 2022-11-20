package com.lih.blogweb.controller;

import com.lih.blogsystem.entity.ArticleTag;
import com.lih.blogsystem.service.ArticleTagService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ArticleTag)表控制层
 *
 * @author makejava
 * @since 2022-11-20 19:13:53
 */
@RestController
@RequestMapping("articleTag")
public class ArticleTagController {
    /**
     * 服务对象
     */
    @Resource
    private ArticleTagService articleTagService;

    /**
     * 分页查询
     *
     * @param articleTag  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<ArticleTag>> queryByPage(ArticleTag articleTag, PageRequest pageRequest) {
        return ResponseEntity.ok(this.articleTagService.queryByPage(articleTag, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ArticleTag> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.articleTagService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param articleTag 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<ArticleTag> add(ArticleTag articleTag) {
        return ResponseEntity.ok(this.articleTagService.insert(articleTag));
    }

    /**
     * 编辑数据
     *
     * @param articleTag 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<ArticleTag> edit(ArticleTag articleTag) {
        return ResponseEntity.ok(this.articleTagService.update(articleTag));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.articleTagService.deleteById(id));
    }

}

