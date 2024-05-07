package distributor.dao;

import javax.servlet.http.Part;

import distributor.entity.Relief;


public interface ReliefDao {
	public boolean NewRelief(Relief relief);
	public boolean updateRelief(Relief relief);
	public Relief findRelief(Relief relief);

}
