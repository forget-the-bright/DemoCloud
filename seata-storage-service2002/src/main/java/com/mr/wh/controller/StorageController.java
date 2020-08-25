package com.mr.wh.controller;

import com.mr.wh.dao.StorageDao;
import com.mr.wh.domain.CommonResult;
import com.mr.wh.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @ClassName: StorageController
 * @Author: User
 * @date: 2020.08.25 15:09
 * @version: 1.0
 */
@RestController
public class StorageController {
    @Autowired
    private StorageService service;

    @PostMapping("/storage/decrease")
    public CommonResult decrease(Long productId,Integer count){
      service.decrease(productId, count);
      return new CommonResult(200,"扣减库存成功！");
    }
}
