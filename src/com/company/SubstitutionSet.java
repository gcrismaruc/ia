package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gheorghe on 12/30/2016.
 */
public class SubstitutionSet {

    private Map<Variable, Unifiable> bindings = new HashMap<>();

    public SubstitutionSet(){}

    public SubstitutionSet(SubstitutionSet s){
        this.bindings = new HashMap<>(s.bindings);
    }

    public void clear(){
        this.bindings.clear();
    }

    public void add(Variable v, Unifiable exp){
        this.bindings.put(v, exp);
    }

    public Unifiable getBinding(Variable v){
        if(this.bindings.containsKey(v))
            return this.bindings.get(v);
        else
            return null;
    }

    public boolean isBound(Variable v){
        return this.bindings.get(v) != null;
    }

    @Override
    public String toString(){
        return "Bindings:[" + this.bindings + "];\n";
    }

}
