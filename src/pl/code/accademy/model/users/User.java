package pl.code.accademy.model.users;

public class User {
    private int id;
    private String name;
    private String surname;
    private String PESEL;

    private String login;
    private String password;
    private String status;

    public User() {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.PESEL = PESEL;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", login='" + login + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
