package com.prprv.customs.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prprv.customs.entity.Customer;
import com.prprv.customs.mapper.CustomerMapper;
import jakarta.annotation.Resource;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
    @Resource
    private CustomerMapper customerMapper;

    // 查询所有的分页
    @Override
    public IPage<Customer> getPage(int currentPage, int pageSize) {
        IPage<Customer> page = new Page<>(currentPage, pageSize);
        customerMapper.selectPage(page, null);
        return page;
    }


     //先模糊查询，然后在分页。那么返回到浏览器里面，肯定是页的形式返回
    @Override
    public IPage<Customer> getPage(int currentPage, int pageSize, Customer customer) {
        LambdaQueryWrapper<Customer> lqw = new LambdaQueryWrapper<>();
        //lqw.like(Strings.isNotEmpty(customer.getId()), Customer::getId, customer.getId());
        lqw.like(Strings.isNotEmpty(customer.getName()), Customer::getName, customer.getName());
        lqw.like(Strings.isNotEmpty(customer.getContact()), Customer::getContact, customer.getContact());

        //如果得到的数据不为空，那么执行模糊查询，where book:getName like %book.getName%
        //分页
        IPage<Customer> page = new Page<>(currentPage, pageSize);
        customerMapper.selectPage(page, lqw);
        return page;
    }
}