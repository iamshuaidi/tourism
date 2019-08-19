package com.tourism.serviceImpl;

import com.tourism.dao.ParkMapper;
import com.tourism.model.Park;
import com.tourism.model.ParkExample;
import com.tourism.service.ParkService;
import com.tourism.util.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkServiceImpl implements ParkService {
    @Autowired
    ParkMapper parkMapper;

    @Override
    public List<Park> queryAllPark(int flag) {

        ParkExample example = new ParkExample();
        ParkExample.Criteria criteria = example.createCriteria();
        if(flag == Sort.JULI){
            example.setOrderByClause("distance");
        }else if(flag == Sort.KONGFANG){
            example.setOrderByClause("vacancy");
        }else if(flag == Sort.FEIYONG){
            example.setOrderByClause("fee");
        }

        List<Park> list = parkMapper.selectByExample(example);

        return list;
    }
}
