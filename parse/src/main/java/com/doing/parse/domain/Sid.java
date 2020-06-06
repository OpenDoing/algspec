package com.doing.parse.domain;

import java.util.ArrayList;
import java.util.List;

public class Sid {
	private String name;
    private List<Axiom> axioms=new ArrayList<Axiom>();
	public List<Axiom> getAxioms() {
		return axioms;
	}

	public void setAxioms(List<Axiom> axioms) {
		this.axioms = axioms;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
