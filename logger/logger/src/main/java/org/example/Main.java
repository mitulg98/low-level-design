package org.example;

import org.example.model.*;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.fatal("This is an application failure", "com.mykong.api");
        logger.error("fatalia", "com.cujo.util");
    }
}