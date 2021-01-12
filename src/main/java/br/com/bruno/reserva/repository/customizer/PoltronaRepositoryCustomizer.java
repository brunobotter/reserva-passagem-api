package br.com.bruno.reserva.repository.customizer;

import br.com.bruno.reserva.model.Poltrona;

public interface PoltronaRepositoryCustomizer {

	public Poltrona findPoltronas(int numeroPoltrona, Long onibusId);
	public Poltrona findPoltronasCancelada(int numeroPoltrona, Long onibusId);
}
