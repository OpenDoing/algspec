package axiom;

import entity.axiom.Equation;
import entity.axiom.Term;

import java.util.List;

/**
 * comment here
 *
 * @author Duyining
 * @date 2019/10/30
 */
public class TestAxiom {

    public static void main(String[] args) {
        String nf = "new\nnew;insert()";
        String ax = "nil.isEmpty = true,if nil=false;\n" +
                "a;insert();delete() = a;\n" +
                "a;reverse();reverse() = a;\n" +
                "a;reverse.getMin() = a.getMin();";
        List<Term> terms= NfAxiom.getNoramlForms(nf);
        List<Equation> axioms = NfAxiom.getAxiomEqu(ax);
        for (Term term:terms){
            System.out.println(term.getTerm());
        }
        NfAxiom.run(axioms, terms);
    }
}
