package com.prprv.customs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prprv.customs.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService extends IService<Customer> {
    IPage<Customer> getPage(int currentPage, int pageSize);
    IPage<Customer> getPage(int currentPage, int pageSize,Customer customer);
    // 先模糊查询，然后在分页。那么返回到浏览器里面，肯定是页的形式返回
}
