package com.lemeshko.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SMALL_PROJ")
public class SmallProject extends Project {

	@Override
	public String toString() {
		return "SmallProject [getId()=" + getId() + ", getName()=" + getName() + "]";
	}

}
