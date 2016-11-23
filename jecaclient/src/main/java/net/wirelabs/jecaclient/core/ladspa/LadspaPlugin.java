package net.wirelabs.jecaclient.core.ladspa;

import java.util.ArrayList;
import java.util.List;

public class LadspaPlugin {

	private String shortName;
	private String name;
	private String label;
	private int operator_count = 0;
	private List<LadspaPluginOperator> operators = new ArrayList();
	
	public LadspaPlugin(){
		
	}
	
	
	public LadspaPlugin(String line_to_parse) {
		
		//System.out.println(line_to_parse);
		
		if ( !line_to_parse.isEmpty() ) {
		String[] s = line_to_parse.split(",");
		
		
			shortName = s[0];
			name = s[1];
			label = s[2];
			operator_count=Integer.parseInt(s[3]);
			
			if (operator_count > 0) {
				for (int i=0;i<operator_count;i++) {
					int ofs = i*11+4;				
					
					LadspaPluginOperator po = new LadspaPluginOperator();
					po.setDescription(s[ofs]);
					po.setDefaultvalue(Double.parseDouble(s[ofs+2]));
					
					// need to parse 'string=value' here
					//po.setBounded_above(Boolean.parseBoolean(s[ofs+3]));
					//po.setUpper_bound(Double.parseDouble(s[ofs+4]));
					
					//po.setBounded_below(Boolean.parseBoolean(s[ofs+5]));
					//po.setLower_bound(Double.parseDouble(s[ofs+6]));
					
					po.setToggled(Boolean.parseBoolean(s[ofs+7]));
					po.setInteger(Boolean.parseBoolean(s[ofs+8]));
					po.setLogarithmic(Boolean.parseBoolean(s[ofs+9]));
					operators.add(po);
					//po.setDefaultvalue(defaultvalue);
				
				}
			}
		}
		
		
		
	
	}


	public String getShortName() {
		return shortName;
	}


	public void setShortName(String shortName) {
		this.shortName = shortName;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public int getOperator_count() {
		return operator_count;
	}


	public void setOperator_count(int operator_count) {
		this.operator_count = operator_count;
	}


	public List<LadspaPluginOperator> getOperators() {
		return operators;
	}


	public void setOperators(List<LadspaPluginOperator> operators) {
		this.operators = operators;
	}
	
}
