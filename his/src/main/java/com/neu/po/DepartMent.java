package com.neu.po;

public class DepartMent {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department.ID
     *
     * @mbg.generated Fri Oct 09 16:09:37 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department.DeptCode
     *
     * @mbg.generated Fri Oct 09 16:09:37 CST 2020
     */
    private String deptcode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department.DeptName
     *
     * @mbg.generated Fri Oct 09 16:09:37 CST 2020
     */
    private String deptname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department.DeptCategoryID
     *
     * @mbg.generated Fri Oct 09 16:09:37 CST 2020
     */
    private ConstantItem DeptCategory;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department.DeptType
     *
     * @mbg.generated Fri Oct 09 16:09:37 CST 2020
     */
    private Integer depttype;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department.DelMark
     *
     * @mbg.generated Fri Oct 09 16:09:37 CST 2020
     */
    private Integer delmark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.ID
     *
     * @return the value of department.ID
     *
     * @mbg.generated Fri Oct 09 16:09:37 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.ID
     *
     * @param id the value for department.ID
     *
     * @mbg.generated Fri Oct 09 16:09:37 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.DeptCode
     *
     * @return the value of department.DeptCode
     *
     * @mbg.generated Fri Oct 09 16:09:37 CST 2020
     */
    public String getDeptcode() {
        return deptcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.DeptCode
     *
     * @param deptcode the value for department.DeptCode
     *
     * @mbg.generated Fri Oct 09 16:09:37 CST 2020
     */
    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.DeptName
     *
     * @return the value of department.DeptName
     *
     * @mbg.generated Fri Oct 09 16:09:37 CST 2020
     */
    public String getDeptname() {
        return deptname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.DeptName
     *
     * @param deptname the value for department.DeptName
     *
     * @mbg.generated Fri Oct 09 16:09:37 CST 2020
     */
    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.DeptCategoryID
     *
     * @return the value of department.DeptCategoryID
     *
     * @mbg.generated Fri Oct 09 16:09:37 CST 2020
     */
    public ConstantItem getDeptCategory() {
        return DeptCategory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.DeptCategoryID
     *
     * @param DeptCategory the value for department.DeptCategoryID
     *
     * @mbg.generated Fri Oct 09 16:09:37 CST 2020
     */
    public void setDeptCategory(ConstantItem DeptCategory) {
        this.DeptCategory = DeptCategory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.DeptType
     *
     * @return the value of department.DeptType
     *
     * @mbg.generated Fri Oct 09 16:09:37 CST 2020
     */
    public Integer getDepttype() {
        return depttype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.DeptType
     *
     * @param depttype the value for department.DeptType
     *
     * @mbg.generated Fri Oct 09 16:09:37 CST 2020
     */
    public void setDepttype(Integer depttype) {
        this.depttype = depttype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.DelMark
     *
     * @return the value of department.DelMark
     *
     * @mbg.generated Fri Oct 09 16:09:37 CST 2020
     */
    public Integer getDelmark() {
        return delmark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.DelMark
     *
     * @param delmark the value for department.DelMark
     *
     * @mbg.generated Fri Oct 09 16:09:37 CST 2020
     */
    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}