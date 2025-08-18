package br.univille.singleton;

public class Singleton {
    private static Singleton instance;
    // static é quando existe antes de qualquer coisa, carregado na memória antes de existir qualuer coisa
    // static diz ao java - carregue isso na memória primeiro
    // o singleton aponta para ele mesmo na uml
    private Singleton(){
        //esse é um construtor privado que ele cria ele mesmo
    }
    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}

// é uma classe que niguém pode instanciar ela (criar) sem ser ela mesma 
// por meio do getInstance e do tipo static 
