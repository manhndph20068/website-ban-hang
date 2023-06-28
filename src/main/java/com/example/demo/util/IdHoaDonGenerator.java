package com.example.demo.util;

import java.util.concurrent.atomic.AtomicInteger;

public class IdHoaDonGenerator {
    private  static AtomicInteger idHoaDon = new AtomicInteger(0);

    public static int getNextIdHoaDon(){
        return idHoaDon.incrementAndGet();
    }
}
