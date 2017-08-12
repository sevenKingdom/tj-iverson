package com.carry.control.controller;

import com.carry.common.CommonResponse;
import com.carry.control.service.ConstructionPlanService;
import com.carry.control.service.EducationContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Seven on 17/8/6.
 */
@RestController
@RequestMapping(value = "/education-content")
public class EducationContentController {

    @Autowired
    private EducationContentService educationContentService;
    @Autowired
    private ConstructionPlanService constructionPlanService;

    @RequestMapping(value = "/getEducationContent")
    public CommonResponse<Map<String, Object>> getEducationContent(@RequestParam("classId") String classId) {
        CommonResponse<Map<String, Object>> commonResponse = new CommonResponse<>();
        Map<String, Object> data = new HashMap<>();



        return commonResponse;
    }
}
