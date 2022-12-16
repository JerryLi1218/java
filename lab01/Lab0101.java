package lab01;
/*
 * 之前想过用javafx中的vbox实现这个表格，但那样就把这个简单的事情搞得太复杂了
 */

import java.util.*;

public class Lab0101{
	
    public static void main(String[] args) {
        int[] incomeLimits = {0,36000,144000,300000,420000,660000,960000,Integer.MAX_VALUE};
        double[] taxLimits = new double[8];
        double[] taxRate= {0,0.03,0.1,0.2,0.25,0.3,0.35,0.45};
        for(int i=1;i<taxLimits.length - 1;i++) {
        	taxLimits[i] = taxLimits[i-1] +(incomeLimits[i] - incomeLimits[i - 1]) * taxRate[i];
        }
        taxLimits[taxLimits.length - 1] = Double.MAX_VALUE; 
        
        //用列表接收表格
        List<String[]>taxTable = new ArrayList<String[]>(100);
        //使用\t进行强制对齐
        String[] headFrontWord = {"Annual Taxable\t","Annual Tax\t","Monthly Taxable\t","Monthly Tax\n"};
        String[] headNextWord = {"    Income\t","\t\t","    Income\t","\t\n"};
        taxTable.add(headFrontWord);
        taxTable.add(headNextWord);
        
        String[] result = null;
        int temp = 0;
        double tax = 0;
        
        for(int i = 60000,j = i / 12 ; i <= 1000000 ; i += 10000 , j = i / 12) {
        	result = new String[4];
        	/*
        	 * result[0] -> 实际年收入 
        	 * result[1] -> 实际年收税
        	 * result[2] -> 平均月收入
        	 * result[3] -> 平均月收费
        	 */
        	
        	temp=i - 60000;
        	result[0] = i + "\t\t";
        	//计算年税收
        	for(int k = 1;k < taxLimits.length ;k++) {
        		if(temp <= incomeLimits[0]) {
	        		//Math.round 四舍五入
	        		result[1] = Math.round(tax) + "\t\t";
	        		break;
        		}
        		//超过六万
        		if(temp <= incomeLimits[k]) {
        			tax = (taxLimits[k - 1] + (temp - incomeLimits[k - 1]) * taxRate[k]);
        			result[1] = Math.round(tax) + "\t\t";
        			break;
        		}
        	}
        	
        	result[2] = j + "\t\t";
        	result[3] = Math.round((tax/12)) + "\t\n";
        	taxTable.add(result);
        }
        //print taxTable
        for(String[] strings : taxTable) {
        	for(String string : strings) {
        		System.out.print(string);
        	}
        }
        
    }

} 