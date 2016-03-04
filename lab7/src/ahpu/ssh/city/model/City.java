package ahpu.ssh.city.model;

/**
 * City entity. @author MyEclipse Persistence Tools
 */
public class City extends AbstractCity implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public City() {
	}

	/** full constructor */
	public City(Province province, String name) {
		super(province, name);
	}

}
