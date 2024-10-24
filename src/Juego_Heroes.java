import java.util.Scanner;
import java.util.Random;

public class Juego_Heroes {
    private static int vidaHeroe = 100;
    private static int vidaVillano = 150;
    private static int vidaJefe = 200;
    private static String personajeSeleccionado;
    private static Random random = new Random();
    private static int usosBonusJugador = 2; // Usos de bonus para el jugador
    private static int usosBonusJefe = 2; // Usos de bonus para el jefe
    private static int usosBonusDañoJugador = 2; // Usos de bonus de daño para el jugador
    private static int usosBonusDañoJefe = 2; // Usos de bonus de daño para el jefe
    private static int dañoAdicionalJefe = 0;
    private static int dañoAdicionalJugador = 0;
    private static int usosHabilidadEspecialJugador = 2; // Usos de habilidad especial para el jugador
    private static int usosHabilidadEspecialJefe = 2; // Usos de habilidad especial para el jefe
    
    



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Título del juego
        System.out.println("******************************");
        System.out.println("* ¡Bienvenido al Combate Épico! *");
        System.out.println("******************************");
        // Selección de personaje
        System.out.println("\nSelecciona tu personaje:");
        System.out.println("1. Héroe (Goku)");
        System.out.println("2. Villano (Zamasu)");
        System.out.print("Elección: ");
        int eleccion = scanner.nextInt();
        if (eleccion == 1) {
            personajeSeleccionado = "Goku";
            System.out.println("\nHas seleccionado a Goku.");
        } else if (eleccion == 2) {
            personajeSeleccionado = "Zamasu";
            System.out.println("\nHas seleccionado a Zamasu.");
        } else {
            System.out.println("\nElección inválida. Terminando juego.");
            System.exit(0);
        }

        // Combate por turnos
        while (vidaHeroe > 0 && vidaVillano > 0 && vidaJefe > 0) {
            // Turno del jugador
            System.out.println("\n==================================");
            System.out.println("Turno de " + personajeSeleccionado);
            System.out.println("==================================");
            System.out.println("1. Disparar");
            System.out.println("2. Usar bonus de curación (" + usosBonusJugador + " usos restantes)");
            System.out.println("3. Usar bonus de daño (" + usosBonusDañoJugador + " usos restantes)");
            System.out.println("4. Usar habilidad especial de ataque (" + usosHabilidadEspecialJugador + " usos restantes)");

            System.out.print("Acción: ");
            int accion = scanner.nextInt();
            if (accion == 1) {
                dispararJugador();
            } else if (accion == 2) {
                usarBonusJugador();
            } else if (accion == 3) {
                usarBonusDañoJugador();
            } else if (accion == 4) {
                usarHabilidadEspecialJugador();
            } else {
                System.out.println("\nAcción inválida.");
            }
            

            System.out.println("========================================================================================");

            // Turno del jefe
            if (vidaJefe > 0) {
                turnoJefe();
            }

            // Mostrar estadísticas
            mostrarEstadisticas();
        }

