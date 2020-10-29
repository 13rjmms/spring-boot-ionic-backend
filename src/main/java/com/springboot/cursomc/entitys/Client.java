package com.springboot.cursomc.entitys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springboot.cursomc.entitys.enums.ClientType;

@Entity
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private String cpfOrCnpj;
	private Integer clientType;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "client")
	private List<Address> addresses = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "phones")
	private Set<String> phones = new HashSet<>();
	
	@JsonBackReference
	@OneToMany(mappedBy = "client")
	private List<Request> orders = new ArrayList<>();

	public Client() {
	}

	public Client(Integer id, String name, String email, String cpfOrCnpj, ClientType clientType) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpfOrCnpj = cpfOrCnpj;
		this.clientType = clientType.getCod();
	}
	
	
	
	public List<Request> getOrders() {
		return orders;
	}

	public void setOrders(List<Request> orders) {
		this.orders = orders;
	}

	public void setClientType(Integer clientType) {
		this.clientType = clientType;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getCpfOrCnpj() {
		return cpfOrCnpj;
	}

	public ClientType getClientType() {
		return ClientType.toEnum(clientType);
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCpfOrCnpj(String cpfOrCnpj) {
		this.cpfOrCnpj = cpfOrCnpj;
	}

	public void setClientType(ClientType clientType) {
		this.clientType = clientType.getCod();
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", email=" + email + ", cpfOrCnpj=" + cpfOrCnpj + ", clientType="
				+ clientType + ", addresses=" + addresses + ", phones=" + phones + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
