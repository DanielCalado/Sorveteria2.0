/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Model.Builder;

import br.com.sorveteria.Model.Entidades.Funcionario;
import br.com.sorveteria.Model.Entidades.ItensVenda;
import br.com.sorveteria.Model.Entidades.Venda;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Aluno
 */
public class VendaBuilder {

    private String comsuFinal = "Comsumidor Final 01";
    private Date horario;
    private double valor;
    private Funcionario funcionario;
    private List<ItensVenda> itensVenda = new ArrayList<>();

    public void comsuFinal(String comsuFinal) {
        this.comsuFinal = comsuFinal;
    }

    public void horario(Date horario) {
        this.horario = horario;
    }

    public void itemvenda(ItensVenda item) {
        itensVenda.add(item);
        valor += item.getQuantidade() * item.getValor();

        
    }

    public void funcionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Venda controi() {
        return new Venda(0, comsuFinal, horario, valor, funcionario, itensVenda);
    }

}
