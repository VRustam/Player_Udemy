package Course;

public abstract class Man {
    private String name;
    private String promotion;
    private String login;

    public Man(String name, String promotion, String login) {
        this.name = name;
        this.promotion = promotion;
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public String getPromotion() {
        return promotion;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", promotion='" + promotion + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
