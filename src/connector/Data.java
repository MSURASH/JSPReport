package connector;

public class Data {

	private int doco;
	private int lnid;
	private String team;
	private String city;
	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Data(int doco, int lnid, String team, String city) {
		super();
		this.doco = doco;
		this.lnid = lnid;
		this.team = team;
		this.city = city;
	}
	public int getDoco() {
		return doco;
	}
	public void setDoco(int doco) {
		this.doco = doco;
	}
	public int getLnid() {
		return lnid;
	}
	public void setLnid(int lnid) {
		this.lnid = lnid;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Data [doco=" + doco + ", lnid=" + lnid + ", team=" + team + ", city=" + city + "]";
	}
	
	
	
}
