package com.lemeshko.jpa;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LARGE_PROJ")
public class LargeProject extends Project {

	@Column(name = "BUDGET")
	private BigDecimal budget;

	public BigDecimal getBudget() {
		return budget;
	}

	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}

	@Override
	public String toString() {
		return "LargeProject [budget=" + budget + ", getBudget()=" + getBudget() + ", getId()=" + getId()
				+ ", getName()=" + getName() + "]";
	}

}
