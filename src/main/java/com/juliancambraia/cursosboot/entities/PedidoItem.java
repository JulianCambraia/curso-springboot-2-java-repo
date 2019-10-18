package com.juliancambraia.cursosboot.entities;

import com.juliancambraia.cursosboot.entities.pk.PedidoItemPk;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class PedidoItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private PedidoItemPk id;

    private Integer quantidade;

    private Double preco;

    public PedidoItem() {
    }

    public PedidoItem(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.id.setPedido(pedido);
        this.id.setProduto(produto);
    }

    public Pedido getPedido() {
        return id.getPedido();
    }

    public void setPedido(Pedido pedido) {
        id.setPedido(pedido);
    }

    public Produto getProduto() {
        return id.getProduto();
    }

    public void setProduto(Produto produto) {
        id.setProduto(produto);
    }
    
    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoItem that = (PedidoItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
