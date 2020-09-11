package com.example.m2e_user_allocation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.m2e_user_allocation.entity.SysUser;
import com.util.Result;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @Author scott
 * @since 2018-12-20
 */
@Repository
public interface ISysUserService extends IService<SysUser> {
	
	public SysUser getUserByName(String username);
	
//	/**
//	 * 添加用户和用户角色关系
//	 * @param user
//	 * @param roles
//	 */
//	public void addUserWithRole(SysUser user, String roles);
//
//
//	/**
//	 * 修改用户和用户角色关系
//	 * @param user
//	 * @param roles
//	 */
//	public void editUserWithRole(SysUser user, String roles);
//
//	/**
//	 * 获取用户的授权角色
//	 * @param username
//	 * @return
//	 */
//	public List<String> getRole(String username);
//
//	/**
//	  * 查询用户信息包括 部门信息
//	 * @param username
//	 * @return
//	 */
////	public SysUserCacheInfo getCacheUser(String username);
//
//	/**
//	 * 根据部门Id查询
//	 * @param
//	 * @return
//	 */
//	public IPage<SysUser> getUserByDepId(Page<SysUser> page, String departId, String username);
//
//	/**
//	 * 根据角色Id查询
//	 * @param
//	 * @return
//	 */
//	public IPage<SysUser> getUserByRoleId(Page<SysUser> page, String roleId, String username);
//
//	/**
//	 * 通过用户名获取用户角色集合
//	 *
//	 * @param username 用户名
//	 * @return 角色集合
//	 */
//	Set<String> getUserRolesSet(String username);
//
//	/**
//	 * 通过用户名获取用户权限集合
//	 *
//	 * @param username 用户名
//	 * @return 权限集合
//	 */
//	Set<String> getUserPermissionsSet(String username);
//
//	/**
//	 * 根据用户名设置部门ID
//	 * @param username
//	 * @param orgCode
//	 */
//	void updateUserDepart(String username, String orgCode);
//
//	/**
//	 * 根据手机号获取用户名和密码
//	 */
//	public SysUser getUserByPhone(String phone);
//
//
//	/**
//	 * 根据邮箱获取用户
//	 */
//	public SysUser getUserByEmail(String email);
//
//
//	/**
//	 * 添加用户和用户部门关系
//	 * @param user
//	 * @param selectedParts
//	 */
//	void addUserWithDepart(SysUser user, String selectedParts);
//
//	/**
//	 * 编辑用户和用户部门关系
//	 * @param user
//	 * @param departs
//	 */
//	void editUserWithDepart(SysUser user, String departs);
	
	/**
	   * 校验用户是否有效
	 * @param sysUser
	 * @return
	 */
	Result checkUserIsEffective(SysUser sysUser);
	
//	/**add by qihongyan 2019-09-27
//	   * 根据用户账号名获取用户真实姓名
//	 * @param usernamelist：用户账号名称集合
//	 * @return 用户的真实姓名集合
//	 */
//	public List<String> getRealNamesByNames(List<String> usernamelist);
//	/**add by qihongyan 2019-09-27
//	   * 根据用户账号名获取用户真实姓名
//	 * @param username：用户账号名称
//	 * @return 用户的真实姓名
//	 */
//	public String getRealNameByName(String username);
//
//	/**
//	 * 根据部门Id或人员名称查询
//	 * @param
//	 * @return
//	 */
//	public SysUser getUserByOrgDepIdOrname(String departId, String name);
//
//
//	/**add by tianlve 2019-12-23
//	   * 根据用户账号名获取用户真实姓名
//	 * @param userId：用户主键ID
//	 * @return 用户的真实姓名
//	 */
//	public String getRealNameById(String userId);
	

}
