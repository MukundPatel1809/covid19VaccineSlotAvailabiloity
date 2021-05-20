package com.mukund.covid19.vaccine.slot.availability;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class SlotAvailabilityService {
    public void runDisplay() {

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        try {
            engine.eval(new FileReader("/index.js"));
            Invocable invocable = (Invocable) engine;
            Object result;
            result = invocable.invokeFunction("execute", null);
            System.out.println(result);
            System.out.println(result.getClass());
        } catch (NoSuchMethodException | ScriptException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
