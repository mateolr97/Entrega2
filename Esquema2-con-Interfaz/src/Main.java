
public class Main {
    public static void main(String[] args) {
        
        Juego juego=new Juego(5);
        juego.añadirObjetoTienda("Baston gastado",5,"Magia", 10);
        juego.agregarHeroe("Mago", "Pepe");
        juego.agregarHeroe("Mago", "Pepi");
        juego.agregarHeroe("Mago", "Pepu");
        juego.agregarHeroe("Mago", "Pepa");
        juego.agregarHeroe("Mago", "Pipi");
        juego.ordenarHeroesxTurno();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
                
            }
        });
       
        
        /*System.out.println(juego.getEnemigos().find(1000, juego.getEnemigos().getRoot()).getKey().getVida());
        juego.atacar("Pepe", "Pedro", "Bola de fuego");
        System.out.println(juego.getEnemigos().find(1000, juego.getEnemigos().getRoot()).getKey().getVida());
        System.out.println(juego.buscarHeroexNombre("Pepe").getOro());
        juego.atacar("Pepe", "Pedro", "Bola de fuego");
        System.out.println(juego.buscarHeroexNombre("Pepe").getMagia());
        juego.comprarObjeto("Pepe", "Baston gastado");
        System.out.println(juego.buscarHeroexNombre("Pepe").getMagia());*/
        
        
        
    }
}
