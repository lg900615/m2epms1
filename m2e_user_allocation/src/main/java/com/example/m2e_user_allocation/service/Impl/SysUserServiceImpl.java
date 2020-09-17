package com.example.m2e_user_allocation.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.m2e_user_allocation.entity.SysUser;
import com.example.m2e_user_allocation.mapper.SysUserMapper;
import com.example.m2e_user_allocation.service.ISysBaseAPI;
import com.example.m2e_user_allocation.service.ISysUserService;
import com.util.Result;
import enumInterface.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @Author: scott
 * @Date: 2018-12-20
 */
@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
	
	@Resource
	private SysUserMapper userMapper;
//	@Autowired
//	private SysPermissionMapper sysPermissionMapper;
//	@Autowired
//	private SysUserRoleMapper sysUserRoleMapper;
//	@Autowired
//	private SysUserDepartMapper sysUserDepartMapper;
	@Resource
	private ISysBaseAPI sysBaseAPI;
//	@Autowired
//	private SysDepartMapper sysDepartMapper;
	
	
	@Override
	public SysUser getUserByName(String username) {
		return userMapper.getUserByName(username);
	}
	
	
//	@Override
//	@Transactional
//	public void addUserWithRole(SysUser user, String roles) {
//		this.save(user);
//		if(oConvertUtils.isNotEmpty(roles)) {
//			String[] arr = roles.split(",");
//			for (String roleId : arr) {
//				SysUserRole userRole = new SysUserRole(user.getId(), roleId);
//				sysUserRoleMapper.insert(userRole);
//			}
//		}
//	}
//
//	@Override
//	@CacheEvict(value= CacheConstant.LOGIN_USER_RULES_CACHE, allEntries=true)
//	@Transactional
//	public void editUserWithRole(SysUser user, String roles) {
//		this.updateById(user);
//		//先删后加
//		sysUserRoleMapper.delete(new QueryWrapper<SysUserRole>().lambda().eq(SysUserRole::getUserId, user.getId()));
//		if(oConvertUtils.isNotEmpty(roles)) {
//			String[] arr = roles.split(",");
//			for (String roleId : arr) {
//				SysUserRole userRole = new SysUserRole(user.getId(), roleId);
//				sysUserRoleMapper.insert(userRole);
//			}
//		}
//	}
//
//
//	@Override
//	public List<String> getRole(String username) {
//		return sysUserRoleMapper.getRoleByUserName(username);
//	}
//
//	/**
//	 * 通过用户名获取用户角色集合
//	 * @param username 用户名
//     * @return 角色集合
//	 */
//	@Override
//	@Cacheable(value = CacheConstant.LOGIN_USER_RULES_CACHE,key = "'Roles_'+#username")
//	public Set<String> getUserRolesSet(String username) {
//		// 查询用户拥有的角色集合
//		List<String> roles = sysUserRoleMapper.getRoleByUserName(username);
//		log.info("-------通过数据库读取用户拥有的角色Rules------username： " + username + ",Roles size: " + (roles == null ? 0 : roles.size()));
//		return new HashSet<>(roles);
//	}
//
//	/**
//	 * 通过用户名获取用户权限集合
//	 *
//	 * @param username 用户名
//	 * @return 权限集合
//	 */
//	@Override
//	@Cacheable(value = CacheConstant.LOGIN_USER_RULES_CACHE,key = "'Permissions_'+#username")
//	public Set<String> getUserPermissionsSet(String username) {
//		Set<String> permissionSet = new HashSet<>();
//		List<SysPermission> permissionList = sysPermissionMapper.queryByUser(username);
//		for (SysPermission po : permissionList) {
////			// TODO URL规则有问题？
////			if (oConvertUtils.isNotEmpty(po.getUrl())) {
////				permissionSet.add(po.getUrl());
////			}
//			if (oConvertUtils.isNotEmpty(po.getPerms())) {
//				permissionSet.add(po.getPerms());
//			}
//		}
//		log.info("-------通过数据库读取用户拥有的权限Perms------username： "+ username+",Perms size: "+ (permissionSet==null?0:permissionSet.size()) );
//		return permissionSet;
//	}
//
//	@Override
//	public SysUserCacheInfo getCacheUser(String username) {
//		SysUserCacheInfo info = new SysUserCacheInfo();
//		info.setOneDepart(true);
////		SysUser user = userMapper.getUserByName(username);
////		info.setSysUserCode(user.getUsername());
////		info.setSysUserName(user.getRealname());
//
//
//		LoginUser user = sysBaseAPI.getUserByName(username);
//		if(user!=null) {
//			info.setSysUserCode(user.getUsername());
//			info.setSysUserName(user.getRealname());
//			info.setSysOrgCode(user.getOrgCode());
//		}
//
//		//多部门支持in查询
//		List<SysDepart> list = sysDepartMapper.queryUserDeparts(user.getId());
//		List<String> sysMultiOrgCode = new ArrayList<String>();
//		if(list==null || list.size()==0) {
//			//当前用户无部门
//			//sysMultiOrgCode.add("0");
//		}else if(list.size()==1) {
//			sysMultiOrgCode.add(list.get(0).getOrgCode());
//		}else {
//			info.setOneDepart(false);
//			for (SysDepart dpt : list) {
//				sysMultiOrgCode.add(dpt.getOrgCode());
//			}
//		}
//		info.setSysMultiOrgCode(sysMultiOrgCode);
//
//		return info;
//	}
//
//	// 根据部门Id查询
//	@Override
//	public IPage<SysUser> getUserByDepId(Page<SysUser> page, String departId,String username) {
//		return userMapper.getUserByDepId(page, departId,username);
//	}
//
//
//	// 根据角色Id查询
//	@Override
//	public IPage<SysUser> getUserByRoleId(Page<SysUser> page, String roleId, String username) {
//		return userMapper.getUserByRoleId(page,roleId,username);
//	}
//
//
//	@Override
//	public void updateUserDepart(String username,String orgCode) {
//		baseMapper.updateUserDepart(username, orgCode);
//	}
//
//
//	@Override
//	public SysUser getUserByPhone(String phone) {
//		return userMapper.getUserByPhone(phone);
//	}
//
//
//	@Override
//	public SysUser getUserByEmail(String email) {
//		return userMapper.getUserByEmail(email);
//	}
//
//	@Override
//	@Transactional
//	public void addUserWithDepart(SysUser user, String selectedParts) {
////		this.save(user);  //保存角色的时候已经添加过一次了
//		if(oConvertUtils.isNotEmpty(selectedParts)) {
//			String[] arr = selectedParts.split(",");
//			for (String deaprtId : arr) {
//				SysUserDepart userDeaprt = new SysUserDepart(user.getId(), deaprtId);
//				sysUserDepartMapper.insert(userDeaprt);
//			}
//		}
//	}
//
//
//	@Override
//	@Transactional
//	@CacheEvict(value="loginUser_cacheRules", allEntries=true)
//	public void editUserWithDepart(SysUser user, String departs) {
//		this.updateById(user);  //更新角色的时候已经更新了一次了，可以再跟新一次
//		//先删后加
//		sysUserDepartMapper.delete(new QueryWrapper<SysUserDepart>().lambda().eq(SysUserDepart::getUserId, user.getId()));
//		if(oConvertUtils.isNotEmpty(departs)) {
//			String[] arr = departs.split(",");
//			for (String departId : arr) {
//				SysUserDepart userDepart = new SysUserDepart(user.getId(), departId);
//				sysUserDepartMapper.insert(userDepart);
//			}
//		}
//	}


	/**
	   * 校验用户是否有效
	 * @param sysUser
	 * @return
	 */
	@Override
	public Result<?> checkUserIsEffective(SysUser sysUser) {
		Result<?> result = new Result<Object>();
		//情况1：根据用户信息查询，该用户不存在
		if (sysUser == null) {
			result.error500("该用户不存在，请注册");
			sysBaseAPI.addLog("用户登录失败，用户不存在！", CommonConstant.LOG_TYPE_1, null);
			return result;
		}
		//情况2：根据用户信息查询，该用户已注销
		if (CommonConstant.DEL_FLAG_1.toString().equals(sysUser.getDelFlag())) {
			sysBaseAPI.addLog("用户登录失败，用户名:" + sysUser.getUsername() + "已注销！", CommonConstant.LOG_TYPE_1, null);
			result.error500("该用户已注销");
			return result;
		}
		//情况3：根据用户信息查询，该用户已冻结
		if (CommonConstant.USER_FREEZE.equals(sysUser.getStatus())) {
			sysBaseAPI.addLog("用户登录失败，用户名:" + sysUser.getUsername() + "已冻结！", CommonConstant.LOG_TYPE_1, null);
			result.error500("该用户已冻结");
			return result;
		}
		return result;
	}

