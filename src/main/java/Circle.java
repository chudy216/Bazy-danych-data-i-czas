public class Circle extends Shape{
    protected double radius=1.0;

    public Circle(){super();}

    public Circle(double radius){
        super();
        this.radius=radius;
    }

    public Circle(double radius, String color, boolean filled){
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    double getArea(){
        return Math.PI*Math.pow(this.getRadius(),2);
    }

    double getPerimeter(){
        return Math.PI*2*this.getRadius();
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
