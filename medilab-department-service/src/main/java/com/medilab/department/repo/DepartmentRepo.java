package com.medilab.department.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medilab.department.domain.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {

	@Query("from Department d where d.name=:deptName")
	public Department findByName(@Param("deptName") String name);
}
