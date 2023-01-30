package patterns.chain.employees;

import patterns.chain.RequestType;
import patterns.chain.SupportRequestHandler;
import patterns.chain.UserRequest;

public class EmpTechLead implements SupportRequestHandler {
    @Override
    public boolean isItHisRequest(UserRequest req) {
        return req.getRequestType() == RequestType.NEW_FEATURE_REQUEST;
    }

    @Override
    public int getPriority() {
        return 4;
    }

    @Override
    public String name() {
        return "Company's Tech Lead";
    }
}
