package com.traductor.traductor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class DebugTraductorTest {
    int numero;
    String expected;

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters(){
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{1111,"waranka patsak chunka shuk "});
        objects.add(new Object[]{400,"chusku patsak "});
        objects.add(new Object[]{1000,"waranka "});
        objects.add(new Object[]{1008,"waranka pusak "});
        objects.add(new Object[]{4099,"chusku waranka iskun chunka iskun "});
        objects.add(new Object[]{1104,"waranka patsak chusku "});
        return objects;
    }

    public DebugTraductorTest(int numero, String expected) {
        this.numero = numero;
        this.expected = expected;
    }

    @Test
    public void given_parameters_when_translate_then_correct(){
        Traductor t = new Traductor();
        assertEquals(expected,t.traducir(numero));
    }
}
