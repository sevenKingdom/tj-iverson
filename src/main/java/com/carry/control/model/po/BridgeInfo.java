package com.carry.control.model.po;


import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * 桥梁信息
 * <p>
 * Created by jinming on 2017/7/19.
 */
public class BridgeInfo {
    @Id
    private String id;

    private String bridgeName;  //桥名称BridgeInfoService

    private List<Piers> piers;  //墩

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBridgeName(String bridgeName) {
        this.bridgeName = bridgeName;
    }

    public String getBridgeName() {
        return this.bridgeName;
    }

    public void setPiers(List<Piers> piers) {
        this.piers = piers;
    }

    public List<Piers> getPiers() {
        return this.piers;
    }
}
