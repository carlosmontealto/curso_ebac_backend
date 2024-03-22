package br.com.calto.dao;

import br.com.calto.dao.generic.jdbc.ConnectionFactory;
import br.com.calto.domain.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO {

  @Override
  public Integer cadastrar(Produto produto) throws Exception {
    Connection connection = null;
    PreparedStatement stm = null;
    try {
      connection = ConnectionFactory.getConnection();
      String sql = getSqlInsert();
      stm = connection.prepareStatement(sql);
      adicionarParametrosInsert(stm, produto);
      return stm.executeUpdate();
    } catch (Exception e) {
      throw e;
    } finally {
      closeConnection(connection, stm, null);
    }
  }

  @Override
  public Integer atualizar(Produto produto) throws Exception {
    Connection connection = null;
    PreparedStatement stm = null;
    try {
      connection = ConnectionFactory.getConnection();
      String sql = getSqlUpdate();
      stm = connection.prepareStatement(sql);
      adicionarParametrosUpdate(stm, produto);
      return stm.executeUpdate();
    } catch (Exception e) {
      throw e;
    } finally {
      closeConnection(connection, stm, null);
    }
  }

  @Override
  public Produto buscar(String codigo) throws Exception {
    Connection connection = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    Produto produto = null;
    try {
      connection = ConnectionFactory.getConnection();
      String sql = getSqlSelect();
      stm = connection.prepareStatement(sql);
      adicionarParametrosSelect(stm, codigo);
      rs = stm.executeQuery();

      if (rs.next()) {
        produto = new Produto();
        Long id = rs.getLong("ID");
        String nome = rs.getString("NOME");
        String cd = rs.getString("CODIGO");
        String descricao = rs.getString("DESCRICAO");
        Double preco = rs.getDouble("PRECO");
        produto.setId(id);
        produto.setNome(nome);
        produto.setCodigo(cd);
        produto.setDescricao(descricao);
        produto.setPreco(preco);
      }
    } catch (Exception e) {
      throw e;
    } finally {
      closeConnection(connection, stm, rs);
    }
    return produto;
  }

  @Override
  public Integer excluir(Produto produto) throws Exception {
    Connection connection = null;
    PreparedStatement stm = null;
    try {
      connection = ConnectionFactory.getConnection();
      String sql = getSqlDelete();
      stm = connection.prepareStatement(sql);
      adicionarParametrosDelete(stm, produto);
      return stm.executeUpdate();
    } catch (Exception e) {
      throw e;
    } finally {
      closeConnection(connection, stm, null);
    }
  }

  @Override
  public List<Produto> buscarTodos() throws Exception {
    Connection connection = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    List<Produto> list = new ArrayList<>();
    Produto produto = null;
    try {
      connection = ConnectionFactory.getConnection();
      String sql = getSqlSelectAll();
      stm = connection.prepareStatement(sql);
      rs = stm.executeQuery();

      while (rs.next()) {
        produto = new Produto();
        Long id = rs.getLong("ID");
        String nome = rs.getString("NOME");
        String cd = rs.getString("CODIGO");
        String descricao = rs.getString("DESCRICAO");
        Double preco = rs.getDouble("PRECO");
        produto.setId(id);
        produto.setNome(nome);
        produto.setCodigo(cd);
        produto.setDescricao(descricao);
        produto.setPreco(preco);
        list.add(produto);
      }
    } catch (Exception e) {
      throw e;
    } finally {
      closeConnection(connection, stm, rs);
    }
    return list;
  }

  private String getSqlInsert() {
    StringBuilder sb = new StringBuilder();
    sb.append("INSERT INTO TB_produto (ID, CODIGO, NOME, DESCRICAO, PRECO ) ");
    sb.append("VALUES (nextval('SQ_PRODUTO'),?,?,?,?)");
    return sb.toString();
  }

  private void adicionarParametrosInsert(
    PreparedStatement stm,
    Produto produto
  ) throws SQLException {
    stm.setString(1, produto.getCodigo());
    stm.setString(2, produto.getNome());
    stm.setString(3, produto.getDescricao());
    stm.setDouble(4, produto.getPreco());
  }

  private String getSqlUpdate() {
    StringBuilder sb = new StringBuilder();
    sb.append("UPDATE TB_PRODUTO ");
    sb.append("SET NOME = ?, CODIGO = ?, DESCRICAO = ?, PRECO = ? ");
    sb.append("WHERE ID = ?");
    return sb.toString();
  }

  private void adicionarParametrosUpdate(
    PreparedStatement stm,
    Produto produto
  ) throws SQLException {
    stm.setString(1, produto.getNome());
    stm.setString(2, produto.getCodigo());
    stm.setString(3, produto.getDescricao());
    stm.setDouble(4, produto.getPreco());
    stm.setLong(5, produto.getId());
  }

  private String getSqlDelete() {
    StringBuilder sb = new StringBuilder();
    sb.append("DELETE FROM TB_PRODUTO ");
    sb.append("WHERE CODIGO = ?");
    return sb.toString();
  }

  private void adicionarParametrosDelete(
    PreparedStatement stm,
    Produto produto
  ) throws SQLException {
    stm.setString(1, produto.getCodigo());
  }

  private String getSqlSelect() {
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT * FROM TB_produto ");
    sb.append("WHERE CODIGO = ?");
    return sb.toString();
  }

  private void adicionarParametrosSelect(PreparedStatement stm, String codigo)
    throws SQLException {
    stm.setString(1, codigo);
  }

  private String getSqlSelectAll() {
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT * FROM TB_PRODUTO");
    return sb.toString();
  }

  private void closeConnection(
    Connection connection,
    PreparedStatement stm,
    ResultSet rs
  ) {
    try {
      if (rs != null && !rs.isClosed()) {
        rs.close();
      }
      if (stm != null && !stm.isClosed()) {
        stm.close();
      }
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
  }
}
