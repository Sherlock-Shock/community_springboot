package com.lee.community.serviceimpl;

import com.lee.community.mapper.ForeignPeoMapper;
import com.lee.community.pojo.ForeignPeo;
import com.lee.community.service.ForeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ForeignServiceImpl implements ForeignService {
    @Autowired
    ForeignPeoMapper foreignPeoMapper;

    @Override
    public List<ForeignPeo> queryForeignPeoByName(String personName) {
        return foreignPeoMapper.queryForeignPeoByName(personName);
    }

    @Override
    public int deleteForeignByNo(String[] ids) {
        return foreignPeoMapper.deleteForeignByNo(ids);
    }

    @Override
    public int addForeignPeo(ForeignPeo foreignPeo) {
        foreignPeo.setPersonNo("200"+String.valueOf(new Date().getTime()));
        return foreignPeoMapper.addForeignPeo(foreignPeo);
    }

    @Override
    public int updateOutTimeByNo(ForeignPeo foreignPeo) {
        return foreignPeoMapper.updateOutTimeByNo(foreignPeo);
    }
}
