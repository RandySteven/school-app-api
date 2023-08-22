package com.module.common.utils;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ResponseUtil implements Serializable {

    @Serial
    private static final long serialVersionUID = 5782347697185881303L;

    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseUtil.class);

    public static ResponseUtil getInstance(){
        return new ResponseUtil();
    }

//    public JSONObject responseJSON(HttpStatus status, String dataName, Object dataItem, boolean success){
//        Map<String, Object> responseMap = new HashMap<>();
//        responseMap.put("responseCode", status.value());
//        responseMap.put("responseMessage", status.getReasonPhrase());
//        responseMap.put(dataName, dataItem);
//        responseMap.put("success", success);
//        JSONObject response = new JSONObject(responseMap);
//        return response;
//    }

}
