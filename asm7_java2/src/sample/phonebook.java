package sample;

public class phonebook {
    public Integer id;
    public String user_id;
    public String telephone;
    public String status;

    public phonebook() {
    }

    public phonebook(Integer id, String user_id, String telephone, String status) {
        this.id = id;
        this.user_id = user_id;
        this.telephone = telephone;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}