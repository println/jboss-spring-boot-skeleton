package br.jus.tjerj.skeleton.support.segweb;

import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

public class SegwebAuthentication extends PreAuthenticatedAuthenticationToken {

	private static final long serialVersionUID = -119201005148377935L;

	public SegwebAuthentication(SegwebUser user, SegwebCredentials credentials) {
		super(user, credentials);
	}

	public SegwebAuthentication(SegwebCredentials credentials) {
		this(null, credentials);
	}

	public SegwebAuthentication(SegwebUser user) {
		this(user, null);
	}

	public SegwebAuthentication(SegwebToken token) {
		this(token.getUser(), token.getCredentials());
	}

	@Override
	public SegwebUser getPrincipal() {
		if (super.getPrincipal() == null) {
			return null;
		}
		return (SegwebUser) super.getPrincipal();
	}

	@Override
	public SegwebCredentials getCredentials() {
		if (super.getCredentials() == null) {
			return null;
		}
		return (SegwebCredentials) super.getCredentials();
	}
	
	public SegwebToken getToken() {
		return new SegwebToken(getPrincipal(), getCredentials());
	}

}
