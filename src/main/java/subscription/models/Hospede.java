package subscription.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "hospede_table")
public class Hospede implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String telefone;

    @Column(name = "data_nascimento", nullable = false)
    private String dataNascimento;

    @OneToMany(mappedBy = "hospede", cascade = CascadeType.ALL)
    private List<Reserva> reservas = new ArrayList<>();

    public Hospede() {
    }

    public Hospede(String nome, String cpf, String telefone, String dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    @JsonIgnore
    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
        reserva.setHospede(reserva.getHospede());
    }

    public void removeReserva(Reserva reserva) {
        reservas.remove(reserva);
        reserva.setHospede(reserva.getHospede());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospede hospede = (Hospede) o;
        return Objects.equals(id, hospede.id) && Objects.equals(nome, hospede.nome) && Objects.equals(cpf, hospede.cpf) && Objects.equals(telefone, hospede.telefone) && Objects.equals(dataNascimento, hospede.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, telefone, dataNascimento);
    }

    @Override
    public String toString() {
        return "Hospede{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                '}';
    }
}
