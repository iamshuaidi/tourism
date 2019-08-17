package com.tourism.controller;

import com.tourism.model.PerEmer;
import com.tourism.model.PerPlan;
import com.tourism.model.PlanEmer;
import com.tourism.model.Warning;
import com.tourism.service.EmerService;
import com.tourism.service.TestService;
import com.tourism.service.WarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/")
public class DisaterManagermentController {

    @Autowired
    TestService testService;

    @Autowired
    EmerService emerService;

    @Autowired
    WarningService warningService;

    //新增应急预案
    @CrossOrigin
    @RequestMapping(path = "/addPlan", method = RequestMethod.GET)
    @ResponseBody
    public String addPlan(Model model, @RequestParam("type") String type,
           @RequestParam("title")String title, @RequestParam("plan")String plan,
           @RequestParam("adminId")Integer adminId){
        PlanEmer planEmer = new PlanEmer();
        planEmer.setType(type);
        planEmer.setTitle(title);
        planEmer.setPlan(plan);
        planEmer.setAdminId(adminId);
        emerService.addEmerPlan(planEmer);
        //跳转到应急预案中心
        return "home";
    }

    //编辑应急预案
    @CrossOrigin
    @RequestMapping(path = "/editPlan", method = RequestMethod.GET)
    @ResponseBody
    public String editPlan(Model model, @RequestParam("id") Integer id, @RequestParam("type") String type,
                          @RequestParam("title")String title, @RequestParam("plan")String plan,
                          @RequestParam("adminId")Integer adminId){
        PlanEmer planEmer = new PlanEmer();
        planEmer.setId(id);
        planEmer.setType(type);
        planEmer.setTitle(title);
        planEmer.setPlan(plan);
        planEmer.setAdminId(adminId);
        emerService.editEmerPlan(planEmer);
        //跳转到应急预案中心
        return "home";
    }

    //删除应急预案

    //新增应急人员
    @CrossOrigin
    @RequestMapping(path = "/addPerson", method = RequestMethod.GET)
    @ResponseBody
    public String addPerson(Model model, @RequestParam("name") String name,
                          @RequestParam("phone")String phone, @RequestParam("gender")String gender,
                          @RequestParam("job")String job){
        PerEmer perEmer = new PerEmer();
        perEmer.setName(name);
        perEmer.setPhone(phone);
        perEmer.setGender(gender);
        perEmer.setJob(job);
        emerService.addPerson(perEmer);
        //跳转到应急预案中心
        return "home";
    }

    //删除应急人员分配
    @CrossOrigin
    @RequestMapping(path = "/deletePerson", method = RequestMethod.GET)
    @ResponseBody
    public String deletePerson(Model model, @RequestParam("name") String name,
                            @RequestParam("phone")String phone, @RequestParam("gender")String gender,
                            @RequestParam("job")String job){
        PerEmer perEmer = new PerEmer();
        perEmer.setName(name);
        perEmer.setPhone(phone);
        perEmer.setGender(gender);
        perEmer.setJob(job);
        emerService.deletePerson(perEmer);
        //跳转到应急预案中心
        return "home";
    }

    //分配应急预案给个人
    @CrossOrigin
    @RequestMapping(path = "/assignPlan", method = RequestMethod.GET)
    @ResponseBody
    public String assignPlan(Model model, @RequestParam("planID")Integer planId,
             @RequestParam("time")Date time, @RequestParam("perId") Integer perId,
             @RequestParam("id")Integer id){
        PerPlan perPlan = new PerPlan();
        perPlan.setId(id);
        perPlan.setTime(time);
        perPlan.setPerId(perId);
        perPlan.setPlanId(planId);
        emerService.assignPerson(perPlan);
        //跳转到应急预案中心
        return "home";
    }

    //向前端首页发送预警列表
    @CrossOrigin
    @RequestMapping(path = "/sendWarning", method = RequestMethod.POST)
    @ResponseBody
    public String sendWarning(Model model, @RequestParam("id")Integer id,
                  @RequestParam("type") String type, @RequestParam("title") String title,
                  @RequestParam("content") String content, @RequestParam("state") String state,
                  @RequestParam("time")Date time, @RequestParam("adminId")Integer adminId){
        Warning warning = new Warning();
        warning.setId(id);
        warning.setType(type);
        warning.setTitle(title);
        warning.setContent(content);
        warning.setState(state);
        warning.setTime(time);
        warning.setAdminId(adminId);
        warningService.sendWarning(warning);
        //跳转到预警中心
        return "home";
    }

    //前端发布预警，同时写入后台数据库作为新纪录
    @CrossOrigin
    @RequestMapping(path = "/createWarning", method = RequestMethod.GET)
    @ResponseBody
    public String createWarning(Model model, @RequestParam("id")Integer id,
                @RequestParam("type") String type, @RequestParam("title") String title,
                @RequestParam("content") String content, @RequestParam("state") String state,
                @RequestParam("time")Date time, @RequestParam("adminId")Integer adminId){
        Warning warning = new Warning();
        warning.setId(id);
        warning.setType(type);
        warning.setTitle(title);
        warning.setContent(content);
        warning.setState(state);
        warning.setTime(time);
        warning.setAdminId(adminId);
        warningService.createWarning(warning);
        //跳转到首页
        return "index";
    }

}
