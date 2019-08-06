package com.tourism.controller;


import com.tourism.model.Complaint;
import com.tourism.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("")
public class TouristController {

    @Autowired
    TouristService touristService;
    // 游客提交投诉表单
    /*@RequestMapping(value="doComplaint",method= RequestMethod.POST)
    public String doComplaint(@RequestParam("content") String content){

        return "home";

    }*/

    //游客提交投诉表单
    @CrossOrigin
    @RequestMapping(value = "doComplaint")
    public void doComplaint(@RequestParam("content") String content) {
        Complaint complaint = new Complaint();
        complaint.setContent(content);
        touristService.addComplaint(complaint);
    }

    //游客查询自己的投诉
    @CrossOrigin
    @RequestMapping(value = "getComplaint")
    public Complaint getComplaint(@RequestParam("id") Integer id){
        Complaint complaint = new Complaint();
        complaint = touristService.queryComplaint(id);
        System.out.println(complaint.getId());
        return complaint;
    }




 /*   @RequestMapping(value = "index")
    public String toCkeditor(){
        return "ckeditor";
    }
*/


}
