package com.prprv.customs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prprv.customs.entity.Cargo;
import org.springframework.stereotype.Service;

@Service
public interface CargoService extends IService<Cargo> {
     public IPage<Cargo> getPage(int currentPage, int pageSize);
     public IPage<Cargo> getPage(int currentPage, int pageSize,Cargo cargo);

}
