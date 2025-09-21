package controllers;

import models.Conta;

public class ListaConta {
  private NoConta cabeca;

  public ListaConta() {
    this.cabeca = null;
  }

  public void inserirNovaConta(Conta conta) {
    NoConta novoNo = new NoConta(conta);

    if (cabeca == null) {
      cabeca = novoNo;
    } else {
      NoConta atual = cabeca;
      while (atual.proximo != null) {
        atual = atual.proximo;
      }
      atual.proximo = novoNo;
    }
    System.out.println("Conta cadastrada com sucesso!");
  }

  public void listar() {
    if (cabeca == null) {
      System.out.println("Não existe nenhuma conta cadastrada.");
      return;
    }

    System.out.println("\n Lista de Contas Ativas: \n");
    NoConta atual = cabeca;
    boolean encontrouAtiva = false;

    while (atual != null) {
      if (atual.conta.estaAtiva()) {
        System.out.println(atual.conta);
        encontrouAtiva = true;
      }
      atual = atual.proximo;
    }
    if (!encontrouAtiva) {
      System.out.println("Nenhuma conta ativa encontrada.");
    }
  }
  public Conta buscarConta(int numero) {
    NoConta atual = cabeca;

    while (atual != null) {
      if (atual.conta.getNumeroConta() == numero) {
        return atual.conta;
      }
      atual = atual.proximo;
    }
    return null;
  }
  public boolean encerrarConta(int numero) {
    Conta contaParaEncerrar = buscarConta(numero);

    if (contaParaEncerrar != null) {
      if (contaParaEncerrar.getSaldo() == 0) {
        contaParaEncerrar.setAtiva(false);
        System.out.println("Conta encerrada com sucesso!");
        return true;
      } else {
        System.out.println("Não é possível encerrar a conta. O saldo deve ser zero.");
        return false;
      }
    } else {
      System.out.println("Conta não encontrada.");
      return false;
    }
  }
   public void removerConta(int numeroConta) {
    No atual = inicio;
    No anterior = null; 

    while (atual != null && atual.getInfo().getNumero() != numeroConta) {
        anterior = atual;
        atual = atual.getProx();
    }
    if (atual == null) {
        System.out.println("Conta não encontrada.");
        return;
    }
    if (atual.getInfo().getSaldo() != 0) {
        System.out.println("A remoção só é permitida para contas com saldo zero.");
        return;
    }
    if (anterior == null) { 
        inicio = atual.getProx();
    } else { 
        anterior.setProx(atual.getProx());
    }

    System.out.println("Conta " + numeroConta + " removida com sucesso!");
}

}
