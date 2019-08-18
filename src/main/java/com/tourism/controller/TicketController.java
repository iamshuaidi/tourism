package com.tourism.controller;

import com.alibaba.fastjson.JSONObject;
import com.tourism.model.Ticket;
import com.tourism.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TicketController {

    @Autowired
    TicketService ticketService;
    /**
     * 根据时间范围来查询票务情况
     * @param start
     * @param end
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/queryticket", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String queryTicket(@RequestParam("start") String start, @RequestParam("end") String end) throws Exception{
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("end = " + start + "; end = " + end);
        Date timeStart = sp.parse(start);
        Date timeEnd = sp.parse(end);

        Map<String, Object> map = new HashMap<>();

        List<Ticket> tickets = ticketService.queryTicketByTime(timeStart, timeEnd);
        if(tickets == null){
            map.put("message", "查询不到对应的票务");
            return JSONObject.toJSONString(tickets);
        }
        map.put("message", "OK");
        map.put("tickets", tickets);

        return JSONObject.toJSONString(tickets);
    }

    public static void main (String[] args) throws Exception{
        String s = "2019-08-09";
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sp.parse(s);
        System.out.println(date.toString());
    }
}
