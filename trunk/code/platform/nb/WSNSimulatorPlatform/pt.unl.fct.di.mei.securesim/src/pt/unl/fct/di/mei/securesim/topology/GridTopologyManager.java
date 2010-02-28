/**
 * 
 */
package pt.unl.fct.di.mei.securesim.topology;

import java.awt.Rectangle;
import java.util.ArrayList;



import pt.unl.fct.di.mei.securesim.core.nodes.Node;

/**
 * @author posilva
 * 
 */
public class GridTopologyManager extends TopologyManager {
	/**
	 * 
	 */
	public GridTopologyManager() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pt.unl.fct.di.mei.securesim.configuration.ConfigurableObject#init()
	 */
	@Override
	protected void init() {

	}

	public int mdc( int x, int y ){
        if(x == y){
            return x;
        }
        else if( y > x ){
            return mdc( x, y-x );
        }
        else if( x > y ){
            return mdc( x - y, y );
        }
        return 0;
    }

    @Override
    public ArrayList<Node> apply(Rectangle rect, ArrayList<Node> nodes) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
