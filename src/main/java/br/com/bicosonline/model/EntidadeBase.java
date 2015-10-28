package br.com.bicosonline.model;

import java.io.Serializable;

import org.springframework.data.jpa.domain.AbstractPersistable;

public abstract class EntidadeBase<PK extends Serializable> extends
		AbstractPersistable<PK> implements Serializable {

	private static final long serialVersionUID = -5377726703339445533L;

	@Override
	public void setId(PK id) {
		super.setId(id);
	}

}
