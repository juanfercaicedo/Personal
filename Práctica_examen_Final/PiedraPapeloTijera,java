import java.util.Scanner;

class PiedraPapeloTiejera{
    public static void main(String[]args){
        Scanner entrada = new Scanner(System.in);
        final int Piedra = 1; 
        final int Papel = 2;
        final int Tijera = 3;
        int turnos = 0;
        final int turnosMaximos = 10;
        boolean jugando = true;

        System.out.println("Escoge 1 para Piedra, 2 Para papel o 3 para Tijera");
        
        while(turnos < turnosMaximos && jugando){
            System.out.println("Estas en el intento #" +(turnos++));
            int eleccionjugador = entrada.nextInt();
            
            int eleccioncomputadora = (int)(Math.random()*3)+1;

            String resultado = (eleccionjugador == eleccioncomputadora)?"Felicidades, ganaste!":"Sigue intentando";
            System.out.println(resultado);
        }  
        entrada.close();
    }
}
