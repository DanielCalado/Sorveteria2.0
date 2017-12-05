/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Controller;

import br.com.sorveteria.Model.Builder.VendaBuilder;
import br.com.sorveteria.Model.Entidades.Venda;
import br.com.sorveteria.Model.VendaModel;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Aluno
 */
@ManagedBean(name = "vendaController")
@SessionScoped
public class VendaController {

        private VendaModel model = null;
        private Venda venda;
        private VendaBuilder vendaBuilder;
        private List<Venda> ListadeVendas;

        public VendaController(){
          venda = new Venda();
          vendaBuilder = new VendaBuilder();
          model = new VendaModel();
          ListadeVendas = new ArrayList<>();
        }

    
        public void inserir() {
            model.salvar(vendaBuilder.controi());
            limpar();
        }

        public void alterar() {
            model.alterar(vendaBuilder.controi());
            limpar();
        }

        public void excluir() {
            model.excluir(venda);
            limpar();
        }

        public void consultar() {
            model.consultar(venda.getId());
        }

        public void buscarTodos() {
            ListadeVendas = model.consultarTodos();
        }

        public Venda getVenda() {
            return venda;
        }

        public void setVenda(Venda venda) {
            this.venda = venda;
        }

        public List<Venda> getListadeVendas() {
            return ListadeVendas;
        }

        public void setListadeVendas(List<Venda> listadeVendas) {
            this.ListadeVendas = ListadeVendas;
        }

    public void setVendaBuilder(VendaBuilder vendaBuilder) {
        this.vendaBuilder = vendaBuilder;
    }

    public VendaBuilder getVendaBuilder() {
        return vendaBuilder;
    }

        public void limpar() {
            venda = new Venda();
            buscarTodos();
        }
    
}
