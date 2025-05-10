package com.terminal.terminal.Services;

import com.terminal.terminal.Entities.Staff;
import com.terminal.terminal.Repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService 
{
	@Autowired //skippo il costruttore e inietto la repository
	private StaffRepository repo;

	public List<Staff> getAll() 
	{
        return repo.findAll();
    }

    public Optional<Staff> getById(Long id) 
	{
        return repo.findById(id);
    }

    public Staff create(Staff staff) 
	{
        return repo.save(staff);
    }

    public void delete(Long id) 
	{
        repo.deleteById(id);
    }

	public Optional<Staff> findByUserId(Long id) 
	{
		return repo.findByUserId(id);
	}
}
