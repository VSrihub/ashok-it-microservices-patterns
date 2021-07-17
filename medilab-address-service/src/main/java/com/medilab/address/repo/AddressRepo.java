package com.medilab.address.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medilab.address.domain.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

	@Query("from Address d where d.postalCode=:postalCode")
	public Address findByPostalCode(@Param("postalCode") String postalCode);
}
