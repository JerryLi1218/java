package lab01;


public class Lab0102 {

    public static void main(String[] args) throws Exception {
	Triangle triangleNormal = null;
	Triangle triangleIllegal = null;

	try {
	    triangleNormal = new Triangle(1, 1.5, 1, "yellow", true);
	    System.out.println("Side: " + triangleNormal);
	    System.out.println("Area: " + triangleNormal.getArea());
	    System.out.println("Perimeter: " + triangleNormal.getPerimeter());
	    System.out.println("Color: " + triangleNormal.getColor());
	    System.out.println("Is it filled? : " + triangleNormal.getIsFilled());

	    triangleIllegal = new Triangle(-1, 0, 1, null, false);
	    System.out.println("t1.toString() : " + triangleIllegal);
	    System.out.println("Area: " + triangleIllegal.getArea());
	    System.out.println("Perimeter: " + triangleIllegal.getPerimeter());
	    System.out.println("Color: " + triangleIllegal.getColor());
	    System.out.println("Is it filled?: " + triangleIllegal.getIsFilled());
		} catch (IllegalSideException e) {
		    e.printStackTrace();
		}
    }

}

class IllegalSideException extends Exception {
    private static final long serialVersionUID = -1L;

    private double side1;
    private double side2;
    private double side3;

    private String information;

    public IllegalSideException() {
	super();
    }

    public IllegalSideException(double side1, double side2, double side3, String information) {
	this.side1 = side1;
	this.side2 = side2;
	this.side3 = side3;
	this.information = information;
    }

    @Override
    public String getMessage() {
	return information + ": " + side1 + ", " + side2 + ", " + side3;
    }
}


//定义抽象图像类，加入基本要素是否填充和颜色
abstract class GeometricObject {
    private String color;
    private boolean isFilled;

    public GeometricObject() {
	color = "white";
	isFilled = false;
    }

    public GeometricObject(String color, boolean isFilled) {
	this.color = color;
	this.isFilled = isFilled;
    }

    public String getColor() {
	return color;
    }

    public void setColor(String color) {
	this.color = color;
    }

    public boolean getIsFilled() {
	return isFilled;
    }

    public void setIsFilled(boolean isFilled) {
	this.isFilled = isFilled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}

//定义子类三角形类并继承图像类
class Triangle extends GeometricObject {
	//利用编译器自带的自动生成getter&setter会更方便哦
    private double side1;
    public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) {
		this.side1 = side1;
	}

	private double side2;
    public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) {
		this.side2 = side2;
	}

	private double side3;
	public double getSide3() {
		return side3;
	}

	public void setSide3(double side3) {
		this.side3 = side3;
	}

    public Triangle() {
	side1 = 1.0;
	side2 = 1.0;
	side3 = 1.0;
    }

    public Triangle(double side1, double side2, double side3, String color, boolean isFilled)
	    throws IllegalSideException {
	super(color, isFilled);

	//边的值小于1.0抛异常
	if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
	    throw new IllegalSideException(side1, side2, side3, "Illegal Sides");
	}

	this.side1 = side1;
	this.side2 = side2;
	this.side3 = side3;
    }
    
    public double getArea() {
	double p = (side1 + side2 + side3) / 2;
	return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));// ���׹�ʽ
    }

    public double getPerimeter() {
	return side1 + side2 + side3;
    }

    // 重载toString
    @Override
    public String toString() {
	return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }
}

