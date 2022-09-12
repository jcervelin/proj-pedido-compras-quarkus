package br.com.bb.compra.model.entity;

import br.com.bb.compra.model.Cliente;
import br.com.bb.compra.model.enums.PerfilEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "tb_cliente")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


@SqlResultSetMapping(
        name="CpfByEmailResult",
        columns={@ColumnResult(name="cpf")})
@NamedNativeQuery(
        name = "CpfByEmail",
        query = "SELECT cpf FROM tb_cliente WHERE email = :email",
        resultSetMapping = "CpfByEmailResult")


@SqlResultSetMapping(
        name="mapClienteResult",
        classes={
                @ConstructorResult(
                        targetClass= Cliente.class,
                        columns={
                                @ColumnResult(name="id", type=Long.class),
                                @ColumnResult(name="nome", type=String.class),
                                @ColumnResult(name="cpf", type=String.class),
                                @ColumnResult(name="email", type=String.class)})})

@NamedNativeQuery(name = "mapCliente",
        query = "SELECT * FROM tb_cliente WHERE nome like concat('%',:nome,'%')",
        resultSetMapping = "mapClienteResult")

public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;

    @JsonIgnoreProperties(allowGetters = true)
    private String senha;

    @Enumerated(EnumType.STRING)
    private PerfilEnum perfil;

    @OneToMany(
            mappedBy = "cliente",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<EnderecoEntity> enderecos;
}