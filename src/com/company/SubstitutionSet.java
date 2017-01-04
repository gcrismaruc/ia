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

    //Changed to work in our case
    public Unifiable getBinding(Variable v){
        for (Variable binding : bindings.keySet()) {
            if (binding.equals(v)) {
                return bindings.get(binding);
            }
        }

        return null;
    }

    //Changed to work in our case
    public boolean isBound(Variable v){
        for (Variable binding : bindings.keySet()) {
            if (binding.equals(v)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString(){
        return "Bindings:[" + this.bindings + "];\n";
    }

}
