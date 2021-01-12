package br.com.bruno.reserva.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.bruno.reserva.dto.request.NovoCancelamentoDto;
import br.com.bruno.reserva.exception.NegocioException;
import br.com.bruno.reserva.model.Cancelamento;
import br.com.bruno.reserva.model.Onibus;
import br.com.bruno.reserva.model.Passagem;
import br.com.bruno.reserva.model.Poltrona;
import br.com.bruno.reserva.repository.CancelamentoRepository;
import br.com.bruno.reserva.repository.PoltronaRepository;
import br.com.bruno.reserva.service.util.ServiceGenericoImpl;

@Service
public class CancelamentoService extends ServiceGenericoImpl<Cancelamento, Long> {

	public CancelamentoService(JpaRepository<Cancelamento, Long> jpaRepository,
			CancelamentoRepository cancelamentoRepository, OnibusService onibusService,
			PoltronaRepository poltronaRepository, PassagemService passagemService) {
		super(jpaRepository);
		this.cancelamentoRepository = cancelamentoRepository;
		this.onibusService = onibusService;
		this.poltronaRepository = poltronaRepository;
		this.passagemService = passagemService;
	}

	@SuppressWarnings("unused")
	@Autowired
	private CancelamentoRepository cancelamentoRepository;

	@Autowired
	private OnibusService onibusService;

	@Autowired
	private PoltronaRepository poltronaRepository;

	@Autowired
	private PassagemService passagemService;

	@Autowired
	private UsuarioService UsuarioService;

	@Override
	public Cancelamento buscar(Long key) {
		return super.buscar(key);
	}

	@Override
	public Cancelamento salvar(Cancelamento entity) {
		Passagem passagem = passagemService.buscar(entity.getPassagem().getPassagemId());
		UsuarioService.validaClienteCancelamento(passagem);
		if (passagem.isCancelado() == false) {
			Onibus onibus = onibusService.buscar(passagem.getOnibus().getOnibusId());
			passagem.setCancelado(true);
			passagemService.atualizaPassagem(passagem);
			Poltrona poltronas = poltronaRepository.findPoltronas(passagem.getPoltrona(), onibus.getOnibusId());
			poltronas.setOcupado(true);
			poltronaRepository.save(poltronas);
			return super.salvar(entity);
		} else {
			throw new NegocioException("Passagem ja cancelada");
		}

	}

	public Cancelamento converterCancelamentoDtoEmEntidade(NovoCancelamentoDto dto) {
		LocalDateTime data = LocalDateTime.now();
		Passagem passagem = passagemService.buscar(dto.getPassagemId());
		return new Cancelamento(passagem, data, dto.getMotivoCancelamento());
	}

}
