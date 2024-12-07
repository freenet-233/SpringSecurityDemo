package com.wang.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 商品
 *
 * @author wangguangpeng
 * @date 2024/11/20 15:44
 **/
@RestController
@RequestMapping("goods")
public class GoodsController {


    @GetMapping("/getGoods")
    @PreAuthorize("hasAuthority('sys:goods:select')")
    public String getGoods() {
        return "Goods list";
    }

    @PostMapping("/addGoods")
    @PreAuthorize("hasAuthority('sys:goods:add')")
    public String addGoods() {
        return "Add Goods";
    }

    @PutMapping("/updateGoods")
    @PreAuthorize("hasAuthority('sys:goods:update')")
    public String updateGoods() {
        return "Update Goods";
    }

    @DeleteMapping("/deleteGoods")
    @PreAuthorize("hasAuthority('sys:goods:delete')")
    public String deleteGoods() {
        return "Delete Goods";
    }

    @GetMapping("/select")
    public String select() {
        return "This is IPhone 15...";
    }
}
