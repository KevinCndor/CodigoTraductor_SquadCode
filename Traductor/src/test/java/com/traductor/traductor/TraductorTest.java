package com.traductor.traductor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class TraductorTest {

    int numero;
    String expected;

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters(){
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{25,"ishkay chunka pichka "});
        objects.add(new Object[]{9999,"iskun waranka iskun patsak iskun chunka iskun "});
        objects.add(new Object[]{15,"chunka pichka "});
        objects.add(new Object[]{187,"patsak pusak chunka kanchis "});
        return objects;
    }

    public TraductorTest(int numero, String expected) {
        this.numero = numero;
        this.expected = expected;
    }

    @Test
    public void given_parameters_when_add_then_addition(){
        Traductor t = new Traductor();
        assertEquals(expected,t.traducir(numero));
    }

}