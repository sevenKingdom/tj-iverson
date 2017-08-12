package com.carry.control.model.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Seven on 17/8/6.
 */
@FeignClient(value = "service-model")
@Repository
public interface VerificationMapper {
    @RequestMapping(value = "/mysql/shortVerification" ,method = RequestMethod.GET)
    String shortVerification(@RequestParam("token") String token) ;
}
