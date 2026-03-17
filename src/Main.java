//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║          DEMONSTRAÇÃO - SISTEMA DE ELEVADOR           ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝\n");

        // Criando um elevador com 10 andares
        Elevador elevador = new Elevador(10);

        System.out.println("✅ Elevador criado com 10 andares!\n");

        // Teste 1: Exibir status inicial
        elevador.exibirStatus();

        // Teste 2: Subir para o andar 5
        System.out.println("--- Teste 1: Subindo para o andar 5 ---");
        elevador.subir(5);
        elevador.exibirStatus();

        // Teste 3: Abrir a porta
        System.out.println("--- Teste 2: Abrindo a porta ---");
        elevador.abrirPorta();
        System.out.println("Porta está aberta? " + elevador.isPortaAberta() + "\n");

        // Teste 4: Tentar subir com a porta aberta (deve dar erro)
        System.out.println("--- Teste 3: Tentando subir com porta aberta ---");
        try {
            elevador.subir(8);
        } catch (IllegalStateException e) {
            System.out.println("⚠️  Exceção capturada: " + e.getMessage());
        }
        System.out.println();

        // Teste 5: Fechar a porta
        System.out.println("--- Teste 4: Fechando a porta ---");
        elevador.fecharPorta();
        System.out.println("Porta está aberta? " + elevador.isPortaAberta() + "\n");

        // Teste 6: Subir para o andar 10
        System.out.println("--- Teste 5: Subindo para o andar 10 ---");
        elevador.subir(10);
        elevador.exibirStatus();

        // Teste 7: Descer para o andar 3
        System.out.println("--- Teste 6: Descendo para o andar 3 ---");
        elevador.descer(3);
        elevador.exibirStatus();

        // Teste 8: Tentar ir para um andar inválido (maior que o máximo)
        System.out.println("--- Teste 7: Tentando subir para andar 15 (inválido) ---");
        try {
            elevador.subir(15);
        } catch (IllegalArgumentException e) {
            System.out.println("⚠️  Exceção capturada: " + e.getMessage());
        }
        System.out.println();

        // Teste 9: Tentar descer para andar 0 (inválido)
        System.out.println("--- Teste 8: Tentando descer para andar 0 (inválido) ---");
        try {
            elevador.descer(0);
        } catch (IllegalArgumentException e) {
            System.out.println("⚠️  Exceção capturada: " + e.getMessage());
        }
        System.out.println();

        // Teste 10: Descer para o andar 1
        System.out.println("--- Teste 9: Descendo para o andar 1 ---");
        elevador.descer(1);
        elevador.exibirStatus();

        // Teste 11: Abrir porta e tentar descer
        System.out.println("--- Teste 10: Abrindo porta e tentando descer ---");
        elevador.abrirPorta();
        try {
            elevador.descer(1);
        } catch (IllegalStateException e) {
            System.out.println("⚠️  Exceção capturada: " + e.getMessage());
        }
        System.out.println();

        // Teste 12: Usar método toString
        System.out.println("--- Teste 11: Representação em String ---");
        System.out.println(elevador.toString());
        System.out.println();

        // Teste 13: Múltiplos movimentos
        System.out.println("--- Teste 12: Sequência de movimentos ---");
        elevador.fecharPorta();
        elevador.subir(7);
        elevador.abrirPorta();
        elevador.fecharPorta();
        elevador.descer(4);
        elevador.exibirStatus();

        System.out.println("═══════════════════════════════════════════════════════");
        System.out.println("Testes concluídos com sucesso! ✅");
        System.out.println("═══════════════════════════════════════════════════════");
    }
}