package br.com.bruno.reserva.service.util;

import java.util.List;

public interface ServiceGenerico <E,K> {
    public E salvar(E entity) ;
    public void remover(K key);
    public E buscar(K key);
    public List<E> listarTodos();
	public E atualizar(E entity, K key);

}
