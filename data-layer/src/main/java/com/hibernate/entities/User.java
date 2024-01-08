package com.hibernate.entities;

import javax.persistence.*;

@Entity
@Table(name = "user_details") //entities class is detached from actual persistence table
public class User {

    //natural key - user passed id
    //surrogate key - hibernate managed id
    @javax.persistence.Id
    @GeneratedValue
    private int userId;

    @Column(name = "user_name")
    private String name;

    //@OneToOne(cascade= {CascadeType.ALL})
    @OneToOne //need to save User and Vehicle explicitly
    private Vehicle vehicle;
	
	/*
	@Temporal(TemporalType.DATE)
	private Date joinDate; //otherway is to make it static
	private int age;
	
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="HOME_CITY_STREET")),
		@AttributeOverride(name="city", column=@Column(name="HOME_CITY_NAME")),
		@AttributeOverride(name="state", column=@Column(name="HOME_CITY_STATE")),
		@AttributeOverride(name="pincode", column=@Column(name="HOME_CITY_PINCODE"))
	})
	private StudentAddress homeAddress;
	
	private StudentAddress officeAddress;

	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="USER_ADDRESS")
	@GenericGenerator(name="hilo-gen", strategy="hilo")
	//@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type = "long"))
	private Collection<StudentAddress> addressesSet = new HashSet<>();
	*/

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return this.userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the vehicle
     */
    public Vehicle getVehicle() {
        return this.vehicle;
    }

    /**
     * @param vehicle the vehicle to set
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [userId=");
        builder.append(this.userId);
        builder.append(", name=");
        builder.append(this.name);
        builder.append("]");
        return builder.toString();
    }
}