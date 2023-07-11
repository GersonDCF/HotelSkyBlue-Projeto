package subscription.dataVO;

import org.springframework.hateoas.RepresentationModel;
import subscription.models.Hospede;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ReservaVO extends RepresentationModel<ReservaVO> implements Serializable {

    private Long id;
    private Hospede hospede;

    private Date dataCheckin;

    private Date dataCheckout;

    private String tipoQuarto;

    public ReservaVO() {
    }

    public ReservaVO(Hospede hospede, Date dataCheckin, Date dataCheckout, String tipoQuarto) {
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
}
