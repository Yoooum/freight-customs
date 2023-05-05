package com.prprv.customs.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prprv.customs.entity.Cargo;
import com.prprv.customs.mapper.CargoMapper;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoServiceImpl extends ServiceImpl<CargoMapper, Cargo> implements CargoService {
    @Autowired
    private CargoMapper cargoMapper;

    // 查询所有的分页
    @Override
    public IPage<Cargo> getPage(int currentPage, int pageSize) {
        IPage<Cargo> page = new Page<>(currentPage, pageSize);
        cargoMapper.selectPage(page, null);
        return page;
    }

    // 先模糊查询，然后在分页。那么返回到浏览器里面，肯定是页的形式返回
    @Override
    public IPage<Cargo> getPage(int currentPage, int pageSize, Cargo cargo) {
        LambdaQueryWrapper<Cargo> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(cargo.getDestination()), Cargo::getDestination, cargo.getDestination());
        lqw.like(Strings.isNotEmpty(cargo.getName()), Cargo::getName, cargo.getName());
        lqw.like(Strings.isNotEmpty(cargo.getStatus()), Cargo::getStatus, cargo.getStatus());

        //如果得到的数据不为空，那么执行模糊查询，where book:getName like %book.getName%
        //分页
        IPage<Cargo> page = new Page<>(currentPage, pageSize);
        cargoMapper.selectPage(page, lqw);
        return page;
    }
}
