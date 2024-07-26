package com.easy.archiecture.xml;


/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/25 14:44
 */
public class EasyArchiectureLogging {
    /**
     * This is the method which I would like to execute
     * before a selected method execution.
     */
    public void beforeAdvice() {
        System.out.println("Going to setup EasyArchiectureAOP profile.");
    }

    /**
     * This is the method which I would like to execute
     * after a selected method execution.
     */
    public void afterAdvice() {
        System.out.println("EasyArchiectureAOP profile has been setup.");
    }

    /**
     * This is the method which I would like to execute
     * when any method returns.
     */
    public void afterReturningAdvice(Object retVal) {
        System.out.println("Returning:" + retVal.toString());
    }

    /**
     * This is the method which I would like to execute
     * if there is an exception raised.
     */
    public void AfterThrowingAdvice(Exception exception) {
        System.out.println("There has been an exception: " + exception.toString());
    }
}
