package com.example.m2e_user_allocation.service.Impl;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.example.m2e_user_allocation.entity.SysLog;
import com.example.m2e_user_allocation.mapper.SysLogMapper;
import com.example.m2e_user_allocation.service.ISysBaseAPI;
import com.util.IPUtils;
import com.util.SpringContextUtils;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 底层共通业务API，提供其他独立模块调用
 * @Author: scott
 * @Date:2019-4-20 
 * @Version:V1.0
 */
@Slf4j
@Service
public class SysBaseApiImpl implements ISysBaseAPI {
	public static final String DB_TYPE_MYSQL="MYSQL";
	public static final String DB_TYPE_ORACLE="ORACLE";
	public static final String DB_TYPE_POSTGRESQL="POSTGRESQL";
	public static final String DB_TYPE_SQLSERVER="SQLSERVER";
	public static String DB_TYPE = "";
	
	@Resource
	private SysLogMapper sysLogMapper;
//	@Autowired
//	private SysUserMapper userMapper;
//	@Autowired
//	private SysDepartMapper sysDepartMapper;
//	@Autowired
//	private SysUserRoleMapper sysUserRoleMapper;
//	@Autowired
//	private SysUserDepartMapper sysUserDepartMapper;
//	@Autowired
//	private ISysDictService sysDictService;
//	@Autowired
//	private ISysDepartService sysDepartService;
//	@Resource
//	private SysAnnouncementMapper sysAnnouncementMapper;
//	@Resource
//	private SysAnnouncementSendMapper sysAnnouncementSendMapper;
//	@Resource
//    private WebSocket webSocket;
//	@Autowired
//    private SysDictMapper sysDictMapper;
	
