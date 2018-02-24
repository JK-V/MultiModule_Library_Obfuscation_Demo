package com.example.obfuscationexample;

import com.example.middleware.MiddlewareInterface;

/**
 *
 */

public class MiddlewareImpl implements MiddlewareInterface {
    @Override
    public String getMiddlewareData() {
        return "middlware";
    }
}
