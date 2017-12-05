/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Main;

import br.com.sorveteria.Controller.ClienteController;
import br.com.sorveteria.Controller.FuncionarioController;
import br.com.sorveteria.Controller.ProdutoController;
import br.com.sorveteria.Controller.VendaController;
import br.com.sorveteria.Model.Builder.VendaBuilder;
import br.com.sorveteria.Model.ClienteModel;
import br.com.sorveteria.Model.DAO.FuncionarioDAO;
import br.com.sorveteria.Model.DAO.ProdutoDAO;
import br.com.sorveteria.Model.Entidades.Cliente;
import br.com.sorveteria.Model.Entidades.Endereco;
import br.com.sorveteria.Model.Entidades.Funcionario;
import br.com.sorveteria.Model.Entidades.ItensVenda;
import br.com.sorveteria.Model.Entidades.Produto;
import br.com.sorveteria.Model.Entidades.Venda;
import br.com.sorveteria.Model.FuncionarioModel;
import br.com.sorveteria.Model.ItensVendaModel;
import br.com.sorveteria.Model.ProdutoModel;
import br.com.sorveteria.Model.Util.Criptografia;
import br.com.sorveteria.Model.VendaModel;
import java.util.Date;

/**
 *
 * @author Aluno
 */
public class TesteProdutoDAO {
    
   public static void main(String[] args){/*
ProdutoController c = new ProdutoController();
Produto p = new Produto(0, "gelados", "Sorvete", 100, 10, 20);
Produto p1 = new Produto(0, "gelados", "Sorvete", 100, 10, 20);
Produto p2 = new Produto(0, "gelados", "Sorvete", 100, 10, 20);
Produto p3 = new Produto(0, "gelados", "Sorvete", 100, 10, 20);

c.setProduto(p);


c.inserir();
/*
Endereco end  = new Endereco(0, "eg", 0, "grs", "ef", "erg");
Cliente cli = new Cliente(400, 0, "carlos", "123.234.567-88", "098914354", "dkpaz03@gmail.com", end);
Funcionario fun = new Funcionario(null, "frg", "rg", "rg", 0, "rg", "f", "rg", "tg", end);   
  
FuncionarioController fu = new FuncionarioController();
fu.setFuncionario(fun);
fu.inserir();

ClienteController cl = new ClienteController();
cl.setCliente(cli);
cl.inserir();*
Endereco end  = new Endereco(1, "duque de caxia", 76, "sao joao", "planalto");
Cliente cli = new Cliente(400, 1, "carlos gffg", "123.234.567-88", "098914354", "dkpaz03@gmail.com", end);
ClienteController cl = new ClienteController();
cl.setCliente(cli);
cl.alterar();
   }
///dao.consultarPorNome("yiuh9bhio");*/
     /*  VendaModel mo = new VendaModel();
       ItensVendaModel ve = new ItensVendaModel();
       FuncionarioController co = new FuncionarioController();
       ProdutoController pro = new ProdutoController();
       Endereco en = new Endereco(0, "sf", 0, "dgg", "dfgg");
       Funcionario f = new Funcionario("da", "da", 0, "ds", "fg", "hjg", "rgty", en);
       co.setFuncionario(f);
       co.inserir();
       Venda v = new Venda(0, new Date(), 200, f);
       mo.salvar(v);
       Produto p;
       p = new Produto(0, "diu", "cil", 0, 0, 0);
       pro.setProduto(p);
       pro.inserir();
       ItensVenda it = new ItensVenda(0, 200, 10, v, p);
       ve.salvar(it);*/
VendaController v = new VendaController();
VendaBuilder vb = new VendaBuilder();
FuncionarioDAO fu = new FuncionarioDAO();
ProdutoDAO pro = new ProdutoDAO();
Venda ven = null;
ItensVenda itv = new ItensVenda("cafe", 0, 3.59, 2, pro.recuperar(1910));
vb.funcionario(fu.recuperar(1));
vb.horario(new Date());
vb.itemvenda(itv);
vb.comsuFinal("cicero s calado");
v.setVendaBuilder(vb);
v.inserir();
   }
}


