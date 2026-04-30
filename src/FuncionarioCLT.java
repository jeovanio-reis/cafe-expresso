class FuncionarioCLT extends Funcionario {

    double salarioBase;

    public FuncionarioCLT(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public double calcularSalario() {
        return salarioBase;
    }
}
