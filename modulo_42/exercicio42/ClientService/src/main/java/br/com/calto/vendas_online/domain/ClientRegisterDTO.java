package br.com.calto.vendas_online.domain;

public record ClientRegisterDTO(
  String name,
  Long cpf,
  Long phone,
  String email
) {}
