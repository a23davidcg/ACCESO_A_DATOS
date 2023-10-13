package org.example;

import java.io.FileReader;
import java.io.IOException;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import static java.lang.System.*;

public class Main {

    public class RunJSScript {
        public static void main(String[] args) {
            if (args.length != 1) {
                err.println("uso: java RunJSScript scriptEnJS");
                return;
            }
            ScriptEngineManager manager = new ScriptEngineManager(); // Inicio el API de Scripting
            ScriptEngine engine = manager.getEngineByName("nashorn");

            try {
                engine.eval(new FileReader("D:\\MaquinasVirtuais\\AD\\unidad1.3JASON\\Codigo_Que_Nos_Permite_Leer_JSON\\Poeta_JS.JS")); // Sí, los flujos con importantes
            } catch (ScriptException se) {
                err.println(se.getMessage());
            } catch (IOException ioe) {
                err.println(ioe.getMessage());
            }
        }
    }
}
