package portalPlantei;

public class Planta {
    

    // Declaração de variáveis
    
      private int id;

      private String nomePlanta;
      private String descricao;
      private String tempoSol;
      private String rega;
      private String tempoAdubo;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    
    public void setNomePlanta(String nomePlanta) {
        this.nomePlanta = nomePlanta;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTempoSol(String tempoSol) {
        this.tempoSol = tempoSol;
    }

    public void setRega(String rega) {
        this.rega = rega;
    }

    public void setTempoAdubo(String tempoAdubo) {
        this.tempoAdubo = tempoAdubo;
    }

    public String getNomePlanta() {
        return nomePlanta;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTempoSol() {
        return tempoSol;
    }

    public String getRega() {
        return rega;
    }

    public String getTempoAdubo() {
        return tempoAdubo;
    }
}
