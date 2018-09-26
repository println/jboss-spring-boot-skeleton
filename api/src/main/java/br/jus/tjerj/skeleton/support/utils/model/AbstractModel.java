package br.jus.tjerj.skeleton.support.utils.model;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractModel implements Serializable {

	private static final long serialVersionUID = -3395799298232751572L;

	public abstract Long getId();

	public abstract void setId(Long id);

	public abstract <T extends AbstractModel> ValidationModel<T> validate();

}
