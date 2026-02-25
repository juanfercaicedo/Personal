package SegundoAño.EDA2.NotasClase25Feb;

class Topologia{
    static void f(int n, String camino){
        if(n==0){
            System.out.println("Llegué a " + camino + n);
            return;
        } 
        camino = camino + n + " ";
        System.out.println("Elijo:  "+ n + "--->" + camino);
        f(n-1, " ");
        System.out.println("Saco: " + n + "--->\\n" + camino);

    }
    
    public static void main(String[] args) {
        f(5, " " );
    }
    /*
    Espacios topologios
    1. Eliges
    2. LLegas
    3. Deshaces
    */
}
