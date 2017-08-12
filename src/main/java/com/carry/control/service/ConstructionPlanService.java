package com.carry.control.service;


import com.carry.control.model.po.ConstructionPlan;

import java.util.List;

/**
 * Created by zj on 2017/7/17.
 */
public interface ConstructionPlanService {
    /**
     * 获取一天的任务
     *
     * @param startTime
     * @param endTime
     * @return
     */
    List<ConstructionPlan> getOneDayList(Long startTime, Long endTime, String technicianIds);

    /**
     * 插入计划
     *
     * @param constructionPlan
     * @return
     */
    long saveConstructionPlan(ConstructionPlan constructionPlan);

    /**
     * 根据部门获取技术员id列表
     *
     * @param department
     * @return
     */
    List<Long> getTechnicianIdList(String department);
}
