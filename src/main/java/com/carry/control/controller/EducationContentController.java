package com.carry.control.controller;

import com.carry.common.CommonResponse;
import com.carry.constants.Constants;
import com.carry.control.model.po.Configdata;
import com.carry.control.model.po.ConstructionPlan;
import com.carry.control.model.po.EducationContent;
import com.carry.control.service.ConfigService;
import com.carry.control.service.ConstructionPlanService;
import com.carry.control.service.EducationContentService;
import com.carry.util.DateUtil;
import com.carry.util.ParamUtil;

import com.alibaba.fastjson.JSONArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by Seven on 17/8/6.
 */
@RestController
@RequestMapping(value = "/education-content")
public class EducationContentController {

    //private static final Integer EDUCATION_CONFIG_ID = 4;
    private static final Integer EDUCATION_CONFIG_ID = 8;


    @Autowired
    private EducationContentService educationContentService;
    @Autowired
    private ConstructionPlanService constructionPlanService;
    @Autowired
    private ConfigService configService;

    @RequestMapping(value = "/getEducationContent", method = RequestMethod.POST)
    public CommonResponse<Map<String, Object>> getEducationContent(@RequestParam("classId") Long classId) {
        CommonResponse<Map<String, Object>> commonResponse = new CommonResponse<>();
        Map<String, Object> data = new HashMap<>();
        Set<Integer> educationIds = new HashSet<>();

        Configdata configdata = configService.getConfig(EDUCATION_CONFIG_ID);   //获取工前教育配置数据
        JsonObject jsonObject = configdata.getConfigdata();
        JsonObject tempObject;

        Long startTime = DateUtil.getStartTime().getTimeInMillis();
        Long endTime = DateUtil.getEndTime().getTimeInMillis();
        List<ConstructionPlan> constructionPlanList = constructionPlanService.getOneDayProcessListByClassId(startTime, endTime, classId);

        for (ConstructionPlan constructionPlan : constructionPlanList) {
            tempObject = jsonObject.getAsJsonObject("桥梁").getAsJsonObject(constructionPlan.getStructure())
                    .getAsJsonObject(constructionPlan.getProcess()).getAsJsonObject(constructionPlan.getWhether());
            Set<Map.Entry<String, JsonElement>> entrySet = tempObject.entrySet();
            for (Iterator<Map.Entry<String, JsonElement>> iter = entrySet.iterator(); iter.hasNext(); ) {
                Map.Entry<String, JsonElement> entry = iter.next();
                List<Integer> ids = JSONArray.parseArray(entry.getValue().toString(), Integer.class);
                educationIds.addAll(ids);
            }
        }

        String educationIdStr = ParamUtil.listInteger2String(new ArrayList(educationIds));
        List<EducationContent> educationContents = educationContentService.getListByIds(educationIdStr);
        data.put("educationContents", educationContents);
        commonResponse.setStatus(Constants.SUCCESS_CODE);
        commonResponse.setData(data);

        return commonResponse;
    }
}
