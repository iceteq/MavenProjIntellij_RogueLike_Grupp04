package Player;

/*
211016 19:49:49
Just nu finns det "profession" som dekorerar
men det går även att lägga till "race" senare.

Nu är det i alla fall möjligt att kombinera på det här sättet:
new Knight(new NPC())
new Knight(new Player())
new Archer(new NPC())
new Archer(new Player())

 */
public abstract class Decorator implements Character {

    Character character;

    public Decorator(Character character){
        this.character = character;

    }

    public int getHealth(){

        return character.getHealth();
    }
}