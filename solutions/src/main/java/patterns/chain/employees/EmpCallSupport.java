package patterns.chain.employees;


import patterns.chain.RequestType;
import patterns.chain.SupportRequestHandler;
import patterns.chain.UserRequest;

public class EmpCallSupport implements SupportRequestHandler {
    @Override
    public boolean isItHisRequest(UserRequest req) {
        return req.getRequestType() == RequestType.HARDWARE_PROBLEM;
    }

    @Override
    public int getPriority() {
        return 1;
    }


    @Override
    public String name() {
        return "Technical support specialist";
    }
}
