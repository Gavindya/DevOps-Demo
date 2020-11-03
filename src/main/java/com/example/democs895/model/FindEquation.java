package com.example.democs895.model;

import org.springframework.stereotype.Service;

@Service
public class FindEquation {

    public String additionFunc(int x_val, int y_val) {
            return String.valueOf(x_val + y_val);
    }

    public String subtractFunc(int x_val, int y_val) {
        return String.valueOf(x_val - y_val);
    }

    public String multiplicationFunc(int x_val, int y_val) {
        return String.valueOf(x_val * y_val);
    }
}
