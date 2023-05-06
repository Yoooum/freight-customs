package com.prprv.customs.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.prprv.customs.entity.Cargo;
import com.prprv.customs.service.CargoService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 出关控制器
 * @author phj233
 * @since 2023/4/23 8:34
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/clearance/v2")
public class ClearanceControllerV2 {
    //自动注入service层
    @Resource
    private CargoService cargoService;

    //查询一条数据
    @GetMapping("/{id}")
    public Cargo getId(@PathVariable Integer id){
        return cargoService.getById(id);
    }

    //获取数据用get.查询所有的数据
    @GetMapping()
    public List<Cargo> getAll(){
        return cargoService.list();
    }

    //新增一条数据，用post
    @PostMapping()
    public boolean insert(@RequestBody Cargo cargo){
        return cargoService.save(cargo);
    }

    //根据Id更改数据：用put
    @PutMapping()
    public boolean update(@RequestBody Cargo cargo){
        return cargoService.updateById(cargo);
    }
    //根据id删除数据,用delete
    @DeleteMapping("/{id}")  //根据路径传参
    public boolean delete(@PathVariable Integer id){
        return cargoService.removeById(id);
    }

    //分页查询语句
    @GetMapping("/{currentPage}/{pageSize}")
    public IPage<Cargo> getPage(@PathVariable int currentPage, @PathVariable int pageSize){
        return cargoService.getPage(currentPage,pageSize);
    }
}
