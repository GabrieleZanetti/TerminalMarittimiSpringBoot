package com.terminal.terminal.Repositories;

import com.terminal.terminal.Entities.Staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Long>
{	
	@Query("SELECT s FROM Staff s WHERE s.user.id = :id")
	Optional<Staff> findByUserId(@Param("id") Long id);
}
