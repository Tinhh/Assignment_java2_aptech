package sample;

import java.util.ArrayList;

public interface Userinterface {
    boolean create(phonebook u);
    ArrayList<phonebook> getlist();
    boolean update(phonebook u);
    boolean delete(phonebook u);

}
