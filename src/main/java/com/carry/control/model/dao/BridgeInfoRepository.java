package com.carry.control.model.dao;

import com.carry.control.model.po.BridgeInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by zj on 2017/7/19.
 */
@FeignClient(value = "service-model")
@Repository
public interface BridgeInfoRepository {
    @GetMapping(value = "/bridgeInfo/getBridgeInfoList")
    List<BridgeInfo> getBridgeInfoList();

    @RequestMapping(value = "/bridgeInfo/save",method = RequestMethod.POST)
    long save(@RequestBody BridgeInfo bridgeInfo);
}
