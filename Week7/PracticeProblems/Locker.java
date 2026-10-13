class LockerData {
    private final int lockerNumber;
    private String code;

    LockerData(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public void changeCode(String currentCode, String newCode) {
        if (code.equals(currentCode)) {
            code = newCode;
            System.out.println("Code changed successfully");
        } else {
            System.out.println("Wrong current code");
        }
    }
}

public class Locker {
    public static void main(String[] args) {
        LockerData l = new LockerData(101, "1234");

        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
    }
}