package portal;

public class Material {
    private final String type;
    private final String content;

    public Material(String type, String content) {
        this.type = type;
        this.content = content;
    }

    public String getType() {
        return this.type;
    }
}
