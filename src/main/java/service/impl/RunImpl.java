package service.impl;

import service.Run;
import service.Walk;

/**
 * Created by Zifeng Yuan.
 */
public class RunImpl implements Run {

    Walk walk;

    @Override
    public void go() {
        walk.go();
        System.out.println("Run -> go()");
    }
}
