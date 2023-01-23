package restAssuredOAuth;

public class MediaTypexwwwform {

	
	public String MediaFormat(String code) {
		
		return "grant_type=authorization_code&code="+code+"&redirect_uri=http://localhost:8180/auth/admin/master/console/&client_id=OAuth";
	}
}
