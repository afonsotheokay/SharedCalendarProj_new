public class UserIterator {

    private User[] users;
    private int size;
    private int index;

    public UserIterator(User[] users, int size){
        this.users = users;
        this.size = size;
        index = 0;
    }

    public boolean hasNext(){
        return index < size;
    }

    public User next(){
        return users[index++];
    }

    public int getIndex(){
        return index;
    }
}
