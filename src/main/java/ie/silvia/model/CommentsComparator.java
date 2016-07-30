package ie.silvia.model;

import java.util.Comparator;

public class CommentsComparator implements Comparator<Comments>{

	@Override
	public int compare(Comments o1, Comments o2) {
		if(o1.getId() > o2.getId())
			return 1;
		if(o1.getId() < o2.getId())
			return -1;
		return 0;
	}

	
}
