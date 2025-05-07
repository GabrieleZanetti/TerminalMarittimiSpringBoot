package com.terminal.terminal.Services;

import com.terminal.terminal.Entities.Fornitore;
import com.terminal.terminal.Repositories.FornitoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class FornitoreService 
{
	@Autowired //skippo il costruttore e inietto la repository
	private FornitoreRepository repo;

	public List<Fornitore> getAll() 
	{
        return repo.findAll();
    }

    public Optional<Fornitore> getById(Long id) 
	{
        return repo.findById(id);
    }

    public Fornitore create(Fornitore fornitore) 
	{
        return repo.save(fornitore);
    }

    public void delete(Long id) 
	{
        repo.deleteById(id);
    }

    public Optional<Fornitore> findByNome(String nome) 
	{
        return repo.findByNome(nome);
    }

	public Optional<Fornitore> findByGiorniGratis(int giorni_gratis) 
	{
		return repo.findByGiorniGratis(giorni_gratis);
	}

	public Optional<Fornitore> findByTariffa(BigDecimal tariffa) 
	{
		return repo.findByTariffa(tariffa);
	}

	public Optional<Fornitore> findByTariffaMinoreDi(BigDecimal tariffa) 
	{
		return repo.findByTariffaMinoreDi(tariffa);
	}

	public Optional<Fornitore> findByTariffaMaggioreDi(BigDecimal tariffa) 
	{
		return repo.findByTariffaMaggioreDi(tariffa);
	}
}