        // Mostrar resultado final
        if (vidaJefe <= 0) {
            System.out.println("\n¡Enhorabuena! Has derrotado al jefe.");
        } else if (personajeSeleccionado.equals("Goku") && vidaHeroe <= 0) {
            System.out.println("\nGoku ha sido derrotado.");
        } else if (personajeSeleccionado.equals("Zamasu") && vidaVillano <= 0) {
            System.out.println("\nZamasu ha sido derrotado.");
        }
    }

    private static void usarHabilidadEspecialJugador() {
        if (usosHabilidadEspecialJugador > 0) {
            int dañoEspecial = personajeSeleccionado.equals("Goku") ? 50 : 40;
            vidaJefe -= dañoEspecial;
            System.out.println("\n" + personajeSeleccionado + " usó su habilidad especial causando " + dañoEspecial + " de daño al jefe.");
            usosHabilidadEspecialJugador--;
        } else {
            System.out.println("\nYa has usado todos tus usos de habilidad especial.");
        }
    }
    
    
    

    private static void dispararJugador() {
        int daño = personajeSeleccionado.equals("Goku") ? 10 : 15;
        daño += dañoAdicionalJugador; // Añadir el daño adicional
        vidaJefe -= daño;
        System.out.println("\n" + personajeSeleccionado + " disparó al jefe causando " + daño + " de daño.");
        dañoAdicionalJugador = 0; // Restablecer el daño adicional después del ataque
    }
    
    private static void usarBonusDañoJugador() {
        if (usosBonusDañoJugador > 0) {
            int bonusDaño = personajeSeleccionado.equals("Goku") ? 20 : 30;
            dañoAdicionalJugador += bonusDaño;
            System.out.println("\n" + personajeSeleccionado + " usó un bonus de daño y aumentará el próximo ataque en " + bonusDaño + ".");
            usosBonusDañoJugador--;
        } else {
            System.out.println("\nNo te quedan más usos de bonus de daño.");
        }
    }
    
    

    private static void usarBonusJugador() {
        if (usosBonusJugador > 0) {
            int curacion = personajeSeleccionado.equals("Goku") ? 30 : 25;
            if (personajeSeleccionado.equals("Goku")) {
                vidaHeroe += curacion;
                System.out.println("\nGoku usó un bonus de curación y recuperó " + curacion + " de vida.");
            } else {
                vidaVillano += curacion;
                System.out.println("\nZamasu usó un bonus de curación y recuperó " + curacion + " de vida.");
            }
            usosBonusJugador--;
        } else {
            System.out.println("\nNo te quedan más usos de bonus.");
        }
    }

    private static void turnoJefe() {
        int accionJefe = random.nextInt(6); // 0, 1, 2, 3, 4 o 5
        if (accionJefe == 0) {
            System.out.println("\nEl jefe se cubrió.");
        } else if (accionJefe == 1) {
            int daño = random.nextInt(20) + 1;
            daño += dañoAdicionalJefe; // Añadir el daño adicional
            if (personajeSeleccionado.equals("Goku")) {
                vidaHeroe -= daño;
                System.out.println("\nEl jefe disparó a Goku causando " + daño + " de daño.");
            } else {
                vidaVillano -= daño;
                System.out.println("\nEl jefe disparó a Zamasu causando " + daño + " de daño.");
            }
            dañoAdicionalJefe = 0; // Restablecer el daño adicional después del ataque
        } else if (accionJefe == 2 && usosBonusJefe > 0) {
            int curacion = 50;
            vidaJefe += curacion;
            System.out.println("\nEl jefe usó un bonus de curación y recuperó " + curacion + " de vida.");
            usosBonusJefe--;
        } else if (accionJefe == 3 && usosBonusDañoJefe > 0) {
            int bonusDaño = 40;
            dañoAdicionalJefe += bonusDaño;
            System.out.println("\nEl jefe usó un bonus de daño y aumentará el próximo ataque en " + bonusDaño + ".");
            usosBonusDañoJefe--;
        } else if (accionJefe == 4 && usosHabilidadEspecialJefe > 0) {
            int dañoEspecial = 60;
            if (personajeSeleccionado.equals("Goku")) {
                vidaHeroe -= dañoEspecial;
                System.out.println("\nEl jefe usó su habilidad especial causando " + dañoEspecial + " de daño a Goku.");
            } else {
                vidaVillano -= dañoEspecial;
                System.out.println("\nEl jefe usó su habilidad especial causando " + dañoEspecial + " de daño a Zamasu.");
            }
            usosHabilidadEspecialJefe--;
        } else if (accionJefe == 5 && usosHabilidadEspecialJefe > 0) {
            int curacionEspecial = 50;
            vidaJefe += curacionEspecial;
            System.out.println("\nEl jefe usó su habilidad especial y recuperó " + curacionEspecial + " de vida.");
            usosHabilidadEspecialJefe--;
        }
        
        
        
    }
    
    

    private static void mostrarEstadisticas() {
        System.out.println("\n--- Estadísticas ---");
        System.out.println("Vida del jefe: " + vidaJefe);
        if (personajeSeleccionado.equals("Goku")) {
            System.out.println("Vida de Goku: " + vidaHeroe);
        } else {
            System.out.println("Vida de Zamasu: " + vidaVillano);
        }
        System.out.println("---------------------");
    }
}
