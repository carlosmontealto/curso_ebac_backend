package br.com.calto;

import javax.swing.JOptionPane;

import br.com.calto.dao.ClienteMapDAO;
import br.com.calto.dao.IClienteDAO;
import br.com.calto.domain.Cliente;

public class App {

  private static IClienteDAO iClienteDAO;

  public static void main(String[] args) {
    iClienteDAO = new ClienteMapDAO();

    String opcao = JOptionPane.showInputDialog(null,
        "Digite 1 para cadastro, 2 para consultar, 3 para alteração , 4 para exclusão ou 5 para sair.", "CRUD",
        JOptionPane.INFORMATION_MESSAGE);

    while (!isOpcaoValida(opcao)) {
      if ("".equals(opcao)) {
        sair();
      }
      opcao = JOptionPane.showInputDialog(null,
          "Opção inválida digite 1 para cadastro, 2 para consultar, 3 para alteração , 4 para exclusão ou 5 para sair.",
          "Erro",
          JOptionPane.INFORMATION_MESSAGE);
    }
    while (isOpcaoValida(opcao)) {
      if (isOpcaoSair(opcao)) {
        sair();
      } else if (isOpcaoCadastrar(opcao)) {
        String dados = JOptionPane.showInputDialog(null,
            "Digite os dados separados por virgula, conforme exemplo: Nome, Cpf, Telefone, Endereço, Numero, Cidade, Estado",
            "Cadastrar", JOptionPane.INFORMATION_MESSAGE);
        cadastrar(dados);
      } else if (isOpcaoConsultar(opcao)) {
        String cpf = JOptionPane.showInputDialog(null,
            "Digite o cpf que deseja consulta: ",
            "Consultar", JOptionPane.INFORMATION_MESSAGE);
        consulta(cpf);
      } else if (isOpcaoAlterar(opcao)) {
        String cpf = JOptionPane.showInputDialog(null,
            "Digite o cpf que deseja alterar: ",
            "Alterar", JOptionPane.INFORMATION_MESSAGE);
        alteração(cpf);
      } else if (isOpcaoExclusao(opcao)) {
        String cpf = JOptionPane.showInputDialog(null,
            "Digite o cpf que deseja excluir: ",
            "Excluir", JOptionPane.INFORMATION_MESSAGE);
        exclusao(cpf);
      }

      opcao = JOptionPane.showInputDialog(null,
          "Digite 1 para cadastro, 2 para consultar, 3 para alteração , 4 para exclusão ou 5 para sair.",
          "CRUD",
          JOptionPane.INFORMATION_MESSAGE);
    }
  }

  private static void cadastrar(String dados) {
    String[] dadosSeparados = new String[7];
    dadosSeparados = dados.split(", ");
    Boolean isCadastrado = false;
    Boolean isCadastroErro = false;

    if (dadosSeparados.length == 7) {
      Cliente cliente = new Cliente(dadosSeparados[0],
          Long.valueOf(dadosSeparados[1]), Long.valueOf(dadosSeparados[2]),
          dadosSeparados[3],
          Integer.valueOf(dadosSeparados[4]),
          dadosSeparados[5], dadosSeparados[6]);
      isCadastrado = iClienteDAO.cadastrar(cliente);
    } else {
      isCadastroErro = true;
    }

    if (isCadastrado && !isCadastroErro) {
      JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso.", "Sucesso",
          JOptionPane.INFORMATION_MESSAGE);
    } else if (!isCadastrado && !isCadastroErro) {
      JOptionPane.showMessageDialog(null, "Cliente já se encontra cadastrado.", "Sucesso",
          JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "Não foi possível realizar cadastro, dados faltando.", "Erro",
          JOptionPane.INFORMATION_MESSAGE);
    }
  }

  private static void consulta(String cpf) {
    Cliente cliente = iClienteDAO.consultar(Long.parseLong(cpf));
    if (cliente != null) {
      JOptionPane.showMessageDialog(null, "Cliente encontrado: " + cliente.toString(), "Sucesso",
          JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "Cliente não encontrado.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
  }

  private static void alteração(String cpf) {
    Cliente cliente = iClienteDAO.consultar(Long.parseLong(cpf));
    if (cliente != null) {
      String dados = JOptionPane.showInputDialog(null,
          "Cliente encontrado, digite os dados separados por virgula, conforme exemplo: Nome, Cpf, Telefone, Endereço, Numero, Cidade, Estado: ",
          "Alteração",
          JOptionPane.INFORMATION_MESSAGE);
      String[] dadosSeparados = new String[7];
      dadosSeparados = dados.split(", ");
      Boolean isCadastroErro = false;
      if (dadosSeparados.length == 7) {
        Cliente clienteAlterado = new Cliente(dadosSeparados[0],
            Long.valueOf(dadosSeparados[1]), Long.valueOf(dadosSeparados[2]),
            dadosSeparados[3],
            Integer.valueOf(dadosSeparados[4]),
            dadosSeparados[5], dadosSeparados[6]);
        iClienteDAO.alterar(clienteAlterado);
      } else {
        isCadastroErro = true;
      }

      if (!isCadastroErro) {
        JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso.", "Sucesso",
            JOptionPane.INFORMATION_MESSAGE);
      } else {
        JOptionPane.showMessageDialog(null, "Não foi possível realizar alteração, dados faltando.", "Erro",
            JOptionPane.INFORMATION_MESSAGE);
      }

    } else {
      JOptionPane.showMessageDialog(null, "Cliente não encontrado: ", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
  }

  private static void exclusao(String cpf) {
    Cliente cliente = iClienteDAO.consultar(Long.parseLong(cpf));
    if (cliente != null) {
      iClienteDAO.excluir(cliente.getCpf());
      JOptionPane.showMessageDialog(null, "Cliente encontrado e removido com sucesso. ", "Sucesso",
          JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "Cliente não encontrado: ", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
  }

  private static void sair() {
    JOptionPane.showMessageDialog(null, "Até logo", "Sair", JOptionPane.INFORMATION_MESSAGE);
    System.exit(0);
  }

  private static boolean isOpcaoCadastrar(String opcao) {
    if ("1".equals(opcao)) {
      return true;
    }
    return false;
  }

  private static boolean isOpcaoConsultar(String opcao) {
    if ("2".equals(opcao)) {
      return true;
    }
    return false;
  }

  private static boolean isOpcaoAlterar(String opcao) {
    if ("3".equals(opcao)) {
      return true;
    }
    return false;
  }

  private static boolean isOpcaoExclusao(String opcao) {
    if ("4".equals(opcao)) {
      return true;
    }
    return false;
  }

  private static boolean isOpcaoSair(String opcao) {
    if ("5".equals(opcao)) {
      return true;
    }
    return false;
  }

  private static boolean isOpcaoValida(String opcao) {
    if ("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao)) {
      return true;
    }
    return false;
  }
}
