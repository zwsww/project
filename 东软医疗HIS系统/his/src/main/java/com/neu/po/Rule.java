package com.neu.po;

public class Rule {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule.ID
     *
     * @mbg.generated Thu Oct 15 14:05:59 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule.RuleName
     *
     * @mbg.generated Thu Oct 15 14:05:59 CST 2020
     */
    private String rulename;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule.DeptID
     *
     * @mbg.generated Thu Oct 15 14:05:59 CST 2020
     */
    private DepartMent DepartMent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule.UserID
     *
     * @mbg.generated Thu Oct 15 14:05:59 CST 2020
     */
    private User User;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule.Week
     *
     * @mbg.generated Thu Oct 15 14:05:59 CST 2020
     */
    private String week;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule.DelMark
     *
     * @mbg.generated Thu Oct 15 14:05:59 CST 2020
     */
    private Integer delmark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule.ID
     *
     * @return the value of rule.ID
     *
     * @mbg.generated Thu Oct 15 14:05:59 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule.ID
     *
     * @param id the value for rule.ID
     *
     * @mbg.generated Thu Oct 15 14:05:59 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule.RuleName
     *
     * @return the value of rule.RuleName
     *
     * @mbg.generated Thu Oct 15 14:05:59 CST 2020
     */
    public String getRulename() {
        return rulename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule.RuleName
     *
     * @param rulename the value for rule.RuleName
     *
     * @mbg.generated Thu Oct 15 14:05:59 CST 2020
     */
    public void setRulename(String rulename) {
        this.rulename = rulename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule.DeptID
     *
     * @return the value of rule.DeptID
     *
     * @mbg.generated Thu Oct 15 14:05:59 CST 2020
     */
    public DepartMent getDepartMent() {
        return DepartMent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule.DeptID
     *
     * @param DepartMent the value for rule.DeptID
     *
     * @mbg.generated Thu Oct 15 14:05:59 CST 2020
     */
    public void setDepartMent(DepartMent DepartMent) {
        this.DepartMent = DepartMent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule.UserID
     *
     * @return the value of rule.UserID
     *
     * @mbg.generated Thu Oct 15 14:05:59 CST 2020
     */
    public User getUser() {
        return User;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule.UserID
     *
     * @param User the value for rule.UserID
     *
     * @mbg.generated Thu Oct 15 14:05:59 CST 2020
     */
    public void setUser(User User) {
        this.User = User;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule.Week
     *
     * @return the value of rule.Week
     *
     * @mbg.generated Thu Oct 15 14:05:59 CST 2020
     */
    public String getWeek() {
        return week;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule.Week
     *
     * @param week the value for rule.Week
     *
     * @mbg.generated Thu Oct 15 14:05:59 CST 2020
     */
    public void setWeek(String week) {
        this.week = week;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule.DelMark
     *
     * @return the value of rule.DelMark
     *
     * @mbg.generated Thu Oct 15 14:05:59 CST 2020
     */
    public Integer getDelmark() {
        return delmark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule.DelMark
     *
     * @param delmark the value for rule.DelMark
     *
     * @mbg.generated Thu Oct 15 14:05:59 CST 2020
     */
    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}