package br.com.bruno.reserva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.bruno.reserva.dto.request.NovaPassagemDto;
import br.com.bruno.reserva.exception.NegocioException;
import br.com.bruno.reserva.model.Onibus;
import br.com.bruno.reserva.model.Passagem;
import br.com.bruno.reserva.model.Poltrona;
import br.com.bruno.reserva.model.Usuario;
import br.com.bruno.reserva.repository.PassagemRepository;
import br.com.bruno.reserva.repository.PoltronaRepository;
import br.com.bruno.reserva.service.util.ServiceGenericoImpl;

@Service
public class PassagemService extends ServiceGenericoImpl<Passagem, Long> {

	public PassagemService(JpaRepository<Passagem, Long> jpaRepository, PassagemRepository passagemRepository,
			OnibusService onibusService, PoltronaRepository poltronaRepository, UsuarioService usuarioService) {
		super(jpaRepository);
		this.passagemRepository = passagemRepository;
		this.onibusService = onibusService;
		this.poltronaRepository = poltronaRepository;
		this.usuarioService = usuarioService;
	}

	@SuppressWarnings("unused")
	@Autowired
	private PassagemRepository passagemRepository;

	@Autowired
	private OnibusService onibusService;

	@Autowired
	private PoltronaRepository poltronaRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public Passagem buscar(Long key) {
		return super.buscar(key);
	}

	@Override
	public Passagem salvar(Passagem entity) {
		Onibus onibus = onibusService.buscar(entity.getOnibus().getOnibusId());
		int poltrona = entity.getPoltrona();
		Poltrona poltronas = poltronaRepository.findPoltronas(poltrona, onibus.getOnibusId());
		if (!poltronas.isOcupado()) {
			poltronas.setOcupado(true);
			poltronas.setOnibus(onibus);
			poltronaRepository.save(poltronas);
			entity.setOnibus(onibus);
			return super.salvar(entity);
		} else {
			throw new NegocioException("Poltrona ja reservada!");
		}

	}

	public Passagem atualizaPassagem(Passagem entity) {
		return super.salvar(entity);
	}

	public Passagem converteNovaPassagemDtoEmEntidade(NovaPassagemDto dto) {
		Usuario usuario = usuarioService.buscar(dto.getUsuarioId());
		Onibus onibus = onibusService.buscar(dto.getOnibusId());
		
		return new Passagem(onibus, usuario, dto.getNumeroPoltrona());
	}


}
