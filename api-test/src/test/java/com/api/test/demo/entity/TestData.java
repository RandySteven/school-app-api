package com.api.test.demo.entity;

import java.util.Map;

public class TestData {

    String dataId;
    String logicId;
    String description;
    DataItems dataItems;

}

class DataItems {
    Map<String, Object> dataItems;
}