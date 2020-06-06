package com.doing.parse.domain;

import java.util.ArrayList;
import java.util.List;

public class Axiom {
	private String name;
    private List<Equation> equations=new ArrayList<Equation>();
	
	public String getName() {
		return name;
	}

	public List<Equation> getEquations() {
		return equations;
	}

	public void setEquations(List<Equation> equations) {
		this.equations = equations;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
