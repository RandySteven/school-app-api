package com.api.test.demo.entity;

import java.util.Map;

public class TestData {

    private String dataId;
    private String logicId;
    private String description;
    private DataItems dataItems;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getLogicId() {
        return logicId;
    }

    public void setLogicId(String logicId) {
        this.logicId = logicId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DataItems getDataItems() {
        return dataItems;
    }

    public void setDataItems(DataItems dataItems) {
        this.dataItems = dataItems;
    }

    public TestData(String dataId, String logicId, String description, DataItems dataItems) {
        this.dataId = dataId;
        this.logicId = logicId;
        this.description = description;
        this.dataItems = dataItems;
    }
}

class DataItems {
    private Map<String, Object> dataItems;

    public Map<String, Object> getDataItems() {
        return dataItems;
    }

    public void setDataItems(Map<String, Object> dataItems) {
        this.dataItems = dataItems;
    }

    public DataItems(Map<String, Object> dataItems) {
        this.dataItems = dataItems;
    }
}