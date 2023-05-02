public class User {
    protected int accId;
    protected String name;
    protected String date;
    protected long confirmId;
    protected String word;
 public User(int accId) {
        super();
        this.accId = accId;
    }
    public int getAccId() {
        return accId;
    }
    public String getName() {
        return name;
    }
    public User setName(String name) {
        this.name = name;
        return this;
    }
    public String getDate() {
        return date;
    }
    public User setDate(String date) {
    this.date = date;
    return this;
    }
    public long getConfirmId() {
        return confirmId;
    }
    public User setConfirmId(long confirmId) {
        this.confirmId = confirmId;
        return this;
    }
    public String getWord() {
        return word;
    }
    public User setWord(String word) {
        this.word = word;
        return this;
    }
    @Override
    public String toString() {
        return "User [accId=" + accId + ", name=" + name + ", date=" + date + ", ConfirmationID=" + confirmId
                + ", wordchoice=" + word + "]";
    }
    public UserMemento createMemento() {
        return new UserMemento(accId, name, date, confirmId, word);
    }
    public void restore(UserMemento memento) {
        if (memento != null) {
            this.accId = memento.accId;
            this.name = memento.name;
            this.date = memento.date;
            this.confirmId = memento.confirmId;
            this.word = memento.word;
        } else {
            System.err.println("Can't restore without memento object!");
        }
    }
}