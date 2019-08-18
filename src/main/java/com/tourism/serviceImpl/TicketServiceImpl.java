package com.tourism.serviceImpl;

import com.tourism.dao.TicketMapper;
import com.tourism.model.Ticket;
import com.tourism.model.TicketExample;
import com.tourism.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketMapper ticketMapper;

    @Override
    public List<Ticket> queryTicketByTime(Date start, Date end) {
        TicketExample example = new TicketExample();
        TicketExample.Criteria criteria = example.createCriteria();
        criteria.andTimeBetween(start, end);

        List<Ticket> list = ticketMapper.selectByExample(example);
        ThreadLocal<String> s = new ThreadLocal<>();
        s.set("aa");

        return list;
    }
}
