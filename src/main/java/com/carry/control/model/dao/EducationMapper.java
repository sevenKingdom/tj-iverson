package com.carry.control.model.dao;

import com.carry.control.model.po.Education;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Seven on 17/8/13.
 */
@FeignClient(value = "service-model")
@Repository
public interface EducationMapper {
    @RequestMapping(value = "/education/save",method = RequestMethod.POST)
    long save(@RequestBody Education education);
}
