package com.easy.architecture.javaconfig;

import com.easy.architecture.javaconfig.staregy.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Company {

    private PersonServiceImpl person;

    @Autowired
    private Map<String, Person> personMap;

    //    public Company(PersonServiceImpl person) {
//        this.person = person;
//    }
    @Autowired
    @Lazy
    public void setPerson(PersonServiceImpl person) {
        this.person = person;
    }


    public void getPersonName() {
        person.printName();
    }

    public void allWrite() {
        for (Map.Entry<String, Person> entry : personMap.entrySet()) {
            entry.getValue().write();
        }
    }

}
