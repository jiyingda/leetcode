package com.jiyingda.test;

/**
 * @author jiyingda.
 * @date 2020/4/9.
 */
public class Test1 {

    private final int a;

    private final  int b;

    public static class Builder {
        private int a = 0;
        private int b = 0;


        public Builder(){

        }
        public Builder a(int val){
            a=val;
            return this;
        }

        public Builder b(int val){
            b = val;
            return this;
        }

        public Test1 build(){
            return new Test1(this);
        }
    }

    private Test1(Builder builder){
        a = builder.a;
        b = builder.b;
    }

    public static void main(String[] args){
        Test1 aaa = new Builder().a(1).build();
    }
}
