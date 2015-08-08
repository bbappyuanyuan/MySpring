package service.impl;

import service.Walk;

/**
 * Created by Zifeng Yuan.
 */
public class WalkImpl implements Walk {

    private String name;

    @Override
    public void go() {
        System.out.println("[" + name + "] Walk -> go()");
    }
}
