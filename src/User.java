public class User {
    private String name;
    private Events[] userEvents;
    int counter;

    public User(String name){
        this.name = name;
    }


    //    Method to check if one user equals another
    public boolean isUser(String anotherUser){
        return name.equals(anotherUser);
    }
}
