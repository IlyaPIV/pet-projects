package patterns.chain;

import patterns.chain.employees.EmpCallSupport;
import patterns.chain.employees.EmpSoftwareDeveloper;
import patterns.chain.employees.EmpTeamLead;
import patterns.chain.employees.EmpTechLead;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TechSupport {

    private List<SupportRequestHandler> handlers;

    public TechSupport() {
        buildChain();
    }

    private void buildChain(){
        this.handlers = Arrays.asList(new EmpSoftwareDeveloper(),
                                        new EmpCallSupport(),
                                        new EmpTechLead(),
                                        new EmpTeamLead());
    }

    public void solveProblem(UserRequest request) {
        handlers
                .stream()
                .sorted(Comparator.comparing(SupportRequestHandler::getPriority))
                .filter(handler -> handler.isItHisRequest(request))
                .findFirst()
                .ifPresent(handler -> handler.handle(request));
    }
}
