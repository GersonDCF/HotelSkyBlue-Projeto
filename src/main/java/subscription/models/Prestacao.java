package subscription.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "prestacao")
public class Prestacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;


    @Column(name = "forma_pagamento")
    private String formaPagamento;

    private Double valor;

    private Boolean status;

    // Construtores, getters e setters

    public Prestacao() {
    }

    public Prestacao(Reserva reserva, String formaPagamento, Double valor, Boolean status) {
        this.reserva = reserva;
        this.formaPagamento = formaPagamento;
        this.valor = valor;
        this.status = status;
    }

    // Outros métodos, se necessário

    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prestacao prestacao = (Prestacao) o;
        return Objects.equals(id, prestacao.id) && Objects.equals(reserva, prestacao.reserva) && Objects.equals(formaPagamento, prestacao.formaPagamento) && Objects.equals(valor, prestacao.valor) && Objects.equals(status, prestacao.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reserva, formaPagamento, valor, status);
    }

    @Override
    public String toString() {
        return "Prestacao{" +
                "id=" + id +
                ", reserva=" + reserva +
                ", formaPagamento='" + formaPagamento + '\'' +
                ", valor=" + valor +
                ", status=" + status +
                '}';
    }
}
