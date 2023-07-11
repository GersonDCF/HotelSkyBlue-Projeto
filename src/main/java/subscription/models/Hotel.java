package subscription.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "hotel")
public class Hotel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String endereco;

    private String telefone;

    @Column(name = "quartos_disponiveis")
    private int quartosDisponiveis;

    @OneToMany(mappedBy = "hotel")
    private List<Reserva> reservas;

    public Hotel() {
    }

    public Hotel(String nome, String endereco, String telefone, int quartosDisponiveis) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.quartosDisponiveis = quartosDisponiveis;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getQuartosDisponiveis() {
        return quartosDisponiveis;
    }

    public void setQuartosDisponiveis(int quartosDisponiveis) {
        this.quartosDisponiveis = quartosDisponiveis;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return quartosDisponiveis == hotel.quartosDisponiveis && Objects.equals(id, hotel.id) && Objects.equals(nome, hotel.nome) && Objects.equals(endereco, hotel.endereco) && Objects.equals(telefone, hotel.telefone) && Objects.equals(reservas, hotel.reservas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, endereco, telefone, quartosDisponiveis, reservas);
    }

    // Getters e setters

    // Equals e hashCode

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
