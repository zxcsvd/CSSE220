import java.util.ArrayList;


public class ImaginaryNum {
	private double real, imaginary;
	
	public ImaginaryNum(double real, double imaginary)
	{
		this.real = real;
		this.imaginary = imaginary;
	}
	
	public void setReal(double real)
	{
		this.real = real;
	}
	
	public double getReal()
	{
		return this.real;
	}
	
	
	public double getImaginary()
	{
		return this.imaginary;
	}
	
	public ImaginaryNum addAndCreate(double real)
	{
		ImaginaryNum create = new ImaginaryNum(real + this.real, this.imaginary);
		return create;
	}
	
	public void setImaginary(double imaginary)
	{
		this.imaginary = imaginary;
	}
	
	public String toString()
	{
		return "r=" + this.real + " i=" + this.imaginary;
	}
	
}
