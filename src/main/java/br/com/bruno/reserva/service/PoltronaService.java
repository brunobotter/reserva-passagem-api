package br.com.bruno.reserva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bruno.reserva.model.Poltrona;
import br.com.bruno.reserva.repository.PoltronaRepository;
import br.com.bruno.reserva.service.util.ServiceGenericoImpl;

@Service
public class PoltronaService extends ServiceGenericoImpl<Poltrona, Long>{

	@SuppressWarnings("unused")
	@Autowired
	private PoltronaRepository poltronaRepository;
	
	public PoltronaService(PoltronaRepository poltronaRepository) {
		super(poltronaRepository);
		this.poltronaRepository = poltronaRepository;
	}
	
	@Override
	public Poltrona buscar(Long key) {
		return super.buscar(key);
	}
	
	@Override
	public Poltrona salvar(Poltrona entity) {
		return super.salvar(entity);
	}
	

	@Override
	public Poltrona atualizar(Poltrona entity, Long key) {
		Poltrona poltrona = buscar(key);
		poltrona.setOcupado(entity.isOcupado());
		return super.atualizar(poltrona, key);
	}
	

	
	
}
