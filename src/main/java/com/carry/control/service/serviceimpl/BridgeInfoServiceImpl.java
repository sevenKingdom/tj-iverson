package com.carry.control.service.serviceimpl;

import com.carry.control.model.dao.BridgeInfoRepository;
import com.carry.control.model.po.BridgeInfo;
import com.carry.control.service.BridgeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zj on 2017/7/19.
 */
@Service
public class BridgeInfoServiceImpl implements BridgeInfoService {
    @Autowired
    private BridgeInfoRepository bridgeInfoRepository;

    @Override
    public long saveBridgeInfo(BridgeInfo bridgeInfo) throws Exception {
        return bridgeInfoRepository.save(bridgeInfo);
    }

    @Override
    public List<BridgeInfo> getBridgeInfoList() throws Exception {
        return bridgeInfoRepository.getBridgeInfoList();
    }
}
