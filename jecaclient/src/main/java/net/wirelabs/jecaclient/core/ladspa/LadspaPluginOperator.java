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
	private boolean bounded_above; //3
	/**
     * If 'bounded_above', contains the bound value.
     */
	private Double upper_bound; //4
	/**
     * Is parameter bounded below?
     */
	private boolean bounded_below; //5
	/**
     * If 'bounded_below', contains the bound value.
     */
	private Double lower_bound; //6

	
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

	public boolean isBounded_above() {
		return bounded_above;
	}

	public void setBounded_above(boolean bounded_above) {
		this.bounded_above = bounded_above;
	}

	public Double getUpper_bound() {
		return upper_bound;
	}

	public void setUpper_bound(Double upper_bound) {
		this.upper_bound = upper_bound;
	}

	public boolean isBounded_below() {
		return bounded_below;
	}

	public void setBounded_below(boolean bounded_below) {
		this.bounded_below = bounded_below;
	}

	public Double getLower_bound() {
		return lower_bound;
	}

	public void setLower_bound(Double lower_bound) {
		this.lower_bound = lower_bound;
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
