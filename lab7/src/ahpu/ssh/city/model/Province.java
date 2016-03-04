package ahpu.ssh.city.model;

import java.util.Set;

/**
 * Province entity. @author MyEclipse Persistence Tools
 */
public class Province extends AbstractProvince implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Province() {
	}

	/** full constructor */
	public Province(String name, Set cities) {
		super(name, cities);
	}

}
