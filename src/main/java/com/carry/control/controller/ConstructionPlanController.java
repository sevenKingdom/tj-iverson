package com.carry.control.controller;

import com.carry.common.CommonResponse;
import com.carry.constants.Constants;
import com.carry.control.model.dao.VerificationMapper;
import com.carry.control.model.po.ConstructionPlan;
import com.carry.control.service.ConstructionPlanService;
import com.carry.util.DateUtil;
import com.carry.util.ParamUtil;
import freemarker.ext.beans.HashAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by jinming on 2017/7/17.
 */
@RestController
@RequestMapping(value = "/construction-plan")
public class ConstructionPlanController {

    @Autowired
    private ConstructionPlanService constructionPlanService;
    @Autowired
    private VerificationMapper verificationMapper;

    @RequestMapping(value = "/getOneDayList")
    public CommonResponse<List> getOneDayList(@RequestParam("token") String token){
        CommonResponse<List> commonResponse = new CommonResponse<>();

        String department = verificationMapper.shortVerification(token);
        if (null == department || department.isEmpty()) {
            Map<String, Object> errorMap = new HashMap<>();
            errorMap.put(Constants.DATA_MESSAGE, "error");
            errorMap.put(Constants.DATA_STATUS, Constants.ERROR_CODE);
            commonResponse.setErrorcode(errorMap);
            return commonResponse;
        }
        List<Long> technicianIdList = constructionPlanService.getTechnicianIdList(department);
        String technicianIds = ParamUtil.list2String(technicianIdList);

        Long startTime = DateUtil.getStartTime().getTimeInMillis();
        Long endTime = DateUtil.getEndTime().getTimeInMillis();

        List<ConstructionPlan> constructionPlanList = constructionPlanService.getOneDayList(startTime, endTime, technicianIds);
        commonResponse.setData(constructionPlanList);
        commonResponse.setStatus(Constants.SUCCESS_CODE);

        return commonResponse;
    }

    @RequestMapping(value = "/savePlan", method = RequestMethod.POST)
    public Map<String,Object> savePlan(@RequestBody ConstructionPlan constructionPlan){
        Map<String, Object> dataMap = new HashMap<>();

        //TODO:check

//        ConstructionPlan constructionPlan = new ConstructionPlan();
//        constructionPlan.setBridgeName("天字号大桥");
//        constructionPlan.setPierNum("敦敦敦");
//        constructionPlan.setStructure("结构1");
//        constructionPlan.setProcess("process");
//        constructionPlan.setCategory("未知");
//        constructionPlan.setIsNeedDemonstrate((short) 1);
//        constructionPlan.setIsNeedApprove((short) 0);
//        constructionPlan.setTechnicianId(-101L);
//        constructionPlan.setCreatedAt(System.currentTimeMillis());

        long planId = constructionPlanService.saveConstructionPlan(constructionPlan);

        if (0 != planId) {
            dataMap.put(Constants.DATA_STATUS, Constants.SUCCESS_CODE);
        }else{
            dataMap.put(Constants.DATA_STATUS, Constants.ERROR_CODE);
        }

        dataMap.put("planId", planId);

        return dataMap;
    }

}
