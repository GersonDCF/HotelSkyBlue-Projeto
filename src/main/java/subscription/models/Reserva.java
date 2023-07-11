package subscription.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_hospede")
    private Hospede hospede;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @OneToOne(mappedBy = "reserva")
    private Prestacao prestacao;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "reserva_vaga_garagem",
            joinColumns = @JoinColumn(name = "reserva_id"),
            inverseJoinColumns = @JoinColumn(name = "vaga_garagem_id"))
    private Set<VagaGaragem> vagasGaragem = new HashSet<>();

    @Column(name = "data_checkin")
    private Date dataCheckin;

    @Column(name = "data_checkout")
    private Date dataCheckout;

    @Column(name = "tipo_quarto")
    private String tipoQuarto;

    public Reserva() {
    }
    public Reserva(Hospede hospede, Date dataCheckin, Date dataCheckout, String tipoQuarto) {
        this.hospede = hospede;
        this.dataCheckin = dataCheckin;
        this.dataCheckout = dataCheckout;
        this.tipoQuarto = tipoQuarto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Date getDataCheckin() {
        return dataCheckin;
    }

    public void setDataCheckin(Date dataCheckin) {
        this.dataCheckin = dataCheckin;
    }

    public Date getDataCheckout() {
        return dataCheckout;
    }

    public void setDataCheckout(Date dataCheckout) {
        this.dataCheckout = dataCheckout;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Prestacao getPrestacao() {
        return prestacao;
    }

    public void setPrestacao(Prestacao prestacao) {
        this.prestacao = prestacao;
    }

    public Set<VagaGaragem> getVagasGaragem() {
        return vagasGaragem;
    }

    public void setVagasGaragem(Set<VagaGaragem> vagasGaragem) {
        this.vagasGaragem = vagasGaragem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(id, reserva.id) && Objects.equals(hospede, reserva.hospede) && Objects.equals(hotel, reserva.hotel) && Objects.equals(prestacao, reserva.prestacao) && Objects.equals(vagasGaragem, reserva.vagasGaragem) && Objects.equals(dataCheckin, reserva.dataCheckin) && Objects.equals(dataCheckout, reserva.dataCheckout) && Objects.equals(tipoQuarto, reserva.tipoQuarto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hospede, hotel, prestacao, vagasGaragem, dataCheckin, dataCheckout, tipoQuarto);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", hospede=" + hospede +
                ", hotel=" + hotel +
                ", prestacao=" + prestacao +
                ", vagasGaragem=" + vagasGaragem +
                ", dataCheckin=" + dataCheckin +
                ", dataCheckout=" + dataCheckout +
                ", tipoQuarto='" + tipoQuarto + '\'' +
                '}';
    }
}
