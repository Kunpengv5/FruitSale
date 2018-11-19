package com.fruitsalesplatform.controller;

import com.fruitsalesplatform.entity.RetailerEntity;
import com.fruitsalesplatform.service.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//零售商管理
@Controller
@RequestMapping(value = "/retailer")
public class RetailerController extends BaseController{

    @Autowired
    RetailerService retailerService;

    //暂时跳转到home页面
    @RequestMapping(value = "/list")
    public String list(RetailerEntity retailer, Model model,
                       HttpServletRequest request, HttpServletResponse response){
        Map<String,String> map = new HashMap<String,String >();
        map.put("name",retailer.getName());
        map.put("address",retailer.getAddress());
        map.put("telphone",retailer.getTelphone());
        map.put("status",retailer.getStatus().toString());
//        map.put("telphone",retailer.getCreatetime());

        List<RetailerEntity> retailerList = retailerService.find(map);
        model.addAttribute("list",retailerList);

        return "/retailer/retailerHome.jsp";
    }










}
