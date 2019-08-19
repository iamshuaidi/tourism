package com.tourism.controller;

import com.tourism.model.PerEmer;
import com.tourism.model.PerPlan;
import com.tourism.model.PlanEmer;
import com.tourism.model.Warning;
import com.tourism.service.EmerService;
import com.tourism.service.WarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class DisaterManagermentController {
    @Autowired
    EmerService emerService;

    @Autowired
    WarningService warningService;

    //新增应急预案
    @CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
    @RequestMapping(path = "/addPlan", method = RequestMethod.GET)
    @ResponseBody
    public void addPlan(Model model, @RequestParam("type") String type,
           @RequestParam("title")String title, @RequestParam("plan")String plan){
        PlanEmer planEmer = new PlanEmer();
        planEmer.setType(type);
        planEmer.setTitle(title);
        planEmer.setPlan(plan);
        planEmer.setAdminId(1);//adminID应该由管理员登录之后前端给出（NewPlan）
        emerService.addEmerPlan(planEmer);
        //跳转到应急预案中心
//        return "home";
    }

    //编辑应急预案
    //@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
    @RequestMapping(path = "/editPlan", method = RequestMethod.POST)
    @ResponseBody
    public PlanEmer editPlan(@RequestParam("id") Integer id, @RequestParam("type") String type,
                          @RequestParam("title")String title, @RequestParam("plan")String plan
                       ){
        PlanEmer planEmer = new PlanEmer();
        planEmer.setId(id);
        planEmer.setType(type);
        planEmer.setTitle(title);
        planEmer.setPlan(plan);
        planEmer.setAdminId(1);
        emerService.editEmerPlan(planEmer);
        //跳转到应急预案中心
        return planEmer;
    }

    //删除应急预案
    @CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
    @RequestMapping(path = "/deletePlan", method = RequestMethod.GET)
    @ResponseBody
    public String deletePlan(Model model, @RequestParam("id") Integer id, @RequestParam("type") String type,
                           @RequestParam("title")String title, @RequestParam("plan")String plan,
                           @RequestParam("adminId")Integer adminId){
        PlanEmer planEmer = new PlanEmer();
        planEmer.setId(id);
        planEmer.setType(type);
        planEmer.setTitle(title);
        planEmer.setPlan(plan);
        planEmer.setAdminId(adminId);
        emerService.deleteEmerPlan(planEmer);
        //跳转到应急预案中心
        return "home";
    }
    //展示应急人员
    @CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
    @RequestMapping(path = "/showPlans", method = RequestMethod.GET)
    @ResponseBody
    public List<PlanEmer> showPlans(){
        return emerService.showPlans();
        //跳转到应急预案中心
//        return "home";
    }

    //新增应急人员
    @CrossOrigin
    @RequestMapping(path = "/addPerson", method = RequestMethod.POST)
    @ResponseBody
    public void addPerson(Model model, @RequestParam("job")String job,
          @RequestParam("name") String name,@RequestParam("gender")String gender,@RequestParam("phone")String phone){
        PerEmer perEmer = new PerEmer();
//        perEmer.setId(id);
        perEmer.setName(name);
        perEmer.setPhone(phone);
        perEmer.setGender(gender);
        perEmer.setJob(job);
        emerService.addPerson(perEmer);
        //跳转到应急预案中心
        /*return "home";*/
    }

    //删除应急人员
    @CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
    @RequestMapping(path = "/deletePerson", method = RequestMethod.GET)
    @ResponseBody
    public void deletePerson(Model model, @RequestParam("id")int id){
        PerEmer perEmer = new PerEmer();
        perEmer.setId(id);
        emerService.deletePerson(perEmer);
        //跳转到应急预案中心
//        return "home";
    }

    //修改应急人员
    @CrossOrigin
    @RequestMapping(path = "/editPerson", method = RequestMethod.POST)
    @ResponseBody
    public PerEmer editPerson(@RequestParam("id") Integer id,@RequestParam("name") String name, @RequestParam("job")String job,@RequestParam("gender")String gender,@RequestParam("phone")String phone){
        PerEmer perEmer = new PerEmer();
        perEmer.setId(id);
        perEmer.setName(name);
        perEmer.setPhone(phone);
        perEmer.setGender(gender);
        perEmer.setJob(job);
        emerService.editPerson(perEmer);
        return perEmer;
        //跳转到应急预案中心
//        return "home";
    }

    //展示应急人员
    @CrossOrigin
    @RequestMapping(path = "/showPerson", method = RequestMethod.GET)
    @ResponseBody
    public List<PerEmer> showPerson(){
        return emerService.showPerson();
        //跳转到应急预案中心
//        return "home";
    }

    //分配应急预案给个人
    @CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
    @RequestMapping(path = "/assignPlan", method = RequestMethod.POST)
    @ResponseBody
    public PerPlan assignPlan(Model model, @RequestParam("planID")Integer planId,
                              @RequestParam("time")Date time, @RequestParam("perId") Integer perId){
        PerPlan perPlan = new PerPlan();
        perPlan.setTime(time);
        perPlan.setPerId(perId);
        perPlan.setPlanId(planId);
        emerService.assignPerson(perPlan);
        return perPlan;
        //跳转到应急预案中心
//        return "home";
    }

    //删除应急人员分配
    @CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
    @RequestMapping(path = "/deletePersonAssign", method = RequestMethod.GET)
    @ResponseBody
    public void deletePersonAssign(Model model, @RequestParam("id") Integer id,
                            @RequestParam("time")Date time, @RequestParam("perID")Integer perID,
                            @RequestParam("planId")Integer planId){
        PerPlan perPlan = new PerPlan();
        perPlan.setId(id);
        perPlan.setTime(time);
        perPlan.setPerId(perID);
        perPlan.setPlanId(planId);
        emerService.deletePersonAssign(perPlan);
        //跳转到应急预案中心
//        return "home";
    }

    //显示个人信息
    @CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
    @RequestMapping(path = "/showPerInfo", method = RequestMethod.GET)
    @ResponseBody
    public PerEmer showPerInfo(Model model, @RequestParam("id")Integer id,
                              @RequestParam("name")String name, @RequestParam("phone") String phone,
                              @RequestParam("gender")String gender, @RequestParam("job") String job){
        PerEmer perEmer = new PerEmer();
        perEmer.setId(id);
        perEmer.setName(name);
        perEmer.setPhone(phone);
        perEmer.setGender(gender);
        perEmer.setJob(job);
        emerService.showPerInfo(perEmer);
        return perEmer;
    }

    //向前端首页发送预警列表
    @CrossOrigin
    @RequestMapping(path = "/sendWarning", method = RequestMethod.GET)
    @ResponseBody
    public List<Warning> sendWarning(){
        List<Warning> warningList = warningService.sendWarning();
        //跳转到预警中心
//        return "home";
        return warningList;
    }

    //前端发布预警，同时写入后台数据库作为新纪录
    //@CrossOrigin
    @RequestMapping(path = "/createWarning", method = RequestMethod.POST)
    @ResponseBody
    public void createWarning(@RequestParam("type") String type, @RequestParam("title") String title,
                                @RequestParam("content") String content
                       ){
        Date date = new Date();
        Warning warning = new Warning();
        warning.setType(type);
        warning.setTitle(title);
        warning.setContent(content);
        warning.setState("正在预警");
        warning.setTime(date);
        warning.setAdminId(1);
        warningService.createWarning(warning);
        //跳转到首页
//        return "index";
    }

    //更改预警状态
    @CrossOrigin
    @RequestMapping(path = "/stopWarning", method = RequestMethod.GET)
    @ResponseBody
    public void stopWarning(Model model, @RequestParam("id")Integer id){
        warningService.stopWarning(id);
        //跳转到首页
//        return "index";
    }

}
