package br.jus.tjerj.skeleton.configuration.security;

import br.jus.tjerj.skeleton.support.segweb.SegwebJwtTokenService;

public class JwtTokenServiceFactory {
	private static AbstractJwtTokenService instance;
	public static AbstractJwtTokenService getJwtTokenService(){
		if(instance ==  null) {
			instance = new SegwebJwtTokenService();
		}
		return instance;
	}
}
