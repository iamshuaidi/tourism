package com.tourism.serviceImpl;

import com.tourism.dao.HotelMapper;
import com.tourism.model.Hotel;
import com.tourism.model.HotelExample;
import com.tourism.service.HotelService;
import com.tourism.util.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelMapper hotelMapper;
    @Override
    public List<Hotel> queryAllHetol(int flag) {

        HotelExample example = new HotelExample();
        HotelExample.Criteria criteria = example.createCriteria();
        if(flag == Sort.JULI){
            example.setOrderByClause("distance");
        }else if(flag == Sort.RENQI){
            example.setOrderByClause("popularity");
        }else if(flag == Sort.KONGFANG){
            example.setOrderByClause("vacancy");
        }
        List<Hotel> list = hotelMapper.selectByExample(example);
        return list;
    }
}
