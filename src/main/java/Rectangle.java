
public class Rectangle extends Shape{
    protected double width=1.0;
    protected double length=1.0;

    public Rectangle(){super();}

    public Rectangle(double width, double length){
        super();
        this.width=width;
        this.length=length;
    }

    public Rectangle(double width, double length, String color, boolean filled){
        super(color,filled);
        this.width=width;
        this.length=length;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    double getArea(){
        return this.getLength()*this.getWidth();
    }

    double getPerimeter(){
        return 2*this.getLength()+2*this.getWidth();
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                '}';
    }

}
