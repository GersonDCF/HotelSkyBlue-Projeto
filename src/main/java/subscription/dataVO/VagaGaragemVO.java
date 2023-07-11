package subscription.dataVO;


import java.io.Serializable;
import java.util.Objects;

//extends RepresentationModel<VagaGaragemVO>
public class VagaGaragemVO implements Serializable {

    private Long id;
    private Long idReserva;
    private boolean disponibilidade;

    public VagaGaragemVO() {
    }

    public VagaGaragemVO(Long id, Long idReserva, boolean disponibilidade) {
        this.id = id;
        this.idReserva = idReserva;
        this.disponibilidade = disponibilidade;
    }

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

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VagaGaragemVO that = (VagaGaragemVO) o;
        return disponibilidade == that.disponibilidade && Objects.equals(id, that.id) && Objects.equals(idReserva, that.idReserva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idReserva, disponibilidade);
    }

    @Override
    public String toString() {
        return "VagaGaragemVO{" +
                "id=" + id +
                ", idReserva=" + idReserva +
                ", disponibilidade=" + disponibilidade +
                '}';
    }
}
