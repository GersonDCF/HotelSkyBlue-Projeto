package subscription.dataVO;

import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

public class PrestacaoVO extends RepresentationModel<PrestacaoVO>  implements Serializable {

    private Long id;
    private Long idReserva;
    private String formaPagamento;
    private Double valor;
    private Boolean status;
    // Construtores, getters e setters

    public PrestacaoVO() {
    }

    public PrestacaoVO(Long id, Long idReserva, String formaPagamento, Double valor, Boolean status) {
        this.id = id;
        this.idReserva = idReserva;
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

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
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
        PrestacaoVO that = (PrestacaoVO) o;
        return Objects.equals(id, that.id) && Objects.equals(idReserva, that.idReserva) && Objects.equals(formaPagamento, that.formaPagamento) && Objects.equals(valor, that.valor) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idReserva, formaPagamento, valor, status);
    }

    @Override
    public String toString() {
        return "PrestacaoVO{" +
                "id=" + id +
                ", idReserva=" + idReserva +
                ", formaPagamento='" + formaPagamento + '\'' +
                ", valor=" + valor +
                ", status=" + status +
                '}';
    }
}
