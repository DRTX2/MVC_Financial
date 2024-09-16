package Models.user;

public enum Role {
    
    NORMAL(1,"Normal"),
    PREMIUM(2,"Premium");
    
    private final Integer id;
    private final String name;

    private Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public static Role fromId(int id) {
        for (Role type : values()) {
            if (type.getId() == id)
                return type;
        }
        throw new IllegalArgumentException("Invalid ID for TypeTransaction: " + id);
    }
    
}
