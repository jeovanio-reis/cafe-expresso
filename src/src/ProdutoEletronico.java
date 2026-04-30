class ProdutoEletronico extends Produto {

    int garantiaMeses;

    public ProdutoEletronico(String nome, double preco, int garantiaMeses) {
        super(nome, preco);
        this.garantiaMeses = garantiaMeses;
    }

    public void exibirDados() {
        super.exibirDados();
        System.out.println("Garantia: " + garantiaMeses + " meses");
    }
}
