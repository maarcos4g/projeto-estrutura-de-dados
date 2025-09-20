package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Conta {
  private int numeroConta;
  String titular;
  String cpf;
  private double saldo;
  String tipoConta;
  LocalDate dataAbertura;
  private boolean ativa;

  public Conta(int numeroConta,
      String titular,
      String cpf,
      String tipoConta) {
    this.numeroConta = numeroConta;
    this.titular = titular;
    this.cpf = cpf;
    this.saldo = 0.0;
    this.tipoConta = tipoConta;
    this.dataAbertura = LocalDate.now();
    this.ativa = true;
  }
  public int getNumeroConta() {
    return this.numeroConta;
  }
  public double getSaldo() {
    return this.saldo;
  }
  public void setAtiva(boolean estado) {
    this.ativa = estado;
  }

  public void depositar(double valor) {
    if (valor > 0) {
      this.saldo += valor;
      System.out.println("Depósito de R$ " + String.format("%.2f", valor) + " realizado com sucesso!");
    } else {
      System.out.println("Valor do depósito inválido!");
    }
  }

  public boolean saque(double valor) {
    if (valor <= 0) {
      System.out.println("Valor inválido. Não é possivel realizar o saque.");
      return false;
    }

    if (this.saldo < valor) {
      System.out.println("Saldo insuficiente. Não é possível realizaer o saque.");
      return false;
    } else {
      this.saldo -= valor;
      System.out.println("Saque de R$ " + String.format("%.2f", valor) + "realizado com sucesso!");
      return true;
    }
  }

   public boolean estaAtiva() {
      return this.ativa;
    }

  @Override
  public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return "Número da Conta: " + numeroConta + "\n" +
        "Titular: " + titular + "\n" +
        "CPF: " + cpf + "\n" +
        "Tipo: " + tipoConta + "\n" +
        "Saldo: R$ " + String.format("%.2f", saldo) + "\n" +
        "Data de Abertura: " + dataAbertura.format(formatter) + "\n" +
        "Status: " + (ativa ? "Ativa" : "Inativa") + "\n";
  }
}
