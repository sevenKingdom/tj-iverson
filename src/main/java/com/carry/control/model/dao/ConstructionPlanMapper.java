package com.carry.control.model.dao;

import com.carry.control.model.po.ConstructionPlan;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zj on 2017/7/17.
 */
@FeignClient(value = "service-model")
@Repository
public interface ConstructionPlanMapper {
    @GetMapping(value = "/construction-plan/getOneDayList")
    List<ConstructionPlan> getOneDayList(@RequestParam("startTime") Long startTime, @RequestParam("endTime") Long endTime, @RequestParam("technicianIds") String technicianIds);

    @RequestMapping(value = "/construction-plan/save",method = RequestMethod.POST)
    long saveConstructionPlan(@RequestBody ConstructionPlan constructionPlan);

    @RequestMapping(value = "/construction-plan/getOneDayProcessListByClassId")
    List<ConstructionPlan> getOneDayProcessListByClassId(@RequestParam("startTime") Long startTime, @RequestParam("endTime") Long endTime, @RequestParam("classId") Long classId);

    @RequestMapping(value = "/construction-plan/getTechnicianid",method = RequestMethod.POST)
    List<Long> getTechnicianIdList(@RequestParam("department") String department);
}
