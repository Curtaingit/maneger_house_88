package com.example.manager_house_88.bos;

 class MyBostype implements IBostype {
    private final String bt;

    public MyBostype(String bt) {
        this.bt=bt;
    }
    public String  toString(){
        return this.bt;
    }
}
