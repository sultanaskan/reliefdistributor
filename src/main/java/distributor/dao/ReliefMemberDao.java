package distributor.dao;

import java.util.ArrayList;

import distributor.entity.ReliefMember;
import distributor.entity.User;


public interface ReliefMemberDao {
	public boolean addMember(ReliefMember member);
	public boolean updateMember(ReliefMember member);
	public ReliefMember findMember(ReliefMember member_id);
	
	public ReliefMember findRootHolder(ReliefMember member_id);
	public ArrayList<String> findAllSubHolderId(ReliefMember member_id);
	
	public ArrayList<String> findAllSubMemberId(ReliefMember member_id);
	public ArrayList<String> findAllSubNonRecivedMemberId(ReliefMember member_id);
	public ArrayList<String> findAllSubRecivedMemberId(ReliefMember member_id);
	
	public ArrayList<String> findAllReliefId(User user);
	

}
