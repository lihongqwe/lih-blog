package com.lih.blogweb.controller;

import com.lih.blogsystem.entity.DictionaryData;
import com.lih.blogsystem.service.DictionaryDataService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DictionaryData)表控制层
 *
 * @author makejava
 * @since 2022-11-20 19:13:52
 */
@RestController
@RequestMapping("dictionaryData")
public class DictionaryDataController {
    /**
     * 服务对象
     */
    @Resource
    private DictionaryDataService dictionaryDataService;

    /**
     * 分页查询
     *
     * @param dictionaryData 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<DictionaryData>> queryByPage(DictionaryData dictionaryData, PageRequest pageRequest) {
        return ResponseEntity.ok(this.dictionaryDataService.queryByPage(dictionaryData, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<DictionaryData> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.dictionaryDataService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param dictionaryData 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<DictionaryData> add(DictionaryData dictionaryData) {
        return ResponseEntity.ok(this.dictionaryDataService.insert(dictionaryData));
    }

    /**
     * 编辑数据
     *
     * @param dictionaryData 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<DictionaryData> edit(DictionaryData dictionaryData) {
        return ResponseEntity.ok(this.dictionaryDataService.update(dictionaryData));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.dictionaryDataService.deleteById(id));
    }

}

