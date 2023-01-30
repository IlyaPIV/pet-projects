package patterns.chain;

public interface SupportRequestHandler {

    boolean isItHisRequest(UserRequest req);

    int getPriority();

    default void handle(UserRequest req) {
        req.markAsSolved();
        System.out.printf("%s solved request \"%s\"\n", name(), req);
    };

    String name();
}
