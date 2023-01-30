package patterns.chain.employees;

import patterns.chain.RequestType;
import patterns.chain.SupportRequestHandler;
import patterns.chain.UserRequest;

public class EmpSoftwareDeveloper implements SupportRequestHandler {
    @Override
    public boolean isItHisRequest(UserRequest req) {
        return req.getRequestType() == RequestType.SOFTWARE_PROBLEM;
    }

    @Override
    public int getPriority() {
        return 2;
    }


    @Override
    public String name() {
        return "Junior software developer";
    }
}
