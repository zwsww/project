package com.neu.mapper;

import com.neu.po.DepartMent;
import com.neu.po.DepartMentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartMentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated Wed Oct 14 09:43:45 CST 2020
     */
    long countByExample(DepartMentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated Wed Oct 14 09:43:45 CST 2020
     */
    int deleteByExample(DepartMentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated Wed Oct 14 09:43:45 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated Wed Oct 14 09:43:45 CST 2020
     */
    int insert(DepartMent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated Wed Oct 14 09:43:45 CST 2020
     */
    int insertSelective(DepartMent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated Wed Oct 14 09:43:45 CST 2020
     */
    List<DepartMent> selectByExample(DepartMentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated Wed Oct 14 09:43:45 CST 2020
     */
    DepartMent selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated Wed Oct 14 09:43:45 CST 2020
     */
    int updateByExampleSelective(@Param("record") DepartMent record, @Param("example") DepartMentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated Wed Oct 14 09:43:45 CST 2020
     */
    int updateByExample(@Param("record") DepartMent record, @Param("example") DepartMentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated Wed Oct 14 09:43:45 CST 2020
     */
    int updateByPrimaryKeySelective(DepartMent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated Wed Oct 14 09:43:45 CST 2020
     */
    int updateByPrimaryKey(DepartMent record);
    
    List<DepartMent> getAll();
}