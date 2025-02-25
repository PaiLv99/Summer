package myserver.core.httpenum;

public enum HttpResponseState {
    RESPONSE_INITIALIZED,
    RESPONSE_GENERATED,
    RESPONSE_SENDING,
    RESPONSE_COMPLETED,
    RESPONSE_FAILED
}
