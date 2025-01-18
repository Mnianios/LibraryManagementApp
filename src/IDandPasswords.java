import java.util.HashMap;

public class IDandPasswords {
    HashMap<String, String> logininfo = new HashMap<>();

    public IDandPasswords() {
        logininfo.put("User0", "pass");
        logininfo.put("User2", "p2");
        logininfo.put("miken", "p123");
    }

    public HashMap<String, String> getLoginInfo() {
        return logininfo;
    }
}
