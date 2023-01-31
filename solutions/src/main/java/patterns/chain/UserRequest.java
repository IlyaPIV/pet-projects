package patterns.chain;

import java.util.Objects;

public class UserRequest {

    private final RequestType requestType;

    private final String requestDescription;

    private boolean solved = false;

    public UserRequest(final RequestType requestType, final String description) {
        this.requestType = Objects.requireNonNull(requestType);
        this.requestDescription = Objects.requireNonNull(description);
    }


    public RequestType getRequestType() {
        return requestType;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    public boolean isSolved() {
        return solved;
    }

    public void markAsSolved() {
        this.solved = true;
    }

    @Override
    public String toString() {
        return "{" +
                "type=" + requestType +
                ", description='" + requestDescription + '\'' +
                '}';
    }
}
