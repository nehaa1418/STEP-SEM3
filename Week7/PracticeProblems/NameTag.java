class NameTagData {
    private final String firstName;
    private final String lastName;

    NameTagData(String fullName) {
        String[] names = fullName.split(" ");
        firstName = names[0];
        lastName = names[1];
    }

    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }
}

public class NameTag {
    public static void main(String[] args) {
        NameTagData tag = new NameTagData("Maria Gomez");
        System.out.println(tag.getNickname());
    }
}
