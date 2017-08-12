package com.carry.control.service;


import com.carry.control.model.po.BridgeInfo;

import java.util.List;

/**
 * Created by zj on 2017/7/19.
 */
public interface BridgeInfoService {

    /**
     * 存储桥梁信息
     *
     * @param bridgeInfo
     * @return
     */
    long saveBridgeInfo(BridgeInfo bridgeInfo) throws Exception;

    /**
     * 获取桥梁信息
     *
     * @return
     * @throws Exception
     */
    List<BridgeInfo> getBridgeInfoList() throws Exception;
}
