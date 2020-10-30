
public class Property {
	private String propertyName ;
	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;
	
	public Property() {
		  propertyName = "";
		  city = "";
		  rentAmount = 0;
		  owner = "";
		  plot = new Plot();
		  
	}
	
	public Property(Property p){
		this.propertyName = p.propertyName;
		this.city = p.city;
		this.rentAmount = p.rentAmount;
        this.owner = p.owner; 
		this.plot = new Plot(p.getPlot()); 
		
	}
	
	public Plot getPlot() {
		return new Plot(plot);
		
	}
	
	public Property(java.lang.String propertyName, java.lang.String city,double rentAmount,java.lang.String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
        this.owner = owner; 
		this.plot = new Plot(); 
		
		
	}
	
	public Property(java.lang.String propertyName,java.lang.String city, double rentAmount,java.lang.String owner,int x,int y,int width,int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
        this.owner = owner; 
		this.plot = new Plot(x,y,width,depth); 
		
	}
	
	public Plot setPlot(int x, int y, int width, int depth) {
		plot.setX(x);
	    plot.setY(y);
	    plot.setWidth(width);
	    plot.setDepth(depth);
	    						
		
		return plot;
		
	}
	
	 
	public java.lang.String toString(){
		String str = String.format("Property Name: %s\n"
				 + " Located in: %s\n"
				 + " Belonging to: %s\n"
				 + " Rent Amount: %.1f\n", propertyName, city, owner, rentAmount);
             return str;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
