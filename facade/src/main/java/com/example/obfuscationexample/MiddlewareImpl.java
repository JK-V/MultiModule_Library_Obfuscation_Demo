package com.example.obfuscationexample;

import com.example.middleware.MiddlewareInterface;

/**
 * Created by e077146 on 2/1/2018.
 */

public class MiddlewareImpl implements MiddlewareInterface {
    @Override
    public String getMiddlewareData() {
        return "middlware";
    }
}
