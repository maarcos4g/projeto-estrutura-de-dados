package controllers;

import models.Conta;

public class NoConta {
  Conta conta;
  NoConta proximo;

  public NoConta(Conta conta) {
    this.conta = conta;
    this.proximo = null;
  }
}
