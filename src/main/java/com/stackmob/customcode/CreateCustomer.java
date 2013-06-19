package com.stackmob.customcode;

import com.stackmob.core.InvalidSchemaException;
import com.stackmob.core.DatastoreException;
import com.stackmob.core.customcode.CustomCodeMethod;
import com.stackmob.core.rest.ProcessedAPIRequest;
import com.stackmob.core.rest.ResponseToProcess;
import com.stackmob.sdkapi.SDKServiceProvider;
import com.stackmob.sdkapi.*;

import java.net.HttpURLConnection;
import java.util.*;

import com.stripe.model.Customer;

public class CreateCustomer implements CustomCodeMethod {

    @Override
    public String getMethodName() {
        return "createCustomer";
    }

    @Override
    public List<String> getParams() {
        return Arrays.asList("token", "username");
    }

    @Override
    public ResponseToProcess execute(ProcessedAPIRequest request, SDKServiceProvider serviceProvider) {
        DataService ds = serviceProvider.getDataService();
        List<SMCondition> query = new ArrayList<SMCondition>();
        Map<String, List<SMObject>> results = new HashMap<String, List<SMObject>>();

        String username = request.getParams().get("username");

        try {
            query.add(new SMEquals("username", new SMString(username)));

            results.put("results", ds.readObjects("pnuser", query));

        } catch (InvalidSchemaException ise) {
        } catch (DatastoreException dse) {}

        return new ResponseToProcess(HttpURLConnection.HTTP_OK, results);
    }

}
