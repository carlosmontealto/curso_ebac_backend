package br.com.calto.services;

import br.com.calto.domain.Cliente;
import br.com.calto.exception.TipoChaveNaoEncontradaException;

public interface IClienteService {
  Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;

  Cliente buscarPorCPF(Long cpf);

  void excluir(Long cpf);

  void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;
}
