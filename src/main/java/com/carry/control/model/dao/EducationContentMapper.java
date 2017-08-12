package com.carry.control.model.dao;

import com.carry.control.model.po.ConstructionPlan;
import com.carry.control.model.po.EducationContent;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Seven on 17/8/6.
 */
@FeignClient(value = "service-model")
@Repository
public interface EducationContentMapper {

    @RequestMapping(value = "/education-content/getListByIds", method = RequestMethod.POST)
    List<EducationContent> getListByIds(@RequestParam("dataIds") String dataIds);
}
