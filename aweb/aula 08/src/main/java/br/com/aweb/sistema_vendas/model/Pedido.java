package br.com.aweb.sistema_vendas.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Controle de concorrência otimista
    @Version
    private Long version;

    // Relacionamento com Cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    // Status do pedido
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private StatusPedido status = StatusPedido.ATIVO; // valor default

    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime dataHora = LocalDateTime.now();

    @Column(nullable = false)
    @Builder.Default
    private Double valorTotal = 0.0;

    // Relacionamento com itens do pedido
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<ItemPedido> itens = new ArrayList<>();

    /**
     * Construtor personalizado que exige Cliente
     */
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.status = StatusPedido.ATIVO;
        this.dataHora = LocalDateTime.now();
        this.valorTotal = 0.0;
        this.itens = new ArrayList<>();
    }

    /**
     * Método utilitário para adicionar item ao pedido
     */
    public void adicionarItem(ItemPedido item) {
        item.setPedido(this);
        this.itens.add(item);
        calcularValorTotal();
    }

    /**
     * Método para adicionar item com produto e quantidade
     */
    public void adicionarItem(Produto produto, Integer quantidade) {
        if (quantidade > produto.getEstoque()) {
            throw new IllegalArgumentException("Quantidade solicitada maior que estoque disponível");
        }
        
        ItemPedido item = ItemPedido.builder()
                .produto(produto)
                .quantidade(quantidade)
                .precoUnitario(produto.getPreco())
                .build();
        
        adicionarItem(item);
    }

    public void calcularValorTotal() {
        this.valorTotal = itens.stream()
                .mapToDouble(ItemPedido::getSubtotal)
                .sum();
    }

    /**
     * Método para validar se o pedido tem pelo menos um item
     */
    public boolean temItensValidos() {
        return itens != null && !itens.isEmpty() && 
               itens.stream().allMatch(item -> item.getQuantidade() > 0);
    }
}