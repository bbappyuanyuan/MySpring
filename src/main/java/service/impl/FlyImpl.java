package service.impl;

import service.Fly;
import service.Run;
import service.Walk;

/**
 * Created by Zifeng Yuan.
 */
public class FlyImpl implements Fly {

    Walk walk;
    Run run;

    @Override
    public void go() {
        walk.go();
        run.go();
        System.out.println("Fly -> go()");
    }
}
