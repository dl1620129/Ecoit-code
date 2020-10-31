package UserRank.Poisition.Api.object;

public class UserRankPositionObject {
	private long userId;
	private long userRankId;
	private long userPositionId;
	private long userPositionDangId;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getUserRankId() {
		return userRankId;
	}
	public void setUserRankId(long userRankId) {
		this.userRankId = userRankId;
	}
	public long getUserPositionId() {
		return userPositionId;
	}
	public void setUserPositionId(long userPositionId) {
		this.userPositionId = userPositionId;
	}
	public long getUserPositionDangId() {
		return userPositionDangId;
	}
	public void setUserPositionDangId(long userPositionDangId) {
		this.userPositionDangId = userPositionDangId;
	}
	public UserRankPositionObject(long userId, long userRankId, long userPositionId, long userPositionDangId) {
		super();
		this.userId = userId;
		this.userRankId = userRankId;
		this.userPositionId = userPositionId;
		this.userPositionDangId = userPositionDangId;
	}
	public UserRankPositionObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
