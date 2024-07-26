package com.easy.archiecture.xml;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/25 14:44
 */
public class EasyArchiectureAOP {

    private String aopName;
    private String aopDesc;

    public void setAopName(String aopName) {
        this.aopName = aopName;
    }

    public String getAopName() {
        System.out.println("aopName : " + aopName);
        return aopName;
    }

    public void setAopDesc(String aopDesc) {
        this.aopDesc = aopDesc;
    }

    public String getAopDesc() {
        System.out.println("aopDesc : " + aopDesc);
        return aopDesc;
    }

    public void printThrowException() {
        System.out.println("Exception raised");
        throw new IllegalArgumentException();
    }
}
