package com.carry.control.controller;

import com.carry.common.CommonResponse;
import com.carry.constants.Constants;
import com.carry.control.model.po.Education;
import com.carry.control.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.security.x509.EDIPartyName;

import java.util.List;

/**
 * Created by Seven on 17/8/13.
 */
@RestController
@RequestMapping(value = "/education")
public class EducationController {

    @Autowired
    private EducationService educationService;

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public CommonResponse<Long> save(@RequestBody Education education) {
        CommonResponse<Long> result = new CommonResponse<>();
        education.setCreatedAt(System.currentTimeMillis());
        long educationId = educationService.save(education);
        result.setData(educationId);
        result.setStatus(Constants.SUCCESS_CODE);

        return result;
    }
}
