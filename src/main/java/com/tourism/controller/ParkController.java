package com.tourism.controller;

import com.alibaba.fastjson.JSONObject;
import com.tourism.model.Park;
import com.tourism.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ParkController {

    @Autowired
    ParkService parkService;
    /**
     * 查询有哪些停车位
     * @return
     */

    @CrossOrigin
    @RequestMapping(value = "/querypark", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String queryPark(){
        Map<String ,Object> map = new HashMap<>();

        List<Park> parks = parkService.queryAllPark();
        if(parks == null){
            map.put("message", "找不到对应停车位");
            return JSONObject.toJSONString(map);
        }
        map.put("message", "OK");
        map.put("parks", parks);

        return JSONObject.toJSONString(map);
    }
}
