package br.univille.singleton;

public class Cliente {
    public static void main(String[] args) {
        var grupoFamilia = new Publisher();

        var zezinho = new ConcreteSubscriber();
        var huguinho = new ConcreteSubscriber();
        var tia = new ConcreteSubscriber();

        //entrou no grupo da familia
        grupoFamilia.subscribe(zezinho);
        grupoFamilia.subscribe(huguinho);
        grupoFamilia.subscribe(tia);

        grupoFamilia.setMainState("BOM DIAAA <3 ");
        //botao enviar
        grupoFamilia.notifySubscribers();

    }
}