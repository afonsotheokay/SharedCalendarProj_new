public class Users {
    private User[] users;
    private int counter;

    //User[][]
    public Users(int nUsers) {
        this.users = new User[nUsers];
        counter = 0;
    }

    public User[] getUsers() {
        return users;
    }

    public void addUsers(String name) {
        users[counter++] = new User(name);
    }


    public UserIterator iterator() {
        return new UserIterator(users, counter);
    }


    public boolean checkUser(int pName){
        while (iterator().hasNext()){
//TODO Finish checkUser method



        }

    }

}