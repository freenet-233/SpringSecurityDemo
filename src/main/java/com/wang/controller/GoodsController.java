package com.wang.controller;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品
 *
 * @author wangguangpeng
 * @date 2024/11/20 15:44
 **/
@RestController
@RequestMapping("goods")
public class GoodsController {

    @GetMapping("/select")
    public String getGoods() {
        return "This is IPhone 15...";
    }
}
