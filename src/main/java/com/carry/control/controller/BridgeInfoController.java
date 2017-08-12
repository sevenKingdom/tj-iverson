package com.carry.control.controller;

import com.alibaba.fastjson.JSONArray;
import com.carry.constants.Constants;
import com.carry.control.model.po.BridgeInfo;
import com.carry.control.service.BridgeInfoService;
import com.carry.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by jinming on 2017/7/18.
 */
@RestController
@RequestMapping(value = "/bridgeInfo")
public class BridgeInfoController {
    @Autowired
    private BridgeInfoService bridgeInfoService;

    @RequestMapping(value = "/saveBridgeInfo")
    public Map<String, Object> saveBridgeInfo() {
        Map<String, Object> dataMap = new HashMap<>();

        //TODO:后期可以修改成上传文件解析的形式，暂时写死路径
        try {
            String JsonContext = FileUtil.ReadFile("E:\\personal\\big_pro\\bridge\\bridgeInfo.json");
            List<BridgeInfo> bridgeInfos = JSONArray.parseArray(JsonContext, BridgeInfo.class);
            for (BridgeInfo bridgeInfo : bridgeInfos) {
                bridgeInfoService.saveBridgeInfo(bridgeInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            dataMap.put(Constants.DATA_STATUS, Constants.ERROR_CODE);
            dataMap.put(Constants.DATA_MESSAGE, "解析文件异常，请检查文件格式是否有误！");
        }
        dataMap.put(Constants.DATA_STATUS, Constants.SUCCESS_CODE);

        return dataMap;
    }

    @RequestMapping(value = "/getBridgeInfoList")
    public Map<String, Object> getBridgeInfoList() {
        Map<String, Object> dataMap = new HashMap<>();
        try {
            List<BridgeInfo> bridgeInfos = bridgeInfoService.getBridgeInfoList();
            dataMap.put(Constants.DATA_STATUS, Constants.SUCCESS_CODE);
            dataMap.put("bridgeInfos", bridgeInfos);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataMap;
    }
}
