package com.example.earthquake;

import java.util.ArrayList;

public class Model {
    public Double t1;
    public String t2;
    public String t3;
    public String t4;
    public String t5;

    Model(Double text1,String text2,String text3,String text4,String text5){
        this.t1= text1;
        this.t2=text2;
        this.t3=text3;
        this.t4=text4;
        this.t5=text5;

    }

    public Double getT1() {
        return t1;
    }

    public String getT2() {
        return t2;
    }

    public String getT3() {
        return t3;
    }

    public String getT4() {
        return t4;
    }

    public String getT5() {
        return t5;
    }
}
