public class UserMemento {
    protected int accId;
    protected String name;
    protected String date;
    protected long confirmId;
    protected String word;
    public UserMemento(int accId, String name, String date, long confirmId, String word) {
        super();
        this.accId = accId;
        this.name = name;
        this.date = date;
        this.confirmId = confirmId;
        this.word = word;
    }
    public int getAccId() {
        return accId;
    }
    public String getName() {
        return name;
    }
    public String getDate() {
        return date;
    }
    public long getConfirmId() {
        return confirmId;
    }
    public String getWord() {
        return word;
    }
    @Override
    public String toString() {
        return "UserMemento [accId=" + accId + ", name=" + name + ", date=" + date + ", ConfirmationID="
                + confirmId + ", wordchoice=" + word + "]";
    }
}