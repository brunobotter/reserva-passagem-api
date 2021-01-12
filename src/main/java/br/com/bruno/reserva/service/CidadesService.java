package br.com.bruno.reserva.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bruno.reserva.dto.request.NovaCidadeDto;
import br.com.bruno.reserva.exception.NegocioException;
import br.com.bruno.reserva.model.Cidades;
import br.com.bruno.reserva.repository.CidadesRepository;
import br.com.bruno.reserva.service.util.ServiceGenericoImpl;

@Service
public class CidadesService extends ServiceGenericoImpl<Cidades, Long>{

	@Autowired
	private CidadesRepository cidadesRepository;
	
	
	public CidadesService(CidadesRepository cidadesRepository) {
		super(cidadesRepository);
		this.cidadesRepository = cidadesRepository;
	}
	
	@Override
	public Cidades buscar(Long key) {
		return super.buscar(key);
	}
	
	
	@Override
	public Cidades salvar(Cidades entity) {
		verificaCidade(entity.getNomeCidade());
		return super.salvar(entity);
	}
	
	@Override
	public Cidades atualizar(Cidades entity, Long key) {
		Cidades cidade = buscar(key);
		cidade.setId(key);
		verificaCidade(entity.getNomeCidade());
		return super.atualizar(cidade, key);
	}

	@Override
	public void remover(Long key) {
		Cidades cidade = buscar(key);
		super.remover(cidade.getId());
	}
	
	public Cidades converteNovaCidadeDTOEmEntidade(NovaCidadeDto cidadeDto) {
		return new Cidades(cidadeDto);
	}
	
	public boolean verificaCidade(String nome) {
		Optional<Cidades> cidade = cidadesRepository.nomeCidade(nome);
		if(cidade.isEmpty()) {
			return true;
		}else {
			throw new NegocioException("Cidade ja cadastrada!");
		}
	}
}
