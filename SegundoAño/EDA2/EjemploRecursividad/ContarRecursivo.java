package SegundoAño.EDA2.EjemploRecursividad;

class ContarRecursivo{
    public static void main(String[] args) {
        contar(100);
    }

    static void contar(int valorFinal){
        if(valorFinal == 0){
            System.out.println(valorFinal);
        }else{
            contar(valorFinal -1);
            System.out.println(valorFinal);
        }
    }
}

// Es recursivo porqué el método se llama a si mismo