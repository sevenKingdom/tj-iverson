package com.carry.control.model.po;

import java.util.List;

/**
 * 结构
 * <p>
 * Created by jinming on 2017/7/19.
 */
public class Structures {
    private String structureName;

    private List<Process> process;

    private int structureNum;

    private String constructionPlanFile;

    private int isNeedDemonstrate;

    public void setStructureName(String structureName) {
        this.structureName = structureName;
    }

    public String getStructureName() {
        return this.structureName;
    }

    public void setProcess(List<Process> process) {
        this.process = process;
    }

    public List<Process> getProcess() {
        return this.process;
    }

    public void setStructureNum(int structureNum) {
        this.structureNum = structureNum;
    }

    public int getStructureNum() {
        return this.structureNum;
    }

    public void setConstructionPlanFile(String constructionPlanFile) {
        this.constructionPlanFile = constructionPlanFile;
    }

    public String getConstructionPlanFile() {
        return this.constructionPlanFile;
    }

    public void setIsNeedDemonstrate(int isNeedDemonstrate) {
        this.isNeedDemonstrate = isNeedDemonstrate;
    }

    public int getIsNeedDemonstrate() {
        return this.isNeedDemonstrate;
    }
}
