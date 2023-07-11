package subscription.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity
@Table(name = "vaga_garagem")
public class VagaGaragem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "vagasGaragem")
    private Set<Reserva> reservas = new HashSet<>();

    @Column(nullable = false)
    private boolean disponibilidade;

    @Column
    private Long idReserva;

    public VagaGaragem() {
    }

    public VagaGaragem(Long id, Set<Reserva> reservas, boolean disponibilidade) {
        this.id = id;
        this.reservas = reservas;
        this.disponibilidade = disponibilidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Set<Reserva> reservas) {
        this.reservas = reservas;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VagaGaragem that = (VagaGaragem) o;
        return disponibilidade == that.disponibilidade && Objects.equals(id, that.id) && Objects.equals(reservas, that.reservas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reservas, disponibilidade);
    }

    @Override
    public String toString() {
        return "VagaGaragem{" +
                "id=" + id +
                ", reservas=" + reservas +
                ", disponibilidade=" + disponibilidade +
                '}';
    }
}