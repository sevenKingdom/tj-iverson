package com.carry.control.service.serviceimpl;

import com.carry.control.model.dao.ConstructionPlanMapper;
import com.carry.control.model.po.ConstructionPlan;
import com.carry.control.service.ConstructionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by zj on 2017/7/17.
 */
@Service
public class ConstructionPlanServiceImpl implements ConstructionPlanService {
    @Autowired
    private ConstructionPlanMapper constructionPlanMapper;

    /**
     * 获取一天的任务
     *
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public List<ConstructionPlan> getOneDayList(Long startTime, Long endTime, String technicianIds) {
        return constructionPlanMapper.getOneDayList(startTime, endTime, technicianIds);
    }

    /**
     * 插入计划
     *
     * @param constructionPlan
     * @return
     */
    @Override
    public long saveConstructionPlan(ConstructionPlan constructionPlan) {
        return constructionPlanMapper.saveConstructionPlan(constructionPlan);
    }

    /**
     * 根据工班长id获取当天计划列表
     *
     * @param startTime
     * @param endTime
     * @param classId
     * @return
     */
    @Override
    public List<ConstructionPlan> getOneDayProcessListByClassId(Long startTime, Long endTime, Long classId) {
        return constructionPlanMapper.getOneDayProcessListByClassId(startTime, endTime, classId);
    }

    /**
     * 根据部门获取技术员id列表
     *
     * @param department
     * @return
     */
    @Override
    public List<Long> getTechnicianIdList(String department) {
        return constructionPlanMapper.getTechnicianIdList(department);
    }

    @Override
    public int delPlanData(long id) {
        return constructionPlanMapper.delPlanData(id);
    }

}
