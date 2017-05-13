package Core;

import java.util.HashMap;
import java.util.Map;

public enum BrowserType {
    FIREFOX("firefox"),
    IE("ie"),
    CHROME("chrome"),
    EDGE("edge");

    private String browserKey;
    private static Map<String, BrowserType> browserMap = new HashMap<>();

    static {
        for (BrowserType bt : BrowserType.values()) {
            browserMap.put(bt.getKey(), bt);
        }
    }

    private BrowserType(String browserKey) {
        this.browserKey = browserKey;
    }

    private String getKey() {
        return this.browserKey;
    }

    public static BrowserType getBrowser(String key) {
        if (browserMap.containsKey(key)) {
            return browserMap.get(key);
        }
        return CHROME;
    }

}
