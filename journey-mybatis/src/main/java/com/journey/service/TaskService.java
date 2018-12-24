package com.journey.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liuqingwen
 * @date 2018/12/24.
 */
public class TaskService {

    @Transactional()
    public void get() {

        save();
        update();



//        TaskService,save();

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save() {

    }

    @Transactional
    public void update() {

    }

}
