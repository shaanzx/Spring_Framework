package org.example.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Girl1 implements Agreement{
    public Girl1(){
        System.out.println("Girl Constructor");
    }

    @Override
    public void chat() {
        System.out.println("girl 1 chatting..");
    }
}
