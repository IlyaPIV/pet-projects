package patterns.chain;

public class AppSupport {

    public static void main(String[] args) {
        TechSupport support = new TechSupport();
        support.solveProblem(new UserRequest(RequestType.SOFTWARE_PROBLEM, "can't find big red button in UI"));
        support.solveProblem(new UserRequest(RequestType.HARDWARE_PROBLEM, "my PC is too slow"));
        support.solveProblem(new UserRequest(RequestType.UNKNOWN_BUG_PROBLEM, "Big red button doesn't work!!!"));
        support.solveProblem(new UserRequest(RequestType.NEW_FEATURE_REQUEST, "Add also a Small Blue button, please!"));
    }
}
