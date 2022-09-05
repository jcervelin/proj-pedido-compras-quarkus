package br.com.bb.compra.restclient.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProdutoImportListDto {

    private List<ProdutoImportDto> products;

}
