package com.fruitsalesplatform.controller;

import com.alibaba.fastjson.JSONObject;
import com.fruitsalesplatform.entity.RetailerEntity;
import com.fruitsalesplatform.service.RetailerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

//零售商管理
@Controller
@RequestMapping(value = "/retailer")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class RetailerController extends BaseController{

    @Autowired
    RetailerService retailerService;

    //展示零售商
    @RequestMapping(value = "/list")
    public String list(RetailerEntity retailer, Model model){
        Map<String,Object> map = retailerToMap(retailer);
        List<RetailerEntity> retailerList = retailerService.find(map);

        //1.设置当前页码数
        model.addAttribute("currentPage",retailer.getCurrentPage());
        //2.获取开始的页码
        model.addAttribute("startPage",retailer.getStartPage());
        //3.获取总数据的数量
        int countNumber = retailerService.count(map);
        model.addAttribute("countNumber",countNumber);
        //4.获取每页显示的数据条数,默认显示10条
        int pageSize  = retailer.getPageSize();
        model.addAttribute("pageSize",pageSize);
        //5.
        int sumPageNumber = countNumber%pageSize==0?(countNumber/pageSize):((countNumber/pageSize)+1);
        model.addAttribute("sumPageNumber",sumPageNumber);

        model.addAttribute("list",retailerList);
        return "/retailer/retailerHome.jsp";
    }

    @RequestMapping(value = "/add")
    public String add(RetailerEntity retailer,Model model,
                      HttpServletRequest request,HttpServletResponse response) throws IOException {
        //
        Map<String,Object> map = retailerToMap(retailer);
        List<RetailerEntity> retailerList =  retailerService.find(map);
        //判断在系统中是否存在
        if((retailerList!=null)&&retailerList.size()>0){
            model.addAttribute("errorMsg","系统中已经存在了，添加失败");
            retailer = new RetailerEntity();
            retailer.setStatus(1);
            return list(retailer,model);
        }else{
            retailer.setRetailerid(UUID.randomUUID().toString());
            retailer.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            retailerService.insert(retailer);
            model.addAttribute("noticeMsg","添加成功！");
            retailer = new RetailerEntity();
            retailer.setStatus(1);
            return list(retailer,model);
        }
    }

    private Map<String,Object> retailerToMap(RetailerEntity retailer){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name",checkObjectIsEmpty(retailer.getName()));
        map.put("address",checkObjectIsEmpty(retailer.getAddress()));
        map.put("telphone",checkObjectIsEmpty(retailer.getTelphone()));
        //status
        map.put("status",retailer.getStatus());
        map.put("createtime",checkObjectIsEmpty(retailer.getCreatetime()));
        map.put("startPage",retailer.getStartPage());
        map.put("pageSize",retailer.getPageSize());

        return map;
    }

    //@ResponseBody使用此注解之后，不会再走视图处理器，而是直接将数据写入HTTP 响应正文（ResponseBody）中
    //@RequestBody 将 HTTP 请求正文插入方法中，使用适合的 HttpMessageConverter 将请求体写入某个对象
    @RequestMapping(value = "/editRetailer")
    @ResponseBody
    public RetailerEntity editRetailer(@RequestBody String json){
        String id = JSONObject.parseObject(json).getString("id");
        return retailerService.get(id);
    }

    @RequestMapping(value = "/edit")
    public String edit(RetailerEntity retailer,Model model){
        //最好验证一下是否为空
        retailerService.update(retailer);
        //创建一个新的retailer对象，传值进行查询
        RetailerEntity queryRetailer = new RetailerEntity();
        queryRetailer.setCurrentPage(retailer.getCurrentPage());
        queryRetailer.setPageSize(retailer.getPageSize());
        queryRetailer.setStartPage(retailer.getStartPage());

        queryRetailer.setStatus(-1);
        return list(queryRetailer,model);
    }

    @RequestMapping(value = "/delete")
    public String delete(RetailerEntity retailer,Model model){
        retailerService.deleteById(retailer.getRetailerid());
        //创建一个新的retailer对象，传值进行查询
        RetailerEntity queryRetailer = new RetailerEntity();
        queryRetailer.setCurrentPage(retailer.getCurrentPage());
        queryRetailer.setPageSize(retailer.getPageSize());
        queryRetailer.setStartPage(retailer.getStartPage());

        queryRetailer.setStatus(-1);
        return list(queryRetailer,model);
    }

    @Test
    public void testDemo(){
        checkObjectIsEmpty("test");
    }

    private String checkObjectIsEmpty(String param){
        //判断是否为null，如果为null，就是null
        //再判断是否为""，如果是，则为null
        //如果不是，则直接返回
        return param==null?null:(param.equals("")?null:param);
//        return param==null?null:(param.equals("")?null:"%"+param+"%");
    }



/*    private Integer checkObjectIsEmpty(Integer param){
        //判断是否为null，如果为null，就是1
        //判断是否为-1
        return param==null?1:(param==-1?1:param);
//        return param==null?null:(param.equals("")?null:"%"+param+"%");
    }*/










}
