package subscription.dataVO;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

public class HotelVO extends RepresentationModel<HotelVO> implements Serializable {

    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private int quartosDisponiveis;

    public HotelVO() {
    }

    public HotelVO(Long id, String nome, String endereco, String telefone, int quartosDisponiveis) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.quartosDisponiveis = quartosDisponiveis;
    }

    // Getters e setters

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelVO hotelVO = (HotelVO) o;
        return quartosDisponiveis == hotelVO.quartosDisponiveis && Objects.equals(id, hotelVO.id) && Objects.equals(nome, hotelVO.nome) && Objects.equals(endereco, hotelVO.endereco) && Objects.equals(telefone, hotelVO.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, endereco, telefone, quartosDisponiveis);
    }

    @Override
    public String toString() {
        return "HotelVO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", quartosDisponiveis=" + quartosDisponiveis +
                '}';
    }
}
