package rudyAir.model.client;

public class Adresse {
   int numero;
   String voie;
   String cp;
   String ville;

   public Adresse(int numero, String voie, String cp, String ville) {
      this.numero = numero;
      this.voie = voie;
      this.cp = cp;
      this.ville = ville;
   }

   public int getNumero() {
      return this.numero;
   }

   public void setNumero(int numero) {
      this.numero = numero;
   }

   public String getVoie() {
      return this.voie;
   }

   public void setVoie(String voie) {
      this.voie = voie;
   }

   public String getCp() {
      return this.cp;
   }

   public void setCp(String cp) {
      this.cp = cp;
   }

   public String getVille() {
      return this.ville;
   }

   public void setVille(String ville) {
      this.ville = ville;
   }

   public String toString() {
      return "Adresse [numero=" + this.numero + ", voie=" + this.voie + ", cp=" + this.cp + ", ville=" + this.ville + "]";
   }
}
