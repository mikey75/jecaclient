package net.wirelabs.jecaclient.core.ladspa;
/**
 * Ladspa plugin operator 
 * based on eca-operator.h in ecasound 
 * @author Michał Szwaczko
 *
 */
  
  

public class LadspaPluginOperator {
	
	/**
     * Parameter description. 
     */
	
	//private String shortname	//0
	private String description; //1
	
	/**
     * A reasonable default value.
     */
	private Double defaultvalue; //2
	/**
     * Is parameter bounded above?
     */
	private boolean boundedAbove; //3
	/**
     * If 'bounded_above', contains the bound value.
     */
	private Double upperBound; //4
	/**
     * Is parameter bounded below?
     */
	private boolean boundedBelow; //5
	/**
     * If 'bounded_below', contains the bound value.
     */
	private Double lowerBound; //6

	
	/**
     * Whether parameter should be treated as a boolean toggle?
     * Parameter value of less than or equal to zero (x <= 0) should
     * be considered `off' or `false,' and value above zero (x > 0) 
     * should be considered `on' or `true.
     */
	private boolean toggled;  
	/** 
     * Parameter value is best represented as an integer.
     */
	private boolean integer; 

    /** 
     * Value range from lower_bound to upper_bound is best 
     * represented on a  logarithmic scale.
     */
	private boolean logarithmic; 
	
	/**
     * Parameter value can change during operation. This 
     * makes it possible to have separate parameters for
     * storing processing results.
     */
	private boolean output;

	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getDefaultvalue() {
		return defaultvalue;
	}

	public void setDefaultvalue(Double defaultvalue) {
		this.defaultvalue = defaultvalue;
	}

	public boolean isBoundedAbove() {
		return boundedAbove;
	}

	public void setBoundedAbove(boolean boundedAbove) {
		this.boundedAbove = boundedAbove;
	}

	public Double getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(Double upperBound) {
		this.upperBound = upperBound;
	}

	public boolean isBoundedBelow() {
		return boundedBelow;
	}

	public void setBoundedBelow(boolean boundedBelow) {
		this.boundedBelow = boundedBelow;
	}

	public Double getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(Double lowerBound) {
		this.lowerBound = lowerBound;
	}

	public boolean isToggled() {
		return toggled;
	}

	public void setToggled(boolean toggled) {
		this.toggled = toggled;
	}

	public boolean isInteger() {
		return integer;
	}

	public void setInteger(boolean integer) {
		this.integer = integer;
	}

	public boolean isLogarithmic() {
		return logarithmic;
	}

	public void setLogarithmic(boolean logarithmic) {
		this.logarithmic = logarithmic;
	}

	public boolean isOutput() {
		return output;
	}

	public void setOutput(boolean output) {
		this.output = output;
	}  
	
	
	
}
