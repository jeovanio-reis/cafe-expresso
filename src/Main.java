public class Main {
    public static void main(String[] args) {

        System.out.println("Projeto Café Expresso iniciado");

        // Teste Produto
        Produto p = new Produto("Café", 5.0);
        p.exibirDados();
        System.out.println("Teste Produto OK");

        // Teste Produto Eletrônico
        ProdutoEletronico pe = new ProdutoEletronico("Notebook", 3000, 12);
        pe.exibirDados();
    }
}

// Teste Funcionários
Funcionario[] lista = new Funcionario[2];
lista[0] = new FuncionarioCLT(3000);
lista[1] = new FuncionarioFreelancer(100, 20);

for (Funcionario f : lista) {
    System.out.println("Salário: " + f.calcularSalario());
}

// Teste Caixa
Caixa<String> c1 = new Caixa<>();
c1.guardar("Teste");
System.out.println(c1.abrir());

// Teste Arquivo
try {
    Arquivo.escrever();
    Arquivo.ler();
} catch (Exception e) {
    System.out.println("Erro ao manipular arquivo");
}