	@Override
	public void addLog(String LogContent, Integer logType, Integer operatetype) {
		SysLog sysLog = new SysLog();
		//注解上的描述,操作日志内容
		sysLog.setLogContent(LogContent);
		sysLog.setLogType(logType);
		sysLog.setOperateType(operatetype);

		//请求的方法名
		//请求的参数

		try {
			//获取request
			HttpServletRequest request = SpringContextUtils.getHttpServletRequest();
			//设置IP地址
			sysLog.setIp(IPUtils.getIpAddr(request));
		} catch (Exception e) {
			sysLog.setIp("127.0.0.1");
		}

		//获取登录用户信息
//		LoginUser sysUser = (LoginUser)SecurityUtils.getSubject().getPrincipal();
//		if(sysUser!=null){
//			sysLog.setUserid(sysUser.getUsername());
//			sysLog.setUsername(sysUser.getRealname());
//
//		}
		sysLog.setCreateTime(new Date());
		//保存系统日志
		sysLogMapper.insert(sysLog);
	}

//	@Override
//	public LoginUser getUserByName(String username) {
//		if(oConvertUtils.isEmpty(username)) {
//			return null;
//		}
//		LoginUser loginUser = new LoginUser();
//		SysUser sysUser = userMapper.getUserByName(username);
//		if(sysUser==null) {
//			return null;
//		}
//		try {
//			BeanUtils.copyProperties(sysUser, loginUser);
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return loginUser;
//	}
//
//	@Override
//	public List<String> getRolesByUsername(String username) {
//		return sysUserRoleMapper.getRoleByUserName(username);
//	}
//
//	@Override
//	public String getDatabaseType() throws SQLException {
//		DataSource dataSource = SpringContextUtils.getApplicationContext().getBean(DataSource.class);
//		return getDatabaseTypeByDataSource(dataSource);
//	}
//
//	@Override
//	public List<DictModel> queryDictItemsByCode(String code) {
//		return sysDictService.queryDictItemsByCode(code);
//	}
//
//	@Override
//	public List<DictModel> queryTableDictItemsByCode(String table, String text, String code) {
//		return sysDictService.queryTableDictItemsByCode(table, text, code);
//	}
//
//	@Override
//	public List<DictModel> queryAllDepartBackDictModel() {
//		return sysDictService.queryAllDepartBackDictModel();
//	}
//
//	@Override
//	public void sendSysAnnouncement(String fromUser, String toUser, String title, String msgContent) {
//		SysAnnouncement announcement = new SysAnnouncement();
//		announcement.setTitile(title);
//		announcement.setMsgContent(msgContent);
//		announcement.setSender(fromUser);
//		announcement.setPriority(CommonConstant.PRIORITY_M);
//		announcement.setMsgType(CommonConstant.MSG_TYPE_UESR);
//		announcement.setSendStatus(CommonConstant.HAS_SEND);
//		announcement.setSendTime(new Date());
//		announcement.setMsgCategory(CommonConstant.MSG_CATEGORY_2);
//		announcement.setDelFlag(String.valueOf(CommonConstant.DEL_FLAG_0));
//		sysAnnouncementMapper.insert(announcement);
//		// 2.插入用户通告阅读标记表记录
//		String userId = toUser;
//		String[] userIds = userId.split(",");
//		String anntId = announcement.getId();
//		for(int i=0;i<userIds.length;i++) {
//			if(oConvertUtils.isNotEmpty(userIds[i])) {
//				SysUser sysUser = userMapper.getUserByName(userIds[i]);
//				if(sysUser==null) {
//					continue;
//				}
//				SysAnnouncementSend announcementSend = new SysAnnouncementSend();
//				announcementSend.setAnntId(anntId);
//				announcementSend.setUserId(sysUser.getId());
//				announcementSend.setReadFlag(CommonConstant.NO_READ_FLAG);
//				sysAnnouncementSendMapper.insert(announcementSend);
//				JSONObject obj = new JSONObject();
//		    	obj.put("cmd", "user");
//		    	obj.put("userId", sysUser.getId());
//				obj.put("msgId", announcement.getId());
//				obj.put("msgTxt", announcement.getTitile());
//		    	webSocket.sendOneMessage(sysUser.getId(), obj.toJSONString());
//			}
//		}
//
//	}
//	/**
//	 * 获取数据库类型
//	 * @param dataSource
//	 * @return
//	 * @throws SQLException
//	 * @throws DBException
//	 */
//	private String getDatabaseTypeByDataSource(DataSource dataSource) throws SQLException{
//		if("".equals(DB_TYPE)) {
//			Connection connection = dataSource.getConnection();
//			try {
//				DatabaseMetaData md = connection.getMetaData();
//				String dbType = md.getDatabaseProductName().toLowerCase();
//				if(dbType.indexOf("mysql")>=0) {
//					DB_TYPE = DB_TYPE_MYSQL;
//				}else if(dbType.indexOf("oracle")>=0) {
//					DB_TYPE = DB_TYPE_ORACLE;
//				}else if(dbType.indexOf("sqlserver")>=0||dbType.indexOf("sql server")>=0) {
//					DB_TYPE = DB_TYPE_SQLSERVER;
//				}else if(dbType.indexOf("postgresql")>=0) {
//					DB_TYPE = DB_TYPE_POSTGRESQL;
//				}else {
//					throw new JeecgBootException("数据库类型:["+dbType+"]不识别!");
//				}
//			} catch (Exception e) {
//				log.error(e.getMessage(), e);
//			}finally {
//				connection.close();
//			}
//		}
//		return DB_TYPE;
//
//	}
//
//	@Override
//	public List<DictModel> queryAllDict() {
//		// 查询并排序
//		QueryWrapper<SysDict> queryWrapper = new QueryWrapper<SysDict>();
//		queryWrapper.orderByAsc("create_time");
//		List<SysDict> dicts = sysDictService.list(queryWrapper);
//		// 封装成 model
//		List<DictModel> list = new ArrayList<DictModel>();
//		for (SysDict dict : dicts) {
//			list.add(new DictModel(dict.getDictCode(), dict.getDictName()));
//		}
//
//		return list;
//	}
//
//	/**
//	 * 根据部门id查询用户id集合
//	 */
//	@Override
//	public List<String> queryUserIdsByDepartId(String departId) {
//		LambdaQueryWrapper<SysUserDepart> queryUDep = new LambdaQueryWrapper<SysUserDepart>();
//		queryUDep.eq(SysUserDepart::getDepId, departId);
//		List<String> userIdList = new ArrayList<>();
//		List<SysUserDepart> uDepList = sysUserDepartMapper.selectList(queryUDep);
//		if(uDepList != null && uDepList.size() > 0) {
//			for(SysUserDepart uDep : uDepList) {
//				userIdList.add(uDep.getUserId());
//			}
//		}
//		return userIdList;
//	}
//
//	/**
//	 * 根据角色id查询用户id集合
//	 */
//	@Override
//	public List<String> queryUserIdsByRoleId(String roleId) {
//		LambdaQueryWrapper<SysUserRole> queryURole = new LambdaQueryWrapper<SysUserRole>();
//		queryURole.eq(SysUserRole::getRoleId, roleId);
//		List<String> userIdList = new ArrayList<>();
//		List<SysUserRole> uRoleList = sysUserRoleMapper.selectList(queryURole);
//		if(uRoleList != null && uRoleList.size() > 0) {
//			for(SysUserRole uRole : uRoleList) {
//				userIdList.add(uRole.getUserId());
//			}
//		}
//		return userIdList;
//	}
//
//
//	//根据部门id获取部门名称
//	@Override
//	public String queryDepartNameById(String departId) {
//		String name = "";
//		SysDepart sysDepart = sysDepartMapper.selectById(departId);
//		if(sysDepart != null) {
//			name = sysDepart.getDepartName();
//		}
//		return name;
//	}
//
//	@Override
//	public Map<String,Object> deploymentProcessDef(Integer pageNo, Integer pageSize, String name ,String subOrgId) {
//		// TODO Auto-generated method stub
//		Page<SysUser> page = new Page<SysUser>(pageNo, pageSize);
//		List<SysUser> list =null;
//		List<SysUser> listcount =null;
//		if(subOrgId !=null && !"".equals(subOrgId)) {
//			list = userMapper.queryUserByOrgUserIdsAndName(name,subOrgId, null,(pageNo-1)*pageSize,pageSize);
//			listcount = userMapper.queryUserByOrgUserIdsAndName(name,subOrgId, null,null,null);
//
//
//		}else {
//			list = userMapper.queryUserByUserIdsAndName(name, null,(pageNo-1)*pageSize,pageSize);
//			listcount = userMapper.queryUserByUserIdsAndName(name, null,null,null);
//		}
////		List<SysUser> listcount = userMapper.queryUserByUserIdsAndName(name,subOrgId, null,null,null);
//		Map<String,Object> maps = new HashMap<String,Object>();
//		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
//		for (SysUser sysUser : list) {
//			Map<String,Object> map = new HashMap<String,Object>();
//			map.put("id", sysUser.getId());
//			map.put("realname", sysUser.getRealname());
//			List<SysDepart> ListSysDepart = sysDepartMapper.queryUserDeparts(sysUser.getId());
//			String departName = "";
//			for (SysDepart sysDepart : ListSysDepart) {
//				if(departName.equals("")) {
//					departName = sysDepart.getDepartName();
//				}else {
//					departName += "," +sysDepart.getDepartName();
//				}
//			}
//			map.put("orgname", departName);
//			listMap.add(map);
//		}
//		maps.put("total", listcount.size());
//		maps.put("size", listMap.size());
//		maps.put("current", pageNo);
//		maps.put("records", listMap);
//		return maps;
//	}
//
//	/**
//	 * 获取一般流程审批人员
//	 * @param String name:用户名
//	 * @param String departId:部门id
//	 * @param String roleId:角色id
//	 * @param String json:过滤人员的条件
//	 * @param String removeUserId:去除对应用户id
//	 * @return
//	 */
//	@Override
//	public Map<String,Object> getApprover(Integer pageNo, Integer pageSize, String name ,
//			String subOrgId,String roleId,String removeUserId) {
//		// TODO Auto-generated method stub
//		List<String> listUserIds = new ArrayList<String>();
//		List<SysUser> list =null;
//		List<SysUser> listcount =null;
//
//		//根据部门获取对应用户信息
//		if(subOrgId != null && !"".equals(subOrgId)){
//			listUserIds.addAll(queryUserIdsByDepartId(subOrgId));
//		}
//		//根据角色获取对应用户信息
//		if(roleId != null && !"".equals(roleId)){
//			listUserIds.addAll(queryUserIdsByRoleId(roleId));
//			//去重
//			HashSet<String> h = new HashSet<String>(listUserIds);
//			listUserIds.clear();
//			listUserIds.addAll(h);
//		}
//
//		//滤掉三种人或已进行审批的人员
//		if(!"".equals(removeUserId)) {
//			String[] ids = removeUserId.split(",");
//			for(int i = 0;i < ids.length;i++){
//				if(listUserIds.contains(ids[i])){
//					listUserIds.remove(ids[i]);
//				}
//			}
//		}
//
//		if(listUserIds.size() > 0) {
//			list = userMapper.queryUserByIdsAndName(name, listUserIds,(pageNo-1)*pageSize,pageSize);
//			listcount = userMapper.queryUserByIdsAndName(name,listUserIds,null,null);
//		}else {
//			list = userMapper.queryUserByIdsAndName(name, listUserIds,(pageNo-1)*pageSize,pageSize);
//			listcount = userMapper.queryUserByIdsAndName(name,null,null,null);
//		}
//
//
//		Map<String,Object> maps = new HashMap<String,Object>();
//		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
//		for (SysUser sysUser : list) {
//			Map<String,Object> map = new HashMap<String,Object>();
//			map.put("id", sysUser.getId());
//			map.put("realname", sysUser.getRealname());
//			List<SysDepart> ListSysDepart = sysDepartMapper.queryUserDeparts(sysUser.getId());
//			String departName = "";
//			for (SysDepart sysDepart : ListSysDepart) {
//				if(departName.equals("")) {
//					departName = sysDepart.getDepartName();
//				}else {
//					departName += "," +sysDepart.getDepartName();
//				}
//			}
//			map.put("orgname", departName);
//			listMap.add(map);
//		}
//		maps.put("total", listcount.size());
//		maps.put("size", listMap.size());
//		maps.put("current", pageNo);
//		maps.put("records", listMap);
//		return maps;
//	}
//
//	@Override
//	public List<Map<String,String>> queryOrgList(String organtype) {
//		List<SysDepart> queryOrgList = sysDepartService.queryOrgList(organtype);
//		List<Map<String,String>> listMap = new ArrayList<Map<String,String>>();
//		for (SysDepart sysDepart : queryOrgList) {
//			Map<String, String> returnMap;
//			try {
//				returnMap = (Map<String, String> )BeanUtils.describe(sysDepart);
//				listMap.add(returnMap);
//			} catch (IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvocationTargetException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (NoSuchMethodException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return listMap;
//	}
//
//	@Override
//	public List<Map<String, Object>> queryUserByUserIds(String ids) {
//		// TODO Auto-generated method stub
//		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
//		String[] idStrs = ids.split(",");
//		List<String> usernamelist = new ArrayList<String>(Arrays.asList(idStrs));
//		List<SysUser> list = userMapper.queryUserByUserIds(usernamelist);
//		if(list.size() > 0) {
//			for (int i = 0; i < list.size(); i++) {
//				Map<String, Object> map = new HashMap<String, Object>();
//				map.put("id", list.get(i).getId());
//				map.put("realname", list.get(i).getRealname());
//				listMap.add(map);
//			}
//		}
//		return listMap;
//	}
//
//	/**
//	 * 通过查询指定code 获取字典值text
//	 * @param code
//	 * @param key
//	 * @return
//	 */
//
//	@Override
//	public String queryDictTextByKey(String code, String key) {
//		log.info("无缓存dictText的时候调用这里！");
//		return sysDictMapper.queryDictTextByKey(code, key);
//	}
//
//	/**
//	 * 消息发送
//	 * @param userIds 消息接收人
//	 * @param jsonObject 消息内容
//	 * @return
//	 */
//	@Override
//	public Result<String> sendMoreMessage(String[] userIds, JSONObject sendMessage) {
//		Result<String> result = new Result<String>();
//    	//移除sendMessage中的消息接收人
//		sendMessage.remove("approver");
//    	JSONObject obj = new JSONObject();
//    	obj.put("cmd", "menuNotice");//消息类型，定义为模块所要推送的消息
//		obj.put("msgId", userIds);
//		obj.put("msgTxt", sendMessage);
//        webSocket.sendMoreMessage(userIds, obj.toJSONString());
//        result.setResult("群发");
//        return result;
//	}
//
//	/**
//	 * 电站父级id获取全部子部门id
//	 */
//	@Override
//	public List<String> getDepartListbypid(String subId){
//		List<String> stringList = new ArrayList<String>();
//		List<SysDepart> queryOrgListbypid = sysDepartMapper.queryOrgListbypid(subId,null);
//		for (SysDepart sysDepart : queryOrgListbypid) {
//			String id = sysDepart.getId();
//			stringList.add(id);
//		}
//		return stringList;
//	}
//
//	@Override
//	public List<Map<String, Object>> querySysDepartNameAndIdList(String org_type) {
//		// TODO Auto-generated method stub
//		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
//		List<SysDepart> list = sysDepartMapper.queryOrgList(org_type);
//		for (SysDepart sysDepart : list) {
//			Map<String,Object> map = new HashMap<String,Object>();
//			map.put("id", sysDepart.getId());
//			map.put("name", sysDepart.getDepartName());
//			listMap.add(map);
//		}
//		return listMap;
//	}
//
//	@Override
//	public List<Map<String, String>> queryOrgByTypeList(String org_type) {
//		List<SysDepart> queryOrgList = sysDepartMapper.queryOrgByTypeList(org_type);
//		List<Map<String,String>> listMap = new ArrayList<Map<String,String>>();
//		for (SysDepart sysDepart : queryOrgList) {
//			Map<String, String> returnMap;
//			try {
//				returnMap = (Map<String, String> )BeanUtils.describe(sysDepart);
//				listMap.add(returnMap);
//			} catch (IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvocationTargetException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (NoSuchMethodException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return listMap;
//	}
//
//	@Override
//	public Map<String, String> queryDepartById(String suborgId) {
//		// TODO Auto-generated method stub
//		Map<String, String> returnMap = null;
//		try {
//			returnMap = (Map<String, String> )BeanUtils.describe(sysDepartService.getById(suborgId));
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return returnMap;
//	}
//
//
//	@Override
//	public Map<String, Object> getApprover(String subOrgId, String roleId) {
//		// TODO Auto-generated method stub
//		List<String> listUserIds = new ArrayList<String>();
//		List<SysUser> list =null;
//		List<SysUser> listcount =null;
//
//		//根据部门获取对应用户信息
//		if(subOrgId != null && !"".equals(subOrgId)){
//			listUserIds.addAll(queryUserIdsByDepartId(subOrgId));
//		}
//		//根据角色获取对应用户信息
//		if(roleId != null && !"".equals(roleId)){
//			listUserIds.addAll(queryUserIdsByRoleId(roleId));
//			//去重
//			HashSet<String> h = new HashSet<String>(listUserIds);
//			listUserIds.clear();
//			listUserIds.addAll(h);
//		}
//
//
//		if(listUserIds.size() > 0) {
//			list = userMapper.queryUserByIdsAndNames(listUserIds);
//			listcount = userMapper.queryUserByIdsAndNames(listUserIds);
//		}else {
//			list = userMapper.queryUserByIdsAndNames(listUserIds);
//			listcount = userMapper.queryUserByIdsAndNames(null);
//		}
//
//
//		Map<String,Object> maps = new HashMap<String,Object>();
//		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
//		for (SysUser sysUser : list) {
//			Map<String,Object> map = new HashMap<String,Object>();
//			map.put("id", sysUser.getId());
//			map.put("realname", sysUser.getRealname());
//			List<SysDepart> ListSysDepart = sysDepartMapper.queryUserDeparts(sysUser.getId());
//			String departName = "";
//			for (SysDepart sysDepart : ListSysDepart) {
//				if(departName.equals("")) {
//					departName = sysDepart.getDepartName();
//				}else {
//					departName += "," +sysDepart.getDepartName();
//				}
//			}
//			map.put("orgname", departName);
//			listMap.add(map);
//		}
//		maps.put("total", listcount.size());
//		maps.put("size", listMap.size());
//		maps.put("records", listMap);
//		return maps;
//	}
//
//	@Override
//	public List<Map<String, Object>> getOrgTeam(String departId, String type) {
//		// TODO Auto-generated method stub
//		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
//		List<SysDepart> orgTremList = sysDepartMapper.queryOrgListbypid(departId,"4");
//		orgTremList.forEach(sysDepart -> listMap.add(BeanMap.create(sysDepart)));
//		return listMap;
//
//	}
//
//	@Override
//	public List<Map<String, String>> queryParentOrgList(String suborgId) {
//		List<SysDepart> queryOrgList = sysDepartService.queryOrgList(suborgId);
//		if(queryOrgList.size()>0) {
//			queryOrgList.add(0,sysDepartService.queryParentOrg(queryOrgList.get(0).getParentId()));
//		}
//		List<Map<String,String>> listMap = new ArrayList<Map<String,String>>();
//		for (SysDepart sysDepart : queryOrgList) {
//			Map<String, String> returnMap;
//			try {
//				returnMap = (Map<String, String> )BeanUtils.describe(sysDepart);
//				listMap.add(returnMap);
//			} catch (IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvocationTargetException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (NoSuchMethodException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return listMap;
//	}


}
