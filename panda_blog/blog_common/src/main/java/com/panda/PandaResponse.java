package com.panda;

import java.util.HashMap;

public class PandaResponse extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    public PandaResponse message(String message) {
        this.put("message", message);
        return this;
    }

    public PandaResponse data(Object data) {
        this.put("data", data);
        return this;
    }

    @Override
    public PandaResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
