package com.company;

/**
 * Created by Gheorghe on 12/30/2016.
 */
public class Predicate implements Unifiable {

    private Unifiable[] terms;

    public boolean isNegative() {
        return isNegative;
    }

    public void setNegative(boolean negative) {
        isNegative = negative;
    }

    boolean isNegative;

    public Predicate(Constant predicateName, boolean isNegative, Unifiable... args){
        this.terms = new Unifiable[args.length + 1];
        terms[0] = predicateName;
        this.isNegative = isNegative;
        System.arraycopy(args, 0, terms, 1, args.length);
    }


    public Predicate(Constant predicateName, Unifiable... args){
        this.terms = new Unifiable[args.length + 1];
        terms[0] = predicateName;
        System.arraycopy(args, 0, terms, 1, args.length);
    }

    public Predicate(Unifiable[] terms, boolean isNegative){
        this.terms = terms;
        this.isNegative = isNegative;
    }

    @Override
    public String toString(){

        String s = null;

        for(Unifiable u : terms){
            if(s == null){
                s = u.toString();
            } else {
                s += " " + u;
            }
        }

        if(s == null){
            return "null";
        } else {
            return "( " + s + " )\n";
        }
    }

    public int length(){
        return terms.length;
    }

    public Unifiable getTerm(int index){
        return this.terms[index];
    }
    @Override
    public SubstitutionSet unify(Unifiable p, SubstitutionSet s)
    {
        if (p instanceof Predicate)
        {
            Predicate s2 = (Predicate) p;
            if (this.length() != s2.length())
                return null;
            SubstitutionSet sNew = new SubstitutionSet(s);
            for (int i = 0; i < this.length(); i++)
            {
                sNew = this.getTerm(i).unify(s2.getTerm(i),
                        sNew);
                if(sNew == null)
                    return null;
            }
            return sNew;
        }
        if(p instanceof Variable)
            return p.unify(this, s);
        return null;
    }

    private Predicate(Unifiable... args)
    {
        terms = args;
    }

    @Override
    public Predicate replaceVariables(SubstitutionSet s)
    {
        Unifiable[] newTerms = new
                Unifiable[terms.length];
        for(int i = 0; i < length(); i++)
            newTerms[i] =
                    (Unifiable)terms[i].replaceVariables(s);
        return new Predicate(newTerms, this.isNegative);
    }

    public boolean isEqual(Predicate p) {
        if (terms.length != p.terms.length) {
            return false;
        }

        for (int i = 0; i < terms.length; ++i) {
            if (!terms[i].equals(p.terms[i])) {
                return false;
            }
        }

        return true;
    }

}
