package subscription.dataVO;

import org.springframework.hateoas.RepresentationModel;
import subscription.models.Hotel;

import java.io.Serializable;
import java.util.Objects;

public class HospedeVO  extends RepresentationModel<HospedeVO> implements Serializable {

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String dataNascimento;

    public HospedeVO() {
    }

    public HospedeVO(Long id, String nome, String cpf, String telefone, String dataNascimento) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HospedeVO hospedeVO = (HospedeVO) o;
        return Objects.equals(id, hospedeVO.id) && Objects.equals(nome, hospedeVO.nome) && Objects.equals(cpf, hospedeVO.cpf) && Objects.equals(telefone, hospedeVO.telefone) && Objects.equals(dataNascimento, hospedeVO.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, telefone, dataNascimento);
    }

    @Override
    public String toString() {
        return "HospedeVO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                '}';
    }
}
