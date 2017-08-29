package com.carry.control.service.serviceimpl;

import com.carry.control.model.dao.EducationMapper;
import com.carry.control.model.po.Education;
import com.carry.control.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Seven on 17/8/13.
 */
@Service
public class EducationServiceImpl implements EducationService {
    @Autowired
    private EducationMapper educationMapper;

    @Override
    public long save(Education education) {
        return educationMapper.save(education);
    }

}
