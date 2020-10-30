
public class ManagementCompany {
	private java.lang.String name;
	private java.lang.String taxID; 
	private Property[] properties;
	private double mgmFeePer;
	private final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private Plot plot;
	
	
	public ManagementCompany() {
		name = "";
		taxID = "";
		properties = new Property[MAX_PROPERTY ];
		mgmFeePer = 0;
		plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH );
		
	}
	
	public ManagementCompany(java.lang.String name,java.lang.String taxID,double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		properties = new Property[MAX_PROPERTY ];
		plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH );
		
	}
	
	public ManagementCompany(java.lang.String name,java.lang.String taxID,double mgmFee,int x,int y,int width,int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		properties = new Property[MAX_PROPERTY ];
		plot = new Plot(x,y,width,depth);
		
	}
	
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		properties = new Property[MAX_PROPERTY ];
		plot = new Plot( otherCompany.getPlot());
		
		 
	}
	
	public Plot getPlot() {
		return new Plot(plot);
		
	}
	
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
		
	}
	public String getName() {
		return name;
		
	}
	
	public int addProperty(Property property) {
	Plot point = new Plot(property.getPlot());
         if(property == null)
         return -2;
		 if(!this.plot.encompasses(point))
		 return-3;
		 for(int i = 0; i < MAX_PROPERTY; i++)
			{
				if(properties[i] != null)
				{
					Plot testPlot = new Plot(properties[i].getPlot());
					if(point.overlaps(testPlot))
						return -4;
				}
			}
			for(int i = 0; i < MAX_PROPERTY; i++)
			{
				if(properties[i] == null)
				{
					properties[i] = property;
					return i;
				}
			}
          return -1;
         
	}
	
	public int addProperty(String name,String city,double rent,String owner) {
		Property property = new Property(name,city,rent,owner);
		Plot point = new Plot(property.getPlot());
        if(property == null)
        return -2;
		 if(!this.plot.encompasses(point))
		 return-3;
		 for(int i = 0; i < MAX_PROPERTY; i++)
			{
				if(properties[i] != null)
				{
					Plot testPlot = new Plot(properties[i].getPlot());
					if(point.overlaps(testPlot))
						return -4;
				}
			}
			for(int i = 0; i < MAX_PROPERTY; i++)
			{
				if(properties[i] == null)
				{
					properties[i] = property;
					return i;
				}
			}
         return -1;
	}
	
	public int addProperty(String name,String city,double rent,String owner,int x,int y,int width,int depth) {
		Property property = new Property(name,city,rent,owner,x,y,width,depth);
		Plot point = new Plot(property.getPlot());
        if(property == null)
        return -2;
		 if(!this.plot.encompasses(point))
		 return-3;
		 for(int i = 0; i < MAX_PROPERTY; i++)
			{
				if(properties[i] != null)
				{
					Plot testPlot = new Plot(properties[i].getPlot());
					if(point.overlaps(testPlot))
						return -4;
				}
			}
			for(int i = 0; i < MAX_PROPERTY; i++)
			{
				if(properties[i] == null)
				{
					properties[i] = property;
					return i;
				}
			}
         return -1;
	}
	
	public double totalRent() {
		double totalRent = 0;
		for(int i = 0; i < MAX_PROPERTY; i++ ) {
			if(properties[i] != null)
			totalRent += properties[i].getRentAmount();
			
		}
		return totalRent;
	}
	
	public String maxRentProp() {
		return properties[maxRentPropertyIndex()].toString();
		
	}
	
	public int maxRentPropertyIndex() {
		int MaxProp = 0;
		for(int i = 1; i < MAX_PROPERTY; i++ ) {
			if(properties[i] != null) {
				if(properties[i].getRentAmount() > properties[MaxProp].getRentAmount()) 
					MaxProp = i;
			}
		}
		 
		return MaxProp;
		
		
	}
	
	public java.lang.String displayPropertyAtIndex(int i){
		return properties[i].toString();
		
	}
	
	public java.lang.String toString(){
		double totalMgmFee = (totalRent() * mgmFeePer) / 100.0;
		String str = "List of properties for " + name + ", taxID: " + taxID + "\n"
				   + "______________________________________________________\n";
		for(int i = 0; i < MAX_PROPERTY; i++)
		{
			if(properties[i] != null)
				str += properties[i].toString();
		}
		str += String.format("______________________________________________________\n"
						+    "total management Fee: %.1f", totalMgmFee);
		return str;

	}
	
	
	
	
	
	
}
