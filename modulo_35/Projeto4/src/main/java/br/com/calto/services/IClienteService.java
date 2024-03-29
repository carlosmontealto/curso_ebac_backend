package br.com.calto.services;

import br.com.calto.domain.Cliente;
import br.com.calto.exceptions.DAOException;
import br.com.calto.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {
  //	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
  //
  Cliente buscarPorCPF(Long cpf) throws DAOException;
  //
  //	void excluir(Long cpf);
  //
  //	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
