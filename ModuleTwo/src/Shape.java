public abstract class Shape {
    protected String color;

    public Shape() {}

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() { return color; }

    public abstract String toString();
}
