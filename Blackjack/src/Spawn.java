
public class Spawn {
    private Handler handler;
    
    public Spawn(Handler handler){
        this.handler = handler;
    }
    public void createDecks(int decks){
        for(int i = 1; i <= decks; i++){
            for(CardSuit suit : CardSuit.values()){
                for(CardType type : CardType.values()){
                    handler.addObject(new CardObject(type,suit,0,0,0,0,false));
                }
            }  
        }
    }
}
