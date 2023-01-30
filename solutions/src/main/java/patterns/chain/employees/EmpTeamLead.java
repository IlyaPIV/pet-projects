package patterns.chain.employees;

import patterns.chain.RequestType;
import patterns.chain.SupportRequestHandler;
import patterns.chain.UserRequest;

public class EmpTeamLead implements SupportRequestHandler {
    @Override
    public boolean isItHisRequest(UserRequest req) {
        return req.getRequestType() == RequestType.UNKNOWN_BUG_PROBLEM;
    }

    @Override
    public int getPriority() {
        return 3;
    }

    @Override
    public String name() {
        return "Developers Team Lead";
    }
}
