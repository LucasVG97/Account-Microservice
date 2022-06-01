package com.letscode.account.utils;

import java.util.Random;

public class NumeroConta {
    public static Integer numeroConta(){
        Random numeroRandom = new Random();
        int numeroConta = numeroRandom.nextInt((9999 - 1000) + 1) + 1000;
        return numeroConta;

    }
}
