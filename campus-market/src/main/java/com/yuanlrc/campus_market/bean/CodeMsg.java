package com.yuanlrc.campus_market.bean;
/**
 * 错误码统一处理类，所有的错误码统一定义在这里
 * @author Administrator
 *
 */
public class CodeMsg {

	private int code;//错误码, error operation code
	
	private String msg;//错误信息, error message
	
	/**
	 * 构造函数私有化即单例模式
	 * @param code
	 * @param msg
	 */
	private CodeMsg(int code,String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public int getCode() {
		return code;
	}



	public void setCode(int code) {
		this.code = code;
	}



	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	//通用错误码定义 general definition of error message
	//处理成功消息码
	public static CodeMsg SUCCESS = new CodeMsg(0, "Success");
	//非法数据错误码
	public static CodeMsg DATA_ERROR = new CodeMsg(-1, "Illegal data");
	public static CodeMsg CPACHA_EMPTY = new CodeMsg(-2, "Captcha cannot be empty");
	public static CodeMsg VALIDATE_ENTITY_ERROR = new CodeMsg(-3, "");
	public static CodeMsg SESSION_EXPIRED = new CodeMsg(-4, "The session has expired, please refresh the page and try again.");
	public static CodeMsg CPACHA_ERROR = new CodeMsg(-5, "Error in verification code");
	public static CodeMsg USER_SESSION_EXPIRED = new CodeMsg(-6, "Not yet log in or the session has expired. Please log in again.");
	public static CodeMsg UPLOAD_PHOTO_SUFFIX_ERROR = new CodeMsg(-7, "The image format is incorrect.");
	public static CodeMsg UPLOAD_PHOTO_ERROR = new CodeMsg(-8, "Image upload error.");
	
	
	//后台管理类错误码
	//用户管理类错误
	public static CodeMsg ADMIN_USERNAME_EMPTY = new CodeMsg(-2000, "Username cannot be empty.");
	public static CodeMsg ADMIN_PASSWORD_EMPTY = new CodeMsg(-2001, "Password cannot be empty.");
	public static CodeMsg ADMIN_NO_RIGHT = new CodeMsg(-2002, "The role does not have this permission.");
	
	//登录类错误码
	public static CodeMsg ADMIN_USERNAME_NO_EXIST = new CodeMsg(-3000, "The username does not exist.");
	public static CodeMsg ADMIN_PASSWORD_ERROR = new CodeMsg(-3001, "Incorrect password.");
	public static CodeMsg ADMIN_USER_UNABLE = new CodeMsg(-3002, "This account has been frozen, please contact the administrator.");
	public static CodeMsg ADMIN_USER_ROLE_UNABLE = new CodeMsg(-3003, "The status of the role  is not available, please contact the administrator.");
	public static CodeMsg ADMIN_USER_ROLE_AUTHORITES_EMPTY = new CodeMsg(-3004, "No permission is available for this user's role, please contact the administrator.");
	
	//后台菜单管理类错误码
	public static CodeMsg ADMIN_MENU_ADD_ERROR = new CodeMsg(-4000, "Menu failed to be added, please contact the administrator.");
	public static CodeMsg ADMIN_MENU_EDIT_ERROR = new CodeMsg(-4001, "Menu edit failed, please contact the administrator.");
	public static CodeMsg ADMIN_MENU_ID_EMPTY = new CodeMsg(-4002, "The menu ID cannot be empty.");
	public static CodeMsg ADMIN_MENU_ID_ERROR = new CodeMsg(-4003, "Wrong menu ID.");
	public static CodeMsg ADMIN_MENU_DELETE_ERROR = new CodeMsg(-4004, "There are sub-menus under this menu which are not allowed to be deleted.");
	//后台角色管理类错误码
	public static CodeMsg ADMIN_ROLE_ADD_ERROR = new CodeMsg(-5000, "Role addition failed, please contact the administrator.");
	public static CodeMsg ADMIN_ROLE_NO_EXIST = new CodeMsg(-5001, "The role does not exist.");
	public static CodeMsg ADMIN_ROLE_EDIT_ERROR = new CodeMsg(-5002, "Role edit failed, , please contact the administrator.");
	public static CodeMsg ADMIN_ROLE_DELETE_ERROR = new CodeMsg(-5003, "User information exists under this role and cannot be deleted.");
	//后台用户管理类错误码
	public static CodeMsg ADMIN_USER_ROLE_EMPTY = new CodeMsg(-6000, "Please select the role to the user.");
	public static CodeMsg ADMIN_USERNAME_EXIST = new CodeMsg(-6001, "This username already exists, please try another one.");
	public static CodeMsg ADMIN_USE_ADD_ERROR = new CodeMsg(-6002, "User failed to add, please contact the administrator.");
	public static CodeMsg ADMIN_USE_NO_EXIST = new CodeMsg(-6003, "User does not exist.");
	public static CodeMsg ADMIN_USE_EDIT_ERROR = new CodeMsg(-6004, "User edit failed, please contact the administrator.");
	public static CodeMsg ADMIN_USE_DELETE_ERROR = new CodeMsg(-6005, "This user has associated data and is not allowed to be deleted.");
	
	//后台用户修改密码类错误码
	public static CodeMsg ADMIN_USER_UPDATE_PWD_ERROR = new CodeMsg(-7000, "Old password incorrect.");
	public static CodeMsg ADMIN_USER_UPDATE_PWD_EMPTY = new CodeMsg(-7001, "The new password cannot be empty");
	
	//后台用户修改密码类错误码
	public static CodeMsg ADMIN_DATABASE_BACKUP_NO_EXIST = new CodeMsg(-8000, "Backup record does not exist.");
	
	//后台物品及分类管理类错误码
	public static CodeMsg ADMIN_GOODSCATEGORY_ADD_ERROR = new CodeMsg(-9000, "Category addition failed, please contact the administrator.");
	public static CodeMsg ADMIN_GOODSCATEGORY_EDIT_ERROR = new CodeMsg(-9001, "Category edit failed, please contact administrator.");
	public static CodeMsg ADMIN_GOODSCATEGORY_DELETE_ERROR = new CodeMsg(-9002, "There are subcategories or items under this category. Deletion is not allowed, please delete the subcategories or items first before proceeding.");
	public static CodeMsg ADMIN_GOODS_NO_EXIST = new CodeMsg(-9003, "Item does not exist.");
	public static CodeMsg ADMIN_GOODS_STATUS_NO_CHANGE = new CodeMsg(-9004, "The status of the item has not changed.");
	public static CodeMsg ADMIN_GOODS_STATUS_ERROR = new CodeMsg(-9005, "Item status error.");
	public static CodeMsg ADMIN_GOODS_EDIT_ERROR = new CodeMsg(-9006, "Item status edit failed, please contact an administrator.");
	public static CodeMsg ADMIN_GOODS_STATUS_UNABLE = new CodeMsg(-9007, "Item status cannot be edited (sold items cannot be shelved).");
	public static CodeMsg ADMIN_GOODS_DELETE_ERROR = new CodeMsg(-9008, "This item has a comment or report message and is not allowed to be deleted. Please delete the comment or report message before proceeding.");
	
	//后台学生管理
	public static CodeMsg ADMIN_STUDENT_NO_EXIST = new CodeMsg(-9100, "This student does not exist.");
	public static CodeMsg ADMIN_STUDENT_STATUS_NO_CHANGE = new CodeMsg(-9101, "No change in the student status.");
	public static CodeMsg ADMIN_STUDENT_STATUS_ERROR = new CodeMsg(-9102, "Student status error.");
	public static CodeMsg ADMIN_STUDENT_EDIT_ERROR = new CodeMsg(-9103, "Student editing errors, please contact an administrator.");
	public static CodeMsg ADMIN_STUDENT_DELETE_ERROR = new CodeMsg(-9104, "There is associated data under this student (items, requested items, comments, reported information, etc.), please delete the associated data before proceeding.");
	
	//后台友情链接管理
	public static CodeMsg ADMIN_NEWS_ADD_ERROR = new CodeMsg(-9200, "Please contact the administrator if the link failed to be added.");
	public static CodeMsg ADMIN_NEWS_EDIT_ERROR = new CodeMsg(-9201, "Please contact the administrator if the link failed to be added.");
	//后台友情链接管理
	public static CodeMsg ADMIN_FRIENDLINK_ADD_ERROR = new CodeMsg(-9300, "Please contact the administrator if the link failed to be added.");
	public static CodeMsg ADMIN_FRIENDLINK_EDIT_ERROR = new CodeMsg(-9301, "Please contact the administrator if the link failed to be added.");
	
	//网站设置
	public static CodeMsg ADMIN_SITESETTING_EDIT_ERROR = new CodeMsg(-9400, "Site setup failed, please contact the administrator.");
	
	//前端用户登录注册类错误码
	public static CodeMsg HOME_STUDENT_REGISTER_SN_EXIST = new CodeMsg(-10000, "This student number already exists, please do not register again.");
	public static CodeMsg HOME_STUDENT_REGISTER_ERROR = new CodeMsg(-10001, "Registration failed, please contact the administrator.");
	public static CodeMsg HOME_STUDENT_SN_NO_EXIST = new CodeMsg(-10002, "This student number does not exist.");
	public static CodeMsg HOME_STUDENT_PASSWORD_ERROR = new CodeMsg(-10003, "Wrong password.");
	public static CodeMsg HOME_STUDENT_UNABLE = new CodeMsg(-10003, "This user has been frozen, please contact the administrator.");
	//前端用户中心错误码
	public static CodeMsg HOME_STUDENT_EDITINFO_ERROR = new CodeMsg(-20000, "Basic information change failed, please contact the administrator.");
	public static CodeMsg HOME_STUDENT_EDITPWD_OLD_ERROR = new CodeMsg(-20001, "Original password is wrong.");
	//前端用户发布物品错误码
	public static CodeMsg HOME_STUDENT_PUBLISH_ERROR = new CodeMsg(-30000, "Item publish failed, please contact the administrator.");
	public static CodeMsg HOME_STUDENT_GOODS_EDIT_ERROR = new CodeMsg(-30001, "Item edit has failed, please contact the administrator.");
	public static CodeMsg HOME_STUDENT_GOODS_NO_EXIST = new CodeMsg(-30002, "Item does not exist.");
	public static CodeMsg HOME_STUDENT_PUBLISH_CATEGORY_EMPTY = new CodeMsg(-30003, "Please select an item category.");
	//前端用户举报物品
	public static CodeMsg HOME_STUDENT_REPORT_GOODS_ERROR = new CodeMsg(-40000, "Report failure, please contact an administrator.");
	public static CodeMsg HOME_STUDENT_REPORTED_GOODS = new CodeMsg(-40001, "You have already reported this item, please do not report it again.");
	public static CodeMsg HOME_STUDENT_REPORTED_NO_EXIST = new CodeMsg(-40002, "Reported information does not exist.");
	//前端用户评论
	public static CodeMsg HOME_STUDENT_COMMENT_ADD_ERROR = new CodeMsg(-50000, "Comment failed, please contact administrator.");
}
