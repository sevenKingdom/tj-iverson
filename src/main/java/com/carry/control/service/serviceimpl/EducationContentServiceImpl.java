package com.carry.control.service.serviceimpl;

import com.carry.control.model.dao.EducationContentMapper;
import com.carry.control.model.po.EducationContent;
import com.carry.control.service.EducationContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Seven on 17/8/6.
 */
@Service
public class EducationContentServiceImpl implements EducationContentService {

    @Autowired
    private EducationContentMapper educationContentMapper;

    @Override
    public List<EducationContent> getListByIds(String dataIds) {
        return educationContentMapper.getListByIds(dataIds);
    }
}
