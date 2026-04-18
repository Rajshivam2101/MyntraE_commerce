package enumeration;

public enum ConfigKey {


    CONFIG_PATH("config.path"),

    BROWSER("browser"),

    URL("url");

    private final String key;

    ConfigKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}

