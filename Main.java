public class Main {
    public static void main(String[] args) {
        UserCaretaker caretaker = new UserCaretaker();
        System.out.println("creating User objects with intial values");
        User josh = new User(100).setName("Josh").setDate("07/02/2003").setConfirmId(100000).setWord("awesome");
        System.out.println(josh);
        UserMemento joshMemento = josh.createMemento();
        caretaker.addMemento(josh.getAccId(), "Word Saved at input stage", joshMemento);
        System.out.println("\nJosh's word got confirmed!");
        josh.setDate("07/02/2003").setConfirmId(120000);
        System.out.println(josh);
        joshMemento = josh.createMemento();
        caretaker.addMemento(josh.getAccId(), "Word Saved at confirmation", joshMemento);
        System.out.println("\nJosh's word got posted!");
        josh.setConfirmId(140000);
        System.out.println(josh);
        joshMemento = josh.createMemento();
        caretaker.addMemento(josh.getAccId(), "Word Saved at posting", joshMemento);
        System.out.println("\nLet's print the stored memento objects we have");
        caretaker.printStoredMementoObjects();
        System.out.println("\nnow for some reason, we like to revert Josh to input stage.");
        joshMemento = caretaker.getMemento(josh.getAccId(), "Word Saved at input stage");
        josh.restore(joshMemento);
        System.out.println(josh);
    }
}