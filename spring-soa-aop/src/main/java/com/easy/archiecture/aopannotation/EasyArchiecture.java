package com.easy.archiecture.aopannotation;


import javax.inject.Named;

@Named("easyArchiecture")
public class EasyArchiecture {


    public void print() {
        System.out.println("EasyArchiecture print running success");
    }

    @EasyMonitor
    public void calculate() {
        System.out.println("EasyArchiecture calculate running success");
    }
}