//	/**add by qihongyan 2019-09-27
//	   * 根据用户账号名获取用户真实姓名
//	 * @param usernamelist：用户账号名称集合
//	 * @return 用户的真实姓名集合
//	 */
//	@Override
//	public List<String> getRealNamesByNames(List<String> usernamelist) {
//		// TODO Auto-generated method stub
//		return userMapper.getRealNamesByNames(usernamelist);
//
//	}
//
//	/**add by qihongyan 2019-09-27
//	   * 根据用户账号名获取用户真实姓名
//	 * @param username：用户账号名称
//	 * @return 用户的真实姓名
//	 */
//	@Override
//	public String getRealNameByName(String username) {
//		// TODO Auto-generated method stub
//		return userMapper.getRealNameByName(username);
//	}
//	/**add by tianlve 2019-12-23
//	 *根据用户id获取用户姓名
//	 */
//	@Override
//	public String getRealNameById(String userId) {
//		// TODO Auto-generated method stub
//		return userMapper.getRealNameById(userId);
//	}
//
//
//
//   //根据部门id或人员名称查询用户信息
//	@Override
//
//	public SysUser getUserByOrgDepIdOrname(String departId,String name) {
//		// TODO Auto-generated method stub
//		List<SysUser> listSysUser = userMapper.getUserByOrgDepIdOrname(Arrays.asList(departId),name);
//		return  listSysUser.size()==0?null:listSysUser.get(0);
//	}



	
	
}
