package cn.itcast.server.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserServiceMemoryImpl implements UserService {
    private Map<String, String> allUserMap = new ConcurrentHashMap<>();

    {
        allUserMap.put("lxb", "123");
        allUserMap.put("toby", "123");
        allUserMap.put("lekaijun", "123");
        allUserMap.put("jiangjun", "123");
        allUserMap.put("yuhui", "123");
    }

    @Override
    public boolean login(String username, String password) {
        String pass = allUserMap.get(username);
        if (pass == null) {
            return false;
        }
        return pass.equals(password);
    }
}
