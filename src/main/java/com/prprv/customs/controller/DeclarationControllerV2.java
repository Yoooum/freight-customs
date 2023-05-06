package com.prprv.customs.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.prprv.customs.entity.Customer;
import com.prprv.customs.service.CustomerService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 入关控制器
 * @author phj233
 * @since  2023/4/23 8:25
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/declaration/v2")
public class DeclarationControllerV2 {
    //自动注入service层
    @Resource
    private CustomerService customerService;

    //查询一条数据
    @GetMapping("/{id}")
    public Customer getId(@PathVariable Integer id){
        return customerService.getById(id);
    }

    //获取数据用get.查询所有的数据
    @GetMapping()
    public List<Customer> getAll(){
        return customerService.list();
    }

    //新增一条数据，用postA
    @PostMapping()
    public boolean insert(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    //根据Id更改数据：用put
    @PutMapping()
    public boolean update(@RequestBody Customer customer){
        return customerService.updateById(customer);
    }
    //根据id删除数据,用delete
    @DeleteMapping("/{id}")  //根据路径传参
    public boolean delete(@PathVariable Integer id){
        return customerService.removeById(id);
    }

    //分页查询语句
    @GetMapping("/{currentPage}/{pageSize}")
    public IPage<Customer> getPage(@PathVariable int currentPage, @PathVariable int pageSize){
        return customerService.getPage(currentPage,pageSize);
    }
}
