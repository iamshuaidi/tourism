package com.tourism.controller;

import com.alibaba.fastjson.JSONObject;
import com.tourism.model.Hotel;
import com.tourism.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HotelController {

    @Autowired
    HotelService hotelService;
    /**
     * 查询有哪些酒店
     * @return
     */

    @CrossOrigin
    @RequestMapping(value = "/queryhotel", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String queryHotel(@RequestParam("flag") int flag){

        Map<String, Object> map = new HashMap<>();

        List<Hotel> hotels = hotelService.queryAllHetol(flag);
        if(hotels == null){
            map.put("message", "找不到对应酒店");
            return JSONObject.toJSONString(map);
        }
        map.put("message", "OK");
        map.put("hotels", hotels);

        return JSONObject.toJSONString(hotels);
    }
}
