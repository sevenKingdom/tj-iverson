package com.carry.control.service;

import com.carry.control.model.po.EducationContent;

import java.util.List;

/**
 * Created by Seven on 17/8/6.
 */
public interface EducationContentService {

    List<EducationContent> getListByIds(String dataIds);
}
