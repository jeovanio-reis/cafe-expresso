class FuncionarioFreelancer extends Funcionario {

    int horasTrabalhadas;
    double valorHora;

    public FuncionarioFreelancer(int horasTrabalhadas, double valorHora) {
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    @Override
    public double calcularSalario() {
        return horasTrabalhadas * valorHora;
    }
}
