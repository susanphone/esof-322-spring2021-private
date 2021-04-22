package edu.montana.esof322.homework.homework3;

import org.apache.commons.lang.IncompleteArgumentException;
import org.junit.jupiter.api.Test;

import java.lang.annotation.IncompleteAnnotationException;

import static org.junit.jupiter.api.Assertions.*;

public class JLispTest {

    /*====================================================================
    // Homework 3
    //
    // Included in this directory is a simple lisp implementation.  This
    // lisp implementation supports basic math, akin to what our reverse
    // polish notation calculator did.
    //
    // The intention with this lisp is to support simple, binary addition
    // in the form:
    //
    //  (+ 1 2)
    //
    //  or
    //
    //  (+ 1 (+ 2 3))
    //
    //
    // The `+` operator can take two and only two arguments, and must be
    // enclosed in parenthesis to be valid.
    //
    // This implementation is buggy.
    TODO: Your assignment is to create four (4) tests showing *different* bugs within the simple language.
    //
    //====================================================================*/

    @Test
    // This is a sample test to help you get started
    public void exampleTest() {
        assertEquals(2, 3);
        fail("test didn't pass");
        assertEquals("Foo", "Bar");
    }


    @Test
    public void nullEvalThrowsNullPointerExceptionTest() {
        JLisp jlisp = new JLisp();
        try {
            jlisp.eval(null);
            fail("Didn't work");
        } catch (IllegalArgumentException illegalArgumentException){
            //pass
        }
    }



    @Test
    public void incompleteParenthesesThrowsExceptionTest() {
        JLisp jLisp = new JLisp();
        try{
            jLisp.eval("(+ 1 1");
            fail("Fail");
        } catch (IncompleteAnnotationException noClosingParenthesesException) {
            //pass
        }
    }



    @Test
    public void noParenthesesThrowsExceptionTest() {
        JLisp jl = new JLisp();
        try{
            jl.eval("+ 1 2");
            fail("fail");
        } catch (IllegalArgumentException illegalArgumentException) {
            //pass
        }
    }


    @Test
    public void usePlusSignThrowsWrongExceptionTest() {
        JLisp jlisp = new JLisp();
        try {
            jlisp.eval("(+)");
            fail("Didn't work");
            } catch (IncompleteArgumentException illegalArgumentException){
                //pass
            }
    }

    @Test
    public void multipleAddersThrowsWrongExceptionTest() {
        JLisp jlisp = new JLisp();
        try {
            jlisp.eval("(+ + 1)");
            fail("Didn't work");
        } catch (IncompleteArgumentException illegalArgumentException){
            //pass
        }
    }
}
