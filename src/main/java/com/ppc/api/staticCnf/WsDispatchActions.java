package com.ppc.api.staticCnf;

import org.springframework.stereotype.Service;


/**
 * Actions for WS message received, allow for filter and apply the corresponding actions
 */
@Service
public class WsDispatchActions {
    public enum Visitor {
        CREATE_VISITOR
    }

    public enum Pathing {
        CREATE_PATHING
    }

    public String getActionFromClient(String wsPayload) {

    }
}
