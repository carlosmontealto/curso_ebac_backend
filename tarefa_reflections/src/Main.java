import java.lang.annotation.*;
import java.lang.reflect.*;

public class Main {

  public static void main(String[] args) {

    // instanciando minha tabela
    Tabela tabela = new Tabela();

    // pegando o valor da anotação dentro dos campos
    Field[] fields = tabela.getClass().getDeclaredFields();

    for (Field field : fields) {
      if (field.isAnnotationPresent(TabelaAnotacao.class)) {
        TabelaAnotacao tabelaAnotacao2 = field.getAnnotation(TabelaAnotacao.class);
        System.out.println(tabelaAnotacao2.value());
      }
    }
    // Pegando o valor da anotação na classe
    Annotation[] anotacoes = tabela.getClass().getAnnotations();

    for (Annotation anotacao : anotacoes) {
      if (anotacao.annotationType().equals(TabelaAnotacao.class)) {
        // IF para fazer o casting da TabelaAnotacao
        TabelaAnotacao tabelaAnotacao = (TabelaAnotacao) anotacao;
        System.out.println(tabelaAnotacao.value());
      }
    }
  }
}
