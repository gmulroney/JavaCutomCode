package com.stackmob.customcode;

import com.stackmob.core.InvalidSchemaException;
import com.stackmob.core.DatastoreException;
import com.stackmob.core.customcode.CustomCodeMethod;
import com.stackmob.core.rest.ProcessedAPIRequest;
import com.stackmob.core.rest.ResponseToProcess;
import com.stackmob.customcode.Util;
import com.stackmob.sdkapi.SDKServiceProvider;
import com.stackmob.sdkapi.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.HttpURLConnection;
import java.util.*;

import com.stripe.model.Customer;
import com.stripe.exception.*;

public class CreateCustomer implements CustomCodeMethod {

    @Override
    public String getMethodName() {
        return "create_customer";
    }

    @Override
    public List<String> getParams() {
        return Arrays.asList("token", "username");
    }

    @Override
    public ResponseToProcess execute(ProcessedAPIRequest request, SDKServiceProvider serviceProvider) {
        String token = request.getParams().get("token");
        String username = request.getParams().get("username");

        LoggerService logger = serviceProvider.getLoggerService(CreateCustomer.class);
        logger.debug(request.getBody());
        Map<String, String> errMap = new HashMap<String, String>();

        /*JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(request.getBody());
            JSONObject jsonObject = (JSONObject) obj;

            // Fetch the values passed in by the user from the body of JSON
            token = (String) jsonObject.get("token");
            username = (String) jsonObject.get("username");

        } catch (ParseException pe) {
            logger.error(pe.getMessage(), pe);
            return Util.badRequestResponse(errMap, pe.getMessage());
        }
        */
        if (Util.hasNulls(token, username)){
            return Util.badRequestResponse(errMap);
        }

        Map<String, Customer> feedback = new HashMap<String, Customer>();
        Map<String, Object> customerParams = new HashMap<String, Object>();
        customerParams.put("card", token);
        customerParams.put("email", username);

        Customer customer;
        try{
        customer = Customer.create(customerParams);
        feedback.put("customer", customer);
        } catch (CardException ce) {
            return Util.internalErrorResponse("card exception", ce, errMap); // http 500 - internal server error

        } catch (APIConnectionException ace) {
            return Util.internalErrorResponse("api exception", ace, errMap); // http 500 - internal server error

        } catch (InvalidRequestException ire) {
            return Util.internalErrorResponse("invalid request", ire, errMap); // http 500 - internal server error
        } catch (AuthenticationException ae) {
            return Util.internalErrorResponse("authentication exception", ae, errMap); // http 500 - internal server error
        } catch (StripeException se) {
            return Util.internalErrorResponse("stripe exception", se, errMap); // http 500 - internal server error
        } catch (Exception e) {
            return Util.internalErrorResponse("something else", e, errMap); // http 500 - internal server error
        }

        /*DataService ds = serviceProvider.getDataService();
        List<SMUpdate> update = new ArrayList<SMUpdate>();

        update.add(new SMSet("title", new SMString(token)));

        SMObject result;
        try {
            // Remember that the primary key in this car schema is `car_id`
            result = ds.updateObject("pnservice", new SMString(username), update);
            feedback.put("updated object", result);

        } catch (InvalidSchemaException ise) {
            return Util.internalErrorResponse("invalid_schema", ise, errMap); // http 500 - internal server error
        } catch (DatastoreException dse) {
            return Util.internalErrorResponse("datastore_exception", dse, errMap); // http 500 - internal server error
        }
        */
        return new ResponseToProcess(HttpURLConnection.HTTP_OK, feedback);
    }

}
