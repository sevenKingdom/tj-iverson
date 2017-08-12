package com.carry.control.model.po;

import java.util.List;

/**
 * 墩
 * Created by jinming on 2017/7/19.
 */
public class Piers {
    private String pierNum;

    private String pierPosition;

    private List<Structures> structures;

    private String otherInfo;

    public void setPierNum(String pierNum) {
        this.pierNum = pierNum;
    }

    public String getPierNum() {
        return this.pierNum;
    }

    public void setPierPosition(String pierPosition) {
        this.pierPosition = pierPosition;
    }

    public String getPierPosition() {
        return this.pierPosition;
    }

    public void setStructures(List<Structures> structures) {
        this.structures = structures;
    }

    public List<Structures> getStructures() {
        return this.structures;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public String getOtherInfo() {
        return this.otherInfo;
    }
}
