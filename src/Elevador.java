/**
 * Classe que representa um elevador em um edifício.
 *
 * Responsabilidades:
 * - Gerenciar o andar atual
 * - Controlar o estado da porta (aberta/fechada)
 * - Permitir subir e descer entre andares válidos
 * - Verificar restrições de operação
 */
public class Elevador {

    // Atributos
    private int andarAtual;
    private int andarMaximo;
    private boolean portaAberta;

    /**
     * Construtor da classe Elevador
     *
     * @param andarMaximo O número máximo de andares do edifício
     */
    public Elevador(int andarMaximo) {
        if (andarMaximo < 1) {
            throw new IllegalArgumentException("O edifício deve ter no mínimo 1 andar");
        }
        this.andarMaximo = andarMaximo;
        this.andarAtual = 1;  // Começa no primeiro andar
        this.portaAberta = false;
    }

    /**
     * Abre a porta do elevador
     */
    public void abrirPorta() {
        this.portaAberta = true;
        System.out.println("🚪 Porta aberta!");
    }

    /**
     * Fecha a porta do elevador
     */
    public void fecharPorta() {
        this.portaAberta = false;
        System.out.println("🚪 Porta fechada!");
    }

    /**
     * Verifica se a porta está aberta
     *
     * @return true se a porta está aberta, false caso contrário
     */
    public boolean isPortaAberta() {
        return this.portaAberta;
    }

    /**
     * Retorna o andar atual do elevador
     *
     * @return O número do andar atual
     */
    public int getAndarAtual() {
        return this.andarAtual;
    }

    /**
     * Retorna o número máximo de andares
     *
     * @return O andar máximo do edifício
     */
    public int getAndarMaximo() {
        return this.andarMaximo;
    }

    /**
     * Sobe o elevador para um andar específico
     *
     * @param andar O andar para o qual subir
     * @throws IllegalArgumentException se o andar é inválido
     * @throws IllegalStateException se a porta está aberta
     */
    public void subir(int andar) {
        // Valida se a porta está aberta
        if (this.portaAberta) {
            throw new IllegalStateException("❌ Não é possível subir com a porta aberta!");
        }

        // Valida se o andar é válido
        if (andar < 1 || andar > this.andarMaximo) {
            throw new IllegalArgumentException(
                    String.format("❌ Andar inválido! O edifício possui andares de 1 a %d", this.andarMaximo)
            );
        }

        // Valida se é um movimento para cima
        if (andar <= this.andarAtual) {
            throw new IllegalArgumentException("❌ Para descer, use o método descer()!");
        }

        System.out.println("⬆️  Subindo...");
        while (this.andarAtual < andar) {
            this.andarAtual++;
            System.out.println("📍 Andar " + this.andarAtual);
        }
        System.out.println("✅ Chegou no andar " + this.andarAtual);
    }

    /**
     * Desce o elevador para um andar específico
     *
     * @param andar O andar para o qual descer
     * @throws IllegalArgumentException se o andar é inválido
     * @throws IllegalStateException se a porta está aberta
     */
    public void descer(int andar) {
        // Valida se a porta está aberta
        if (this.portaAberta) {
            throw new IllegalStateException("❌ Não é possível descer com a porta aberta!");
        }

        // Valida se o andar é válido
        if (andar < 1 || andar > this.andarMaximo) {
            throw new IllegalArgumentException(
                    String.format("❌ Andar inválido! O edifício possui andares de 1 a %d", this.andarMaximo)
            );
        }

        // Valida se é um movimento para baixo
        if (andar >= this.andarAtual) {
            throw new IllegalArgumentException("❌ Para subir, use o método subir()!");
        }

        System.out.println("⬇️  Descendo...");
        while (this.andarAtual > andar) {
            this.andarAtual--;
            System.out.println("📍 Andar " + this.andarAtual);
        }
        System.out.println("✅ Chegou no andar " + this.andarAtual);
    }

    /**
     * Exibe informações do elevador
     */
    public void exibirStatus() {
        String statusPorta = this.portaAberta ? "Aberta" : "Fechada";
        System.out.println("\n╔════════════════════════════╗");
        System.out.println("║     STATUS DO ELEVADOR     ║");
        System.out.println("╠════════════════════════════╣");
        System.out.println("║ Andar atual: " + this.andarAtual);
        System.out.println("║ Andar máximo: " + this.andarMaximo);
        System.out.println("║ Porta: " + statusPorta);
        System.out.println("╚════════════════════════════╝\n");
    }

    @Override
    public String toString() {
        return String.format(
                "Elevador{andarAtual=%d, andarMaximo=%d, portaAberta=%s}",
                this.andarAtual, this.andarMaximo, this.portaAberta
        );
    }
}
