package com.example.m2e_user_allocation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.m2e_user_allocation.Entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @Author scott
 * @since 2018-12-20
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
	/**
	  * 通过用户账号查询用户信息
	 * @param username
	 * @return
	 */
	public SysUser getUserByName(@Param("username") String username);
	
	/**add by qihongan 2019--9-27
	  * 根据用户名集合查询用户真实姓名
	 * @param usernamelist
	 * @return
	 */
	public List<String> getRealNamesByNames(@Param("usernamelist") List<String> usernamelist);
	
	/**add by qihongyan 2019-09-27 
	   * 根据用户账号名获取用户真实姓名
	 * @param username：用户账号名称
	 * @return 用户的真实姓名
	 */
	public String getRealNameByName(@Param("username") String username);

	/**
	 *  根据部门Id查询用户信息
	 * @param page
	 * @param departId
	 * @return
	 */
	IPage<SysUser> getUserByDepId(Page page, @Param("departId") String departId, @Param("username") String username);

	/**
	 * 根据角色Id查询用户信息
	 * @param page
	 * @param
	 * @return
	 */
	IPage<SysUser> getUserByRoleId(Page page, @Param("roleId") String roleId, @Param("username") String username);
	
	/**
	 * 根据用户名设置部门ID
	 * @param username
	 * @param orgCode
	 */
	void updateUserDepart(@Param("username") String username, @Param("orgCode") String orgCode);
	
	/**
	 * 根据手机号查询用户信息
	 * @param phone
	 * @return
	 */
	public SysUser getUserByPhone(@Param("phone") String phone);
	
	
	/**
	 * 根据邮箱查询用户信息
	 * @param email
	 * @return
	 */
	public SysUser getUserByEmail(@Param("email") String email);
	
	/**
	   *    根据用户id及名称获取用户数据集合
	 * @param ids：用户id集合
	 * @param name：查询用户名称参数
	 * @return 查找到的用户信息集合
	 */
	public List<SysUser> queryUserByUserIdsAndName(@Param("name") String name, @Param("ids") String ids, @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);

	
	
	/**
	 *    根据电站及名称获取用户数据集合
	 * @param ids：用户id集合
	 * @param name：查询用户名称参数
	 * @return 查找到的用户信息集合
	 */
	public List<SysUser> queryUserByOrgUserIdsAndName(@Param("name") String name, @Param("subOrgId") String subOrgId, @Param("ids") String ids, @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);
	
	/**
	 * 根据用户id及名称获取用户数据集合
	 * @param ids：用户id集合
	 * @param name：查询用户名称参数
	 * @return 查找到的用户信息集合
	 */
	public List<SysUser> queryUserByIdsAndName(@Param("name") String name, List<String> ids, @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);
	
	/**
	 *  根据部门Id或名字查询用户信息
	 * @param name
	 * @param departIds
	 * @return
	 */
	
	public List<SysUser> getUserByOrgDepIdOrname(@Param("departIds") List<String> departIds, @Param("name") String name);

	/**
	   *    根据用户id获取用户数据集合
	 * @param usernamelist：用户id集合
	 * @return 查找到的用户信息集合
	 */
	public List<SysUser> queryUserByUserIds(@Param("usernamelist") List<String> usernamelist);
	
	/**add by tianlve 2019-12-23 
	   * 根据用户账号名获取用户真实姓名
	 * @param userId：用户账号名称
	 * @return 用户的真实姓名
	 */
	public String getRealNameById(@Param("userId") String userId);
	/**
	 * 根据用户id及名称获取用户数据集合
	 * @param listUserIds：用户id集合
	 * @return 查找到的用户信息集合
	 */
	public List<SysUser> queryUserByIdsAndNames(@Param("listUserIds") List<String> listUserIds);
}
