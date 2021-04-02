package edu.montana.esof322.homework.homework2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Homework2 {

    int invocationCount = 0;
    StringBuilder output = new StringBuilder();

    interface IDoAThing{}

    static class ThingDoer implements IDoAThing{
        void doIt() {output.append("Did it!\n");
        }
    }
    private static class ThingFactory {
        private ThingFactory(){}
        public static IDoAThing create() {
            ThingDoer thing = new ThingDoer();
            return new ThingDoer();
        }
    }
    class ThingProxy implements IDoAThing {
        IDoAThing proxyObject;
        public ThingProxy(IDoAThing proxyObj) {
            proxyObject = proxyObj;
        }
    }

    //=======================================================================
    // Your boss wants to know how many times a method on a given class is
    // being invoked.  Your job is to take the the code above and refactor it
    // using some patterns to capture the needed information.
    //=======================================================================
    @Test
    void theAssignment() {
        // Step 1: extract an interface for ThingDoer, IDoAThing and
        //         replace the variable below with
        public void extractAnInterface() {
            IDoAThing thing = new ThingDoer();
        }
        // Step 2: replace this new expression with a factory to produce
        //         IDoAThings
        public void createAFactory() {
            IDoAThing thing = ThingFactory.create();
        }
        ThingDoer thingDoer = new ThingDoer();

        // Step 3: use the factory to insert a proxy object that wraps
        //         a ThingDoer and increments the invocationCount

        public void makeAThingProxy() {
            IDoAThing thing = new ThingProxy(new ThingDoer());
        }
        assertFalse(thingDoer instanceof ThingDoer);

        // do the thing a few times...
        thingDoer.doIt();
        thingDoer.doIt();
        thingDoer.doIt();

        // the proxy should have incremented the invocation count
        assertEquals(3, invocationCount);

        // output should still be the same since the proxy passed through
        // to the underlying ThingDoer
        assertEquals(output.toString(),
                "Did it!\nDid it!\nDid it!\n");
    }



}
