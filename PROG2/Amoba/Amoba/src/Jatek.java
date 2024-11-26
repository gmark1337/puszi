public class Jatek{
    private String jatekos1;
    private String jatekos2;
    private boolean jatek;
    private String last_jatekos;

    private String[][] tabla;

    public Jatek() {
    }

    public Jatek(String jatekos1, String jatekos2) {
        this.jatekos1 = jatekos1;
        this.jatekos2 = jatekos2;
        jatek = true;
        tabla = new String [3][3];
        last_jatekos = "";
    }

    public String jatekosLep(String jatekos, int sor, int oszlop) throws AmobaException {
        if (jatek) {
            if(sor <= 3 || oszlop <= 3){
                if(!last_jatekos.equals(jatekos)) {
                    if (tabla[sor][oszlop] == null) {
                        tabla[sor][oszlop] = jatekos;
                        last_jatekos = jatekos;
                        if(nyertE(jatekos))return "Nyert: " + jatekos;
                    } else throw new AmobaException("Ide már raktak");
                }else throw new AmobaException("Rossz jatekos");
            }else throw new AmobaException("Nem letezo mezo");

        } else throw new AmobaException("Nem inditottak jatekot");
        return "";
    }

    public boolean nyertE(String jatekos){
        if(tabla[0][0] == jatekos){
            if(tabla[1][0] == jatekos)
                if(tabla[2][0] == jatekos)return true;
            if(tabla[0][1] == jatekos)
                if(tabla[0][2] == jatekos)return true;
            if(tabla[1][1] == jatekos)
                if(tabla[2][2] == jatekos)return true;
        }
        if(tabla[0][1] == jatekos){
            if(tabla[1][1] == jatekos)
                if(tabla[2][1] == jatekos)return true;
        }
        if(tabla[0][2] == jatekos){
            if(tabla[1][2] == jatekos)
                if(tabla[2][2] == jatekos)return true;
        }
        if(tabla[1][0] == jatekos){
            if(tabla[1][1] == jatekos)
                if(tabla[1][2] == jatekos)return true;
        }
        if(tabla[2][0] == jatekos){
            if(tabla[2][1] == jatekos)
                if(tabla[2][2] == jatekos)return true;
        }
        if(tabla[0][2] == jatekos){
            if(tabla[1][1] == jatekos)
                if(tabla[2][0] == jatekos)return true;
        }
        return false;
    }


}
