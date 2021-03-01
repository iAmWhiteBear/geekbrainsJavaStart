package HW8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * слать всё в строку,
 * её парсить.
 * разбивать 
* */
public class Controller {
    private double first;
    private double second;

    public Controller(){}

    public double getFirst() {
        return first;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public double getSecond() {
        return second;
    }

    public void setSecond(double second) {
        this.second = second;
    }


    public String doOperation(String polinominal){
        // 4. * Попробовать применить ScriptEngine для вычисления сложный математических выражений

        ScriptEngineManager scriptManager = new ScriptEngineManager();
        ScriptEngine engine = scriptManager.getEngineByName("Nashorn");
        try {
            return engine.eval(polinominal).toString();
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        return "calculation error";
    }
}
