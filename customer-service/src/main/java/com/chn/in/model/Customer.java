package com.chn.in.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	private int custId;
	
	@Column
	private String custName;
	
	@Column
	private String custAdd;

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAdd() {
		return custAdd;
	}

	public void setCustAdd(String custAdd) {
		this.custAdd = custAdd;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custAdd=" + custAdd + "]";
	}

	public Customer(int custId, String custName, String custAdd) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custAdd = custAdd;
	}


	public Customer() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(custAdd, Integer.valueOf(custId), custName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(custAdd, other.custAdd) && custId == other.custId
				&& Objects.equals(custName, other.custName);
	}
	
	
	
	
	
	

}
