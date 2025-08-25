//Classe concreta, porque é onde tem o código

package br.univille.observer;

public class ConcreteSubscriber
    implements Subscriber {
    
    public void update(String context){
        System.out.println(context);
    }


}