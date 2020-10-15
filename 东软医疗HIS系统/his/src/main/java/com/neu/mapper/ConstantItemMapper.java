package com.neu.mapper;

import com.neu.po.ConstantItem;
import com.neu.po.ConstantItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConstantItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table constantitem
     *
     * @mbg.generated Fri Oct 09 09:18:16 CST 2020
     */
    long countByExample(ConstantItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table constantitem
     *
     * @mbg.generated Fri Oct 09 09:18:16 CST 2020
     */
    int deleteByExample(ConstantItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table constantitem
     *
     * @mbg.generated Fri Oct 09 09:18:16 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table constantitem
     *
     * @mbg.generated Fri Oct 09 09:18:16 CST 2020
     */
    int insert(ConstantItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table constantitem
     *
     * @mbg.generated Fri Oct 09 09:18:16 CST 2020
     */
    int insertSelective(ConstantItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table constantitem
     *
     * @mbg.generated Fri Oct 09 09:18:16 CST 2020
     */
    List<ConstantItem> selectByExample(ConstantItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table constantitem
     *
     * @mbg.generated Fri Oct 09 09:18:16 CST 2020
     */
    ConstantItem selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table constantitem
     *
     * @mbg.generated Fri Oct 09 09:18:16 CST 2020
     */
    int updateByExampleSelective(@Param("record") ConstantItem record, @Param("example") ConstantItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table constantitem
     *
     * @mbg.generated Fri Oct 09 09:18:16 CST 2020
     */
    int updateByExample(@Param("record") ConstantItem record, @Param("example") ConstantItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table constantitem
     *
     * @mbg.generated Fri Oct 09 09:18:16 CST 2020
     */
    int updateByPrimaryKeySelective(ConstantItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table constantitem
     *
     * @mbg.generated Fri Oct 09 09:18:16 CST 2020
     */
    int updateByPrimaryKey(ConstantItem record);
	
	List<ConstantItem> getAll();
	
	List<ConstantItem> getSex();
	
	List<ConstantItem> getCharge();
}