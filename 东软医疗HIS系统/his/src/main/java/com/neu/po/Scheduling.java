package com.neu.po;

import java.util.Date;

public class Scheduling {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scheduling.ID
     *
     * @mbg.generated Thu Oct 15 14:11:44 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scheduling.SchedDate
     *
     * @mbg.generated Thu Oct 15 14:11:44 CST 2020
     */
    private Date scheddate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scheduling.DeptID
     *
     * @mbg.generated Thu Oct 15 14:11:44 CST 2020
     */
    private DepartMent DepartMent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scheduling.UserID
     *
     * @mbg.generated Thu Oct 15 14:11:44 CST 2020
     */
    private User User;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scheduling.Noon
     *
     * @mbg.generated Thu Oct 15 14:11:44 CST 2020
     */
    private String noon;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scheduling.RuleID
     *
     * @mbg.generated Thu Oct 15 14:11:44 CST 2020
     */
    private Rule Rule;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scheduling.DelMark
     *
     * @mbg.generated Thu Oct 15 14:11:44 CST 2020
     */
    private Integer delmark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scheduling.ID
     *
     * @return the value of scheduling.ID
     *
     * @mbg.generated Thu Oct 15 14:11:44 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scheduling.ID
     *
     * @param id the value for scheduling.ID
     *
     * @mbg.generated Thu Oct 15 14:11:44 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scheduling.SchedDate
     *
     * @return the value of scheduling.SchedDate
     *
     * @mbg.generated Thu Oct 15 14:11:44 CST 2020
     */
    public Date getScheddate() {
        return scheddate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scheduling.SchedDate
     *
     * @param scheddate the value for scheduling.SchedDate
     *
     * @mbg.generated Thu Oct 15 14:11:44 CST 2020
     */
    public void setScheddate(Date scheddate) {
        this.scheddate = scheddate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scheduling.DeptID
     *
     * @return the value of scheduling.DeptID
     *
     * @mbg.generated Thu Oct 15 14:11:44 CST 2020
     */
    public DepartMent getDepartMent() {
        return DepartMent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scheduling.DeptID
     *
     * @param DepartMent the value for scheduling.DeptID
     *
     * @mbg.generated Thu Oct 15 14:11:44 CST 2020
     */
    public void setDepartMent(DepartMent DepartMent) {
        this.DepartMent = DepartMent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scheduling.UserID
     *
     * @return the value of scheduling.UserID
     *
     * @mbg.generated Thu Oct 15 14:11:44 CST 2020
     */
    public User getUser() {
        return User;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scheduling.UserID
     *
     * @param User the value for scheduling.UserID
     *
     * @mbg.generated Thu Oct 15 14:11:44 CST 2020
     */
    public void setUser(User User) {
        this.User = User;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scheduling.Noon
     *
     * @return the value of scheduling.Noon
     *
     * @mbg.generated Thu Oct 15 14:11:44 CST 2020
     */
    public String getNoon() {
        return noon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scheduling.Noon
     *
     * @param noon the value for scheduling.Noon
     *
     * @mbg.generated Thu Oct 15 14:11:44 CST 2020
     */
    public void setNoon(String noon) {
        this.noon = noon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scheduling.RuleID
     *
     * @return the value of scheduling.RuleID
     *
     * @mbg.generated Thu Oct 15 14:11:44 CST 2020
     */
    public Rule getRule() {
        return Rule;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scheduling.RuleID
     *
     * @param Rule the value for scheduling.RuleID
     *
     * @mbg.generated Thu Oct 15 14:11:44 CST 2020
     */
    public void setRule(Rule Rule) {
        this.Rule = Rule;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scheduling.DelMark
     *
     * @return the value of scheduling.DelMark
     *
     * @mbg.generated Thu Oct 15 14:11:44 CST 2020
     */
    public Integer getDelmark() {
        return delmark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scheduling.DelMark
     *
     * @param delmark the value for scheduling.DelMark
     *
     * @mbg.generated Thu Oct 15 14:11:44 CST 2020
     */
    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}