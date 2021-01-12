package br.com.bruno.reserva.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.bruno.reserva.dto.request.NovoOnibusDto;
import br.com.bruno.reserva.exception.NegocioException;
import br.com.bruno.reserva.model.Cidades;
import br.com.bruno.reserva.model.Onibus;
import br.com.bruno.reserva.model.Poltrona;
import br.com.bruno.reserva.repository.OnibusRepository;
import br.com.bruno.reserva.repository.PoltronaRepository;
import br.com.bruno.reserva.service.util.ServiceGenericoImpl;

@Service
public class OnibusService extends ServiceGenericoImpl<Onibus, Long> {

	public OnibusService(JpaRepository<Onibus, Long> jpaRepository, OnibusRepository onibusRepository,
			PoltronaRepository poltronaRepository, CidadesService cidadesService) {
		super(jpaRepository);
		this.onibusRepository = onibusRepository;
		this.poltronaRepository = poltronaRepository;
		this.cidadesService = cidadesService;
	}

	@Autowired
	private OnibusRepository onibusRepository;

	@Autowired
	private PoltronaRepository poltronaRepository;

	@Autowired
	private CidadesService cidadesService;

	@Override
	public Onibus buscar(Long key) {
		return super.buscar(key);
	}

	@Override
	public Onibus salvar(Onibus entity) {
		Onibus onibusSalvo = onibusRepository.save(entity);
		List<Poltrona> listaPoltrona = new ArrayList<Poltrona>();
		int numeroPoltrona = 1;
		for (int i = 0; i < entity.getQuantidadePoltronas(); i++) {
			Poltrona poltrona = new Poltrona(numeroPoltrona, false, onibusSalvo);
			poltronaRepository.save(poltrona);
			listaPoltrona.add(poltrona);
			numeroPoltrona++;
		}
		onibusSalvo.setListaPoltrona(listaPoltrona);
		return super.salvar(onibusSalvo);
	}

	public Onibus atualizar(Onibus entity, Long key) {
		Onibus onibus = buscar(key);
		onibus.setChegada(entity.getChegada());
		onibus.setPartida(entity.getPartida());
		onibus.setOrigem(entity.getOrigem());
		onibus.setDestino(entity.getDestino());
		onibus.setListaPoltrona(entity.getListaPoltrona());
		onibus.setQuantidadePoltronas(entity.getQuantidadePoltronas());
		return super.salvar(onibus);
	}

	public Onibus converteNovoOnibusDTOEmEntidade(NovoOnibusDto dto) {
		Cidades destino = cidadesService.buscar(dto.getDestinoId());
		Cidades origem = cidadesService.buscar(dto.getOrigemId());
		if(destino.getId() == origem.getId()) {
			throw new NegocioException("A cidade de origem não pode ser igual e de destino");
		}
		return new Onibus(dto.getQuantidadePoltronas(), origem, destino, dto.getPartida(), dto.getChegada());
	}

	@Override
	public void remover(Long key) {
		Onibus onibus = buscar(key);
		super.remover(onibus.getOnibusId());
	}

}
