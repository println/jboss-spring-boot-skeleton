package br.jus.tjerj.skeleton.support.segweb;

public class SegwebToken {
	private SegwebUser user;
	private SegwebCredentials credentials;

	public SegwebToken() {
	}

	public SegwebToken(SegwebUser user, SegwebCredentials credentials) {
		super();
		this.user = user;
		this.credentials = credentials;
	}

	public SegwebUser getUser() {
		return user;
	}

	public void setUser(SegwebUser user) {
		this.user = user;
	}

	public SegwebCredentials getCredentials() {
		return credentials;
	}

	public void setCredentials(SegwebCredentials credentials) {
		this.credentials = credentials;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((credentials == null) ? 0 : credentials.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SegwebToken other = (SegwebToken) obj;
		if (credentials == null) {
			if (other.credentials != null)
				return false;
		} else if (!credentials.equals(other.credentials))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
