package br.jus.tjerj.skeleton.webapp.auth;

import br.jus.tjerj.skeleton.webapp.auth.segweb.SegwebJwtTokenService;

public class JwtTokenServiceFactory {
	private static AbstractJwtTokenService instance;
	public static AbstractJwtTokenService getJwtTokenService(){
		if(instance ==  null) {
			instance = new SegwebJwtTokenService();
		}
		return instance;
	}
}
