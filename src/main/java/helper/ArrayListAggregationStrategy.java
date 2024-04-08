
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.ArrayList;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
/**
 * An aggregation strategy that stacks body of messages to an ArrayList
 * @author Arnaud Marchand
 */
public class ArrayListAggregationStrategy implements AggregationStrategy {

    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) 
	{
		Object newBody = newExchange.getIn().getBody();
		ArrayList<Object> list = null;
		
        if (oldExchange == null) 
		{
			list = new ArrayList<Object>();
			list.add(newBody);
			newExchange.getIn().setBody(list);
			return newExchange;
        } 
		else 
		{
	        list = oldExchange.getIn().getBody(ArrayList.class);
			list.add(newBody);
			return oldExchange;
		}
    }
}
