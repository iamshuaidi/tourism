package com.tourism.service;

import com.tourism.model.Ticket;

import java.util.Date;
import java.util.List;

public interface TicketService {

    List<Ticket> queryTicketByTime(Date start, Date end);
}
