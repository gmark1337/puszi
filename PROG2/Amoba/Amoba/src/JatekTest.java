import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JatekTest {

    @Test
    void nyero(){
        try{
        Jatek jatek = new Jatek("Sanyi", "Peti");
        System.out.println(jatek.jatekosLep("Sanyi", 0,0));
        System.out.println(jatek.jatekosLep("Peti", 1,0));
        System.out.println(jatek.jatekosLep("Sanyi", 1,1));
        System.out.println(jatek.jatekosLep("Peti", 1,2));
        System.out.println(jatek.jatekosLep("Sanyi", 2,2));
    }catch (AmobaException e){
        fail(e);
    }
    }

    @Test
    void nemInditott() {
        try {
            Jatek jatek = new Jatek();
            jatek.jatekosLep("Sanyi", 0,0);
            fail("Nincs game");
        }catch (AmobaException e){
            ;
        }

    }

    @Test
    void rosszHely() {
        try{
            Jatek jatek = new Jatek("Sanyi", "Peti");
            System.out.println(jatek.jatekosLep("Sanyi", 0,0));
            System.out.println(jatek.jatekosLep("Peti", 0,0));
            fail("Rossz hely");
        }catch (AmobaException e){
            ;
        }
    }
}