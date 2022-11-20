package com.lih.blogweb.controller;

import com.lih.blogsystem.entity.Article;
import com.lih.blogsystem.service.ArticleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Article)表控制层
 *
 * @author makejava
 * @since 2022-11-20 19:13:53
 */
@RestController
@RequestMapping("article")
public class ArticleController {
    /**
     * 服务对象
     */
    @Resource
    private ArticleService articleService;

    /**
     * 分页查询
     *
     * @param article     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Article>> queryByPage(Article article, PageRequest pageRequest) {
        return ResponseEntity.ok(this.articleService.queryByPage(article, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Article> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.articleService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param article 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Article> add(Article article) {
        return ResponseEntity.ok(this.articleService.insert(article));
    }

    /**
     * 编辑数据
     *
     * @param article 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Article> edit(Article article) {
        return ResponseEntity.ok(this.articleService.update(article));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.articleService.deleteById(id));
    }

}

