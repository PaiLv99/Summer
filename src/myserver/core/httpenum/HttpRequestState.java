package myserver.core.httpenum;

public enum HttpRequestState {
    REQUEST_STARTED,
    REQUEST_SENT,
    WAITING_FOR_RESPONSE,
    RESPONSE_RECEIVED,
    REQUEST_COMPLETED,
    REQUEST_FAILED
}
