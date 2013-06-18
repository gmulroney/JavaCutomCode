package com.stackmob.customcode;

import com.stackmob.core.customcode.CustomCodeMethod;
import com.stackmob.core.rest.ProcessedAPIRequest;
import com.stackmob.core.rest.ResponseToProcess;
import com.stackmob.sdkapi.SDKServiceProvider;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateCustomer implements CustomCodeMethod {

    @Override
    public String getMethodName() {
        return "createCustomer";
    }

    @Override
    public List<String> getParams() {
        return new ArrayList<String>();
    }

    @Override
    public ResponseToProcess execute(ProcessedAPIRequest request, SDKServiceProvider serviceProvider) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "Hello, world!");
        return new ResponseToProcess(HttpURLConnection.HTTP_OK, map);
    }

}
